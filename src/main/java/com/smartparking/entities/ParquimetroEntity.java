package com.smartparking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParquimetroEntity {

    @Id
    private String parquimetroId;

    private ZonaEntity zonaId;

    private String status;

}
