package com.smartparking.dto;

import com.smartparking.entities.LocalizacaoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.NotBlank;

public record ZonaDTO(
        @Schema(readOnly = true) String idZona,

        @NotBlank(message = "O nome da Zona precisa estar preenchido.") String nome,

        @NotBlank(message = "O CEP precisa estar preenchida.") String cep,

        @Schema(readOnly = true) LocalizacaoEntity localizacao
) {}
