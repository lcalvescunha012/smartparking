package com.smartparking.entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroEntity {

    @Id
    private ObjectId id;

    private String veiculoId;

    private String parquimetroId;

    private LocalDateTime dataHoraInicio;

    private LocalDateTime dataHoraFim;

    private BigDecimal valorPago;
}
