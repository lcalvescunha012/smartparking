package com.smartparking.mappers;

import com.smartparking.dto.ParquimetroDTO;
import com.smartparking.entities.ParquimetroEntity;
import org.springframework.stereotype.Component;

@Component
public class ParquimetroMapper {

    public ParquimetroDTO toDTO(ParquimetroEntity entity){
        return new ParquimetroDTO(
                entity.getParquimetroId(),
                entity.getZonaId(),
                entity.getStatus()
        );
    }

    public ParquimetroEntity toEntity (ParquimetroDTO dto){
        return new ParquimetroEntity(
                dto.parquimetroId(),
                dto.zonaId(),
                dto.status()
        );
    }
}
