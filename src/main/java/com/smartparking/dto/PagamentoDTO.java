package com.smartparking.dto;

import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PagamentoDTO(
        ObjectId id,
        BigDecimal valor,
        LocalDateTime dataHora,
        VeiculoDTO veiculo,
        ParquimetroDTO parquimetro,
        Long version
){

    public PagamentoDTO(BigDecimal valor, LocalDateTime dataHora, VeiculoDTO veiculo, ParquimetroDTO parquimetro){
        this(null, valor, dataHora, veiculo, parquimetro, null);
    }
}
