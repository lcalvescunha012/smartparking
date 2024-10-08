package com.smartparking.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RegistroPutAndPostDTO(
        @NotNull String veiculoId,
        @NotNull String parquimetroId,
        @NotNull LocalDateTime dataHoraInicio,
        LocalDateTime dataHoraFim,
        BigDecimal valorPago) {
}
