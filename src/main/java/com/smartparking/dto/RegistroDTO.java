package com.smartparking.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RegistroDTO(
        @Schema(readOnly = true) String id,

        @NotBlank(message = "A placa precisa estar preenchida.")
        @Schema(example = "ONP5133")
        String veiculoId,

        @NotBlank(message = "A identificador do parquímetro precisa estar preenchido.")
        @Schema(example = "60c72b2f9b1e8c001f9b9d8b")
        String parquimetroId,

        @NotNull(message = "A data e hora de início não podem ser nulas.")
        @Schema(example = "2024-10-13T10:15:30")
        LocalDateTime dataHoraInicio,

        @Schema(example = "2024-10-13T12:00:00")
        LocalDateTime dataHoraFim,

        @Schema(example = "15.50", readOnly = true)
        BigDecimal valorPago
) {
}
