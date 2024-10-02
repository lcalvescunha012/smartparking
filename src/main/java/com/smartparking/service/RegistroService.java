package com.smartparking.service;

import com.smartparking.dto.RegistroDTO;
import com.smartparking.dto.RegistroPutAndPostDTO;
import com.smartparking.entities.RegistroEntity;
import com.smartparking.exceptions.NotFoundException;
import com.smartparking.mappers.RegistroMapper;
import com.smartparking.mappers.RegistroPutAndPostMapper;
import com.smartparking.repository.RegistroRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class RegistroService {

    private final RegistroRepository registroRepository;
    private final RegistroMapper registroMapper;
    private final RegistroPutAndPostMapper registroPutAndPostMapper;
    private final PagamentosService pagamentosService;

    @Transactional(readOnly = true)
    public Collection<RegistroDTO> findAll() {
        return registroRepository.findAll().stream().map(registroMapper::toDto).toList();
    }

    @Transactional(readOnly = true)
    public RegistroDTO findById(String id) {
        return registroMapper.toDto(registroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Registro não encontrado com o ID: " + id)));
    }

    // TODO: Aplicar logica para validar se parquimetro esta ativo ou não....Somente iniciar o cadastro caso o parquimetro esteja ativo
    @Transactional
    public RegistroDTO iniciarFluxoDeRegistro(RegistroPutAndPostDTO registroDTO) {
        val registro = new RegistroEntity();

        registro.setVeiculoId(registroDTO.veiculoId());
        registro.setParquimetroId(registroDTO.parquimetroId());
        registro.setDataHoraInicio(registroDTO.dataHoraInicio());

        return registroMapper.toDto(registroRepository.save(registro));
    }

    @Transactional
    public RegistroDTO efetuarPagamento(String id, RegistroPutAndPostDTO registroDTO) {

        var registroAtualizado = registroRepository.findById(id).orElseThrow(() -> new NotFoundException("Registro não encontrado com o ID: " + id));

        var valorPago = pagamentosService.efetuarPagamento(registroDTO);

        registroAtualizado.setDataHoraFim(registroDTO.dataHoraFim());
        registroAtualizado.setValorPago(valorPago);

        return registroMapper.toDto(registroRepository.save(registroAtualizado));
    }

    @Transactional
    public void delete(String id) {
        registroRepository.deleteById(id);
    }
}
