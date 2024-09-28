package com.smartparking.dto;

import com.smartparking.entities.LocalizacaoEntity;

public record ZonaDTO(String idZona, String nome, LocalizacaoEntity localizacao, Long version) {
}
