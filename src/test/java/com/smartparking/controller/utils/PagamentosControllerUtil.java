package com.smartparking.controller.utils;

import com.smartparking.dto.PagamentoDTO;
import com.smartparking.entities.MessageErrorEntity;
import lombok.experimental.UtilityClass;
import org.bson.types.ObjectId;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedModel;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@UtilityClass
public final class PagamentosControllerUtil {

    public static PagedModel<PagamentoDTO> getPageModelPagamentosDTO() {

        // Sample content
        List<PagamentoDTO> content = Arrays.asList (
                getPagamentosDTO( "64b7c3ecf2b3c82b8b4e91e8", new BigDecimal("1000"), LocalDateTime.now().plusSeconds(100)),
                getPagamentosDTO( "64b7c3ecf2b3c82b8b4e91e8", new BigDecimal("2000"), LocalDateTime.now().plusSeconds(100)),
                getPagamentosDTO( "64b7c3ecf2b3c82b8b4e91e8", new BigDecimal("3000"), LocalDateTime.now().plusSeconds(100)),
                getPagamentosDTO( "64b7c3ecf2b3c82b8b4e91e8", new BigDecimal("4000"), LocalDateTime.now().plusSeconds(100)),
                getPagamentosDTO( "64b7c3ecf2b3c82b8b4e91e8", new BigDecimal("5000"), LocalDateTime.now().plusSeconds(100)),
                getPagamentosDTO( "64b7c3ecf2b3c82b8b4e91e8", new BigDecimal("6000"), LocalDateTime.now().plusSeconds(100))
        );

        // Create a Page instance
        return new PagedModel<>(new PageImpl<>(content, PageRequest.of(0, 10), content.size()));
    }

    public static PagamentoDTO getPagamentosDTO(String id, BigDecimal value, LocalDateTime time) {
        return new PagamentoDTO( id, value, time, null, null);
    }

    public static PagamentoDTO getPagamentosDTO(String value) {
        return new PagamentoDTO( "64b7c3ecf2b3c82b8b4e91e8", new BigDecimal(value), LocalDateTime.now().plusSeconds(100), null, null);
    }

    public static MessageErrorEntity messageErrorEntity (
        String error,
        Integer status,
        String message,
        Instant date
    ){

        var messageError = new MessageErrorEntity();
        messageError.setError(error);
        messageError.setStatus(status);
        messageError.setMessage(message);
        messageError.setDate(date);

        return messageError;
    }
}
