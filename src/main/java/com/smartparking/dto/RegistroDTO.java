package com.smartparking.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RegistroDTO(
        String id,

        // Campos obrigatórios em ambas operações (POST e PUT)
        @NotNull String veiculoId,
        @NotNull String parquimetroId,
        @NotNull LocalDateTime dataHoraInicio,

        // Opcional no POST, mas deve ser atualizado no PUT
        LocalDateTime dataHoraFim,
        BigDecimal valorPago
) {}
