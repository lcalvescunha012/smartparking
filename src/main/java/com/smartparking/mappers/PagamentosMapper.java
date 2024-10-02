package com.smartparking.mappers;

import com.smartparking.dto.PagamentosDTO;
import com.smartparking.entities.PagamentosEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PagamentosMapper implements GenericMapper {

    private final ParquimetroMapper parquimetroMapper;
    private final VeiculoMapper veiculoMapper;

    public PagamentosDTO toDto(PagamentosEntity entity) {
        return new PagamentosDTO (
            entity.getId(),
            entity.getValor(),
            entity.getDataHora(),
            veiculoMapper.toDto(entity.getVeiculoEntity()),
            parquimetroMapper.toDTO(entity.getParquimetroEntity()),
            entity.getVersion()
        );
    }

    public PagamentosEntity toEntity(PagamentosDTO dto) {
        return new PagamentosEntity(
            dto.id(),
            dto.valor(),
            dto.dataHora(),
            veiculoMapper.toEntity(dto.veiculo()),
            parquimetroMapper.toEntity(dto.parquimetro()),
            dto.version()
        );
    }

}
