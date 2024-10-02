package com.smartparking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import org.bson.types.ObjectId;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "pagamentos")
@AllArgsConstructor
@Data
public class PagamentosEntity {
    @Id
    private ObjectId id;
    private BigDecimal valor;
    private LocalDateTime dataHora;
    @DBRef
    private VeiculoEntity veiculoEntity;
    @DBRef
    private ParquimetroEntity parquimetroEntity;
    @Version
    private Long version;
}
