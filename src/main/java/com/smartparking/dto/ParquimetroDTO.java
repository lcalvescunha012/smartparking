package com.smartparking.dto;

import com.smartparking.entities.ZonaEntity;
import jakarta.validation.constraints.NotBlank;

public record ParquimetroDTO (
        String parquimetroId,
        ZonaEntity zonaId,
        @NotBlank(message = "O status deve estar preenchido.")
        String status){
}
