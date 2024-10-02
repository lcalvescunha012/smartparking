package com.smartparking.mappers;

import com.smartparking.dto.PagamentosDTO;
import com.smartparking.entities.PagamentosEntity;
import org.springframework.stereotype.Component;

@Component
public class PagamentosMapper implements GenericMapper {

    public PagamentosDTO toDto(PagamentosEntity entity){
        return null;
    }

    public PagamentosEntity toEntity(PagamentosDTO dto){
        return null;
    }
}
