package com.smartparking.controller.utils;

import com.smartparking.dto.PagamentosDTO;
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

    public static PagedModel<PagamentosDTO> getPageModelPagamentosDTO() {

        // Sample content
        List<PagamentosDTO> content = Arrays.asList (
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

    public static PagamentosDTO getPagamentosDTO(ObjectId id, BigDecimal value, LocalDateTime time) {
        return new PagamentosDTO( id, value, time);
    }

    public static PagamentosDTO getPagamentosDTO(String value) {
        return new PagamentosDTO( new ObjectId(), new BigDecimal(value), LocalDateTime.now().plusSeconds(100));
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
