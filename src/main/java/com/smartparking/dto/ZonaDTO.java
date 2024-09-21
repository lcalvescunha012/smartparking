package com.smartparking.dto;

import com.smartparking.entities.LocalizacaoEntity;
import org.hibernate.validator.constraints.NotBlank;

public record ZonaDTO(String idZona,
                      @NotBlank(message = "O nome da Zona tem que estar preenchido.") String nome,
                      LocalizacaoEntity localizacao) {
}
