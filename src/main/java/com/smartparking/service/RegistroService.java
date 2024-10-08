package com.smartparking.service;

import com.smartparking.dto.RegistroDTO;
import com.smartparking.entities.RegistroEntity;
import com.smartparking.exceptions.ExpectationFailedException;
import com.smartparking.exceptions.NotFoundException;
import com.smartparking.mappers.RegistroMapper;
import com.smartparking.repository.ParquimetroRepository;
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
    private final PagamentosService pagamentosService;
    private final ParquimetroRepository parquimetroRepository;

    @Transactional(readOnly = true)
    public Collection<RegistroDTO> findAll() {
        return registroRepository.findAll().stream().map(registroMapper::toDto).toList();
    }

    @Transactional(readOnly = true)
    public RegistroDTO findById(String id) {
        return registroMapper.toDto(registroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Registro não encontrado com o ID: " + id)));
    }

    @Transactional
    public RegistroDTO iniciarFluxoDeRegistro(RegistroDTO registroDTO) {
        val parquimetroId = registroDTO.parquimetroId();
        val parquimetro = parquimetroRepository.findById(parquimetroId)
                .orElseThrow(() -> new NotFoundException("Parquimetro não encontrado com o ID: " + parquimetroId));

        val statusParquimetro = parquimetro.getStatus().toUpperCase();
        if (statusParquimetro.equals("INATIVO")) {
            throw new ExpectationFailedException("O Parquimetro solicitado está inativo");
        }

        // Cria uma nova entidade de registro com os dados fornecidos no DTO
        RegistroEntity registro = registroMapper.toEntity(registroDTO);
        return registroMapper.toDto(registroRepository.save(registro));
    }

    @Transactional
    public RegistroDTO efetuarPagamento(String id, RegistroDTO registroDTO) {
        var registroAtualizado = registroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Registro não encontrado com o ID: " + id));

        var valorPago = pagamentosService.efetuarPagamento(registroDTO);

        // Atualiza a entidade com as informações de pagamento e data de fim
        registroAtualizado.setDataHoraFim(registroDTO.dataHoraFim());
        registroAtualizado.setValorPago(valorPago);

        return registroMapper.toDto(registroRepository.save(registroAtualizado));
    }

    @Transactional
    public void delete(String id) {
        registroRepository.deleteById(id);
    }
}
