package com.smartparking.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VeiculoEntity {

    @Id
    private String placa;
    private String marca;
    private String modelo;
    private String cor;


}