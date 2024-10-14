package com.smartparking.dto;

import com.smartparking.enums.ParquimetroStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record ParquimetroDTO(
        @Schema(readOnly = true) String parquimetroId,

        @NotBlank(message = "A zona ID precisa estar preenchida.") String zonaId,

        @NotBlank(message = "O status precisa estar preenchido.") ParquimetroStatus status
) {}
