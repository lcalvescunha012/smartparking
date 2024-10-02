package com.smartparking.service;

import com.google.gson.Gson;
import com.smartparking.dto.PagamentosDTO;
import com.smartparking.entities.PagamentosEntity;
import com.smartparking.mappers.PagamentosMapper;
import com.smartparking.repository.PagamentoRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PagamentosServiceTest {

    @Mock
    private PagamentosMapper mapper;

    @Mock
    private PagamentoRepository repository;

    @Mock
    private PagamentosEntity entity;

    @Mock
    private PagamentosDTO dto;

    @InjectMocks
    private PagamentosService pagamentosService;

    private final ObjectId dummyId = new ObjectId("64b7c3ecf2b3c82b8b4e91e8");
    private final BigDecimal dummyValue = new BigDecimal("1000");
    private final LocalDateTime dummyLocalData = LocalDateTime.now();

    @Test
    void findById() {

        // when(entity.getId()).thenReturn(dummyId);
        // when(entity.getValor()).thenReturn(dummyValue);
        // when(entity.getDataHora()).thenReturn(dummyLocalData);

        // when(dto.id()).thenReturn(dummyId);
        // when(dto.valor()).thenReturn(dummyValue);
        // when(dto.dataHora()).thenReturn(dummyLocalData);

        when(mapper.toDto(entity)).thenReturn(dto);

        when(repository.findById(any())).thenReturn(Optional.of(entity));

        var dto = pagamentosService.findById(dummyId);

        System.out.println(dto);
    }
}