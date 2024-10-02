package com.smartparking.dto;

import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PagamentosDTO(
    ObjectId id,
    BigDecimal valor,
    LocalDateTime dataHora,
    VeiculoDTO veiculo,
    ParquimetroDTO parquimetro,
    long version
){}
