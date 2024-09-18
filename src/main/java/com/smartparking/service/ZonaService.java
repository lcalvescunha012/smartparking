package com.smartparking.service;

import com.smartparking.dto.ZonaDTO;
import com.smartparking.entities.ZonaEntity;
import com.smartparking.mappers.ZonaMapper;
import com.smartparking.repository.ZonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ZonaService {

    private final ZonaRepository zonaRepository;
    private final ZonaMapper zonaMapper;

    public Collection<ZonaDTO> finaAll() {
        return zonaRepository.findAll().stream().map(zonaMapper::toDto).collect(Collectors.toList());
    }

    public ZonaDTO findById(String id) {
        return zonaMapper.toDto(zonaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Empresa " + id + " não encontrada.")));
    }

    public ZonaDTO update(String id, ZonaDTO zona) {
        ZonaEntity zonaAtualiza;
        ZonaDTO zonaDTO;
       // try {
            zonaAtualiza = zonaMapper.toEntity(findById(id));

            zonaAtualiza.setNome(zona.nome());
            zonaAtualiza.setLocalizacao(zona.localizacao());
            zonaDTO = zonaMapper.toDto(zonaAtualiza);
            save(zonaDTO);
       // } catch (Exception e) {
       //     throw new Exception("Usuário " + id + " não encontrado.");
       // }

        return zonaDTO;
    }

    public ZonaDTO save(ZonaDTO zonaDTO) {
        return zonaMapper.toDto(zonaRepository.save(zonaMapper.toEntity(zonaDTO)));
    }

    public void delete(String id) {
        zonaRepository.deleteById(id);
    }


}
