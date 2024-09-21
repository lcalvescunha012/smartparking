package com.smartparking.service;

import com.google.gson.Gson;
import com.smartparking.dto.ZonaDTO;
import com.smartparking.dto.ZonaPutAndPostDTO;
import com.smartparking.entities.LocalizacaoEntity;
import com.smartparking.entities.ZonaEntity;
import com.smartparking.exceptions.ZonaNotFoundException;
import com.smartparking.mappers.ZonaMapper;
import com.smartparking.repository.LocalizacaoRepository;
import com.smartparking.repository.ZonaRepository;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ZonaService {
    private final LocalizacaoRepository localizacaoRepository;
    private final ZonaRepository zonaRepository;
    private final ZonaMapper zonaMapper;

    public Collection<ZonaDTO> finaAll() {
        return zonaRepository.findAll().stream().map(zonaMapper::toDto).toList();
    }

    public ZonaDTO findById(String id) {
        return zonaMapper.toDto(zonaRepository.findById(id).orElseThrow(() -> new ZonaNotFoundException("Não foi possível encontrar a zona com o ID: " + id + ".")));
    }

    public ZonaDTO update(String id, ZonaPutAndPostDTO zona) {
        ZonaEntity zonaAtualiza;

        //Procurando o valor no banco
        zonaAtualiza = zonaMapper.toEntity(findById(id));

        //Fazendo a chamada da API externa e salvando no banco a nova localização
        LocalizacaoEntity localizacao = getLocalizacao(zona.cep());
        localizacao = localizacaoRepository.save(localizacao);

        zonaAtualiza.setNome(zona.nome());
        zonaAtualiza.setLocalizacao(localizacao);
        return zonaMapper.toDto(zonaRepository.save(zonaAtualiza));

    }

    private LocalizacaoEntity getLocalizacao(String cep) {
        LocalizacaoEntity localizacao = null;

        HttpGet request = new HttpGet("https://viacep.com.br/ws/" + cep.trim().replaceAll("\\D", "") + "/json/");

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
             CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                Gson gson = new Gson();
                localizacao = gson.fromJson(result, LocalizacaoEntity.class);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return localizacao;
    }

    public ZonaDTO save(ZonaPutAndPostDTO zonaPutAndPostDTO) {
        ZonaEntity zona = new ZonaEntity();
        //
        LocalizacaoEntity localizacao = getLocalizacao(zonaPutAndPostDTO.cep());
        localizacao = localizacaoRepository.save(localizacao);
        //
        zona.setNome(zonaPutAndPostDTO.nome());
        zona.setLocalizacao(localizacao);

        return zonaMapper.toDto(zonaRepository.save(zonaMapper.toEntity(zonaMapper.toDto(zona))));
    }

    public void delete(String id) {
        zonaRepository.deleteById(id);
    }


}
