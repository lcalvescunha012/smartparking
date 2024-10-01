package com.smartparking.mappers;

import com.smartparking.dto.PagamentosDTO;
import com.smartparking.entities.PagamentosEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PagamentosMapper extends GenericMapper {

    PagamentosDTO toDto(PagamentosEntity entity);
    PagamentosEntity toEntity(PagamentosDTO dto);
}
