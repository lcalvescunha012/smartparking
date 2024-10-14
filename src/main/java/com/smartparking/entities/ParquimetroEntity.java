package com.smartparking.entities;

import com.smartparking.enums.ParquimetroStatus;
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

    private String zonaId;

    private ParquimetroStatus status;
}
