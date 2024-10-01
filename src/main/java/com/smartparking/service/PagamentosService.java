package com.smartparking.service;

import com.smartparking.dto.PagamentosDTO;
import com.smartparking.entities.PagamentosEntity;
import com.smartparking.exceptions.NotFoundException;
import com.smartparking.mappers.PagamentosMapper;
import com.smartparking.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PagamentosService {

    private final PagamentosMapper mapper;
    private final PagamentoRepository repository;

    @Transactional(readOnly = true)
    public PagamentosDTO findById(ObjectId id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() ->
            new NotFoundException("error " + id + ".")
        ));
    }

    @Transactional(readOnly = true)
    public Page<PagamentosDTO> getAllByPagination(int page, int size) {
        var pageRequest = PageRequest.of(page, size);
        var pageEntity = repository.findAll(pageRequest);
        return pageEntity.map(mapper::toDto);
    }

    @Transactional
    public PagamentosDTO save(PagamentosDTO requestBody) {
        return mapper.toDto(repository.save(mapper.toEntity(requestBody)));
    }

    @Transactional
    public void delete(ObjectId id) {
        repository.deleteById(id);
    }

    @Transactional
    public void deleteAll() {
        repository.deleteAll();
    }

    @Transactional
    public PagamentosDTO update(ObjectId id, PagamentosDTO requestBody) {

        var dataToUpdate = repository.findById(id)
                .orElseThrow(()-> new NotFoundException("Não foi possível encontrar pagamento com o ID: " + id + "."));

        dataToUpdate = mapper.map(mapper.toEntity(requestBody), dataToUpdate, PagamentosEntity.class);

        return save(mapper.toDto(dataToUpdate));
    }

}
