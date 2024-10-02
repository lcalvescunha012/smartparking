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
                getPagamentosDTO( new ObjectId(), new BigDecimal("1000"), LocalDateTime.now().plusSeconds(100)),
                getPagamentosDTO( new ObjectId(), new BigDecimal("2000"), LocalDateTime.now().plusSeconds(100)),
                getPagamentosDTO( new ObjectId(), new BigDecimal("3000"), LocalDateTime.now().plusSeconds(100)),
                getPagamentosDTO( new ObjectId(), new BigDecimal("4000"), LocalDateTime.now().plusSeconds(100)),
                getPagamentosDTO( new ObjectId(), new BigDecimal("5000"), LocalDateTime.now().plusSeconds(100)),
                getPagamentosDTO( new ObjectId(), new BigDecimal("6000"), LocalDateTime.now().plusSeconds(100))
        );

        // Create a Page instance
        return new PagedModel<>(new PageImpl<>(content, PageRequest.of(0, 10), content.size()));
    }

    public static PagamentoDTO getPagamentosDTO(ObjectId id, BigDecimal value, LocalDateTime time) {
        return new PagamentoDTO( id, value, time, null, null, 0L);
    }

    public static PagamentoDTO getPagamentosDTO(String value) {
        return new PagamentoDTO( new ObjectId(), new BigDecimal(value), LocalDateTime.now().plusSeconds(100), null, null, 0L);
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
