package com.smartparking.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroEntity {

    @Id
    private String id;
    private String veiculoId;
    private String parquimetroId;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private double valorPago;

    @Version
    private Long version;
}
