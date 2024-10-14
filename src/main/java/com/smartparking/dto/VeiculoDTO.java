package com.smartparking.dto;

import com.smartparking.validations.ValidPlate;
import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.NotBlank;

public record VeiculoDTO(
        @ValidPlate(message = "A placa do veículo deve ser válida para o formato brasileiro ou Mercosul.")
        @NotBlank(message = "A placa precisa estar preenchida.")
        @Schema(example = "ABC1234")
        String placa,

        @NotBlank(message = "A marca precisa estar preenchida.")
        @Schema(example = "Fiat")
        String marca,

        @NotBlank(message = "O modelo precisa estar preenchido.")
        @Schema(example = "Palio")
        String modelo,

        @NotBlank(message = "A cor precisa estar preenchida.")
        @Schema(example = "Azul")
        String cor
) {}
