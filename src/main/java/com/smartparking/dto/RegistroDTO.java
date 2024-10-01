package com.smartparking.dto;

import java.time.LocalDateTime;

public record RegistroDTO(String id, String veiculoId, String parquimetroId,
                          LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim,
                          double valorPago, Long version) {
}
