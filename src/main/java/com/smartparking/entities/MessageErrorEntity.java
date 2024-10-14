package com.smartparking.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class MessageErrorEntity {

    private String error;

    private Integer status;

    private String message;

    private Instant date;
}
