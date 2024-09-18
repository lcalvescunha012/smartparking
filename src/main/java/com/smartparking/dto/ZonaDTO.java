package com.smartparking.dto;

import org.hibernate.validator.constraints.NotBlank;

public record ZonaDTO(String idZona,
                      @NotBlank(message = "O nome da Zona tem que estar preenchido.") String nome,
                      @NotBlank(message = "A localizacao tem que estar preenchida.") String localizacao) {
}
