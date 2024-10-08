package com.smartparking.mappers;

import com.smartparking.dto.ZonaDTO;
import com.smartparking.entities.ZonaEntity;
import org.springframework.stereotype.Component;

@Component
public class ZonaMapper implements GenericMapper {

    public ZonaDTO toDto(ZonaEntity zonaEntity) {
        return new ZonaDTO(
                zonaEntity.getIdZona(),
                zonaEntity.getNome(),
                zonaEntity.getLocalizacao().getCep(),
                zonaEntity.getLocalizacao(),
                zonaEntity.getVersion()
        );
    }

    public ZonaEntity toEntity(ZonaDTO zonaDTO) {
        return new ZonaEntity(
                zonaDTO.idZona(),
                zonaDTO.nome(),
                zonaDTO.localizacao(),
                zonaDTO.version()
        );
    }
}
