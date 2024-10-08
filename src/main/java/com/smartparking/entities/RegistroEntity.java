package com.smartparking.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroEntity {

    public RegistroEntity(String veiculoId, String parquimetroId, LocalDateTime dataHoraInicio,
                          LocalDateTime dataHoraFim, BigDecimal valorPago) {
        this.veiculoId = veiculoId;
        this.parquimetroId = parquimetroId;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.valorPago = valorPago;
    }

    @Id
    private String id;
    private String veiculoId;
    private String parquimetroId;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private BigDecimal valorPago;

    @Version
    private Long version;
}
