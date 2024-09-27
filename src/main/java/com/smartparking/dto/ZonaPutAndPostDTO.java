package com.smartparking.dto;

import org.hibernate.validator.constraints.NotBlank;

public record ZonaPutAndPostDTO(@NotBlank(message = "O nome da Zona tem que estar preenchido.") String nome,
                                @NotBlank(message = "O CEP tem que estar preenchida.") String cep) {
}
