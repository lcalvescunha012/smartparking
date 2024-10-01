package com.smartparking.service;

import com.smartparking.dto.ParquimetroDTO;
import com.smartparking.entities.ParquimetroEntity;
import com.smartparking.exceptions.NotFoundException;
import com.smartparking.mappers.ParquimetroMapper;
import com.smartparking.repository.ParquimetroRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ParquimetroService {

    private final ParquimetroRepository repository;
    private final ParquimetroMapper parquimetroMapper;


    @Transactional(readOnly = true)
    public Collection<ParquimetroDTO> findAll() {
        return repository.findAll().stream().map(parquimetroMapper::toDTO).toList();
    }


    @Transactional(readOnly = true)
    public ParquimetroDTO findById(String id) {
        return parquimetroMapper.toDTO(repository.findById(id).orElseThrow(() -> new NotFoundException("Não foi possível encontrar a zona com o ID: " + id + ".")));
    }

    @Transactional
    public ParquimetroDTO update(String id, ParquimetroDTO parquimetoDTO) {
        val parquimetroAtualizado = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Parquimetro não encontrado com o ID: " + id));

        parquimetroAtualizado.setParquimetroId(parquimetoDTO.parquimetroId());
        parquimetroAtualizado.setZonaId(parquimetoDTO.zonaId());
        parquimetroAtualizado.setStatus(parquimetoDTO.status());

        return parquimetroMapper.toDTO(repository.save(parquimetroAtualizado));
    }

    @Transactional
    public ParquimetroDTO save(ParquimetroDTO parquimetroDTO) {
        ParquimetroEntity parquimetro = new ParquimetroEntity();

        parquimetro.setZonaId(parquimetroDTO.zonaId());
        parquimetro.setParquimetroId(parquimetroDTO.parquimetroId());
        parquimetro.setStatus(parquimetroDTO.status());


        return parquimetroMapper.toDTO(repository.save(parquimetro));
    }

    @Transactional
    public void delete(String id) {
        repository.deleteById(id);
    }
}
