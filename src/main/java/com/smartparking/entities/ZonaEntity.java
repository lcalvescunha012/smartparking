package com.smartparking.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ZonaEntity {

    @Id
    private String idZona;

    private String nome;

    @DBRef
    private LocalizacaoEntity localizacao;
}
