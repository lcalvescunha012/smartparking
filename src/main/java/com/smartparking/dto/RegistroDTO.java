package com.smartparking.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RegistroDTO(String id, String veiculoId, String parquimetroId,
                          LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim,
                          BigDecimal valorPago, Long version) {
}
