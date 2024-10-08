package com.smartparking.dto;


import org.hibernate.validator.constraints.NotBlank;

public record VeiculoDTO(@NotBlank(message = "A placa precisa estar preenchida.") String placa,
                         @NotBlank(message = "A marca precisa estar preenchida.") String marca,
                         @NotBlank(message = "O modelo precisa estar preenchido.") String modelo,
                         @NotBlank(message = "A cor precisa estar preenchida.") String cor) {
}