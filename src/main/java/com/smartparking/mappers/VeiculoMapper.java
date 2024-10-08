package com.smartparking.mappers;

import com.smartparking.dto.VeiculoDTO;
import com.smartparking.entities.VeiculoEntity;
import org.springframework.stereotype.Component;

@Component
public class VeiculoMapper implements GenericMapper  {

    public VeiculoDTO toDto(VeiculoEntity veiculoEntity) {
        return new VeiculoDTO(
                veiculoEntity.getPlaca(),
                veiculoEntity.getMarca(),
                veiculoEntity.getModelo(),
                veiculoEntity.getCor()
        );
    }

    public VeiculoEntity toEntity(VeiculoDTO veiculoDTO) {
        return new VeiculoEntity(
                veiculoDTO.placa(),
                veiculoDTO.marca(),
                veiculoDTO.modelo(),
                veiculoDTO.cor()
        );
    }
}