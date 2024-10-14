package com.smartparking.mappers;

import com.smartparking.dto.PagamentoDTO;
import com.smartparking.entities.PagamentosEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PagamentosMapper implements GenericMapper {

    private final ParquimetroMapper parquimetroMapper;
    private final VeiculoMapper veiculoMapper;

    public PagamentoDTO toDto(PagamentosEntity entity) {
        return new PagamentoDTO(
            entity.getId(),
            entity.getValor(),
            entity.getDataHora(),
            veiculoMapper.toDto(entity.getVeiculoEntity()),
            parquimetroMapper.toDTO(entity.getParquimetroEntity())
        );
    }

    public PagamentosEntity toEntity(PagamentoDTO dto) {
        return new PagamentosEntity(
            dto.id(),
            dto.valor(),
            dto.dataHora(),
            veiculoMapper.toEntity(dto.veiculo()),
            parquimetroMapper.toEntity(dto.parquimetro())
        );
    }
}
