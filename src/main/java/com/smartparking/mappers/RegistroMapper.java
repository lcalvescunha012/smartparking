package com.smartparking.mappers;

import com.smartparking.dto.RegistroDTO;
import com.smartparking.entities.RegistroEntity;
import org.springframework.stereotype.Component;

@Component
public class RegistroMapper {

    public RegistroDTO toDto(RegistroEntity registroEntity) {
        return new RegistroDTO(
                registroEntity.getId(),
                registroEntity.getVeiculoId(),
                registroEntity.getParquimetroId(),
                registroEntity.getDataHoraInicio(),
                registroEntity.getDataHoraFim(),
                registroEntity.getValorPago()
        );
    }

    public RegistroEntity toEntity(RegistroDTO registroDTO) {
        return new RegistroEntity(
                registroDTO.veiculoId(),
                registroDTO.parquimetroId(),
                registroDTO.dataHoraInicio(),
                registroDTO.dataHoraFim(),
                registroDTO.valorPago()
        );
    }
}
