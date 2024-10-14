package com.smartparking.controller;

import com.smartparking.entities.MessageErrorEntity;
import com.smartparking.exceptions.ExpectationFailedException;
import com.smartparking.exceptions.InternalServerErrorException;
import com.smartparking.exceptions.NotFoundException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import java.util.Objects;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    private final MessageErrorEntity err = new MessageErrorEntity();

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<MessageErrorEntity> handleInvalidObjectId(MethodArgumentTypeMismatchException e) {

        HttpStatus status = HttpStatus.BAD_REQUEST;
        String error = "Invalid ObjectId format";

        err.setStatus(status.value());
        err.setError(error);
        err.setMessage(Objects.requireNonNull(e.getValue()).toString());
        err.setDate(Instant.now());

        return ResponseEntity.status(status).body(this.err);
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageErrorEntity> handleHttpNotFoundException(NotFoundException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "Registro não encontrado";

        err.setStatus(status.value());
        err.setError(error);
        err.setMessage(e.getReason());
        err.setDate(Instant.now());

        return ResponseEntity.status(status).body(this.err);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<MessageErrorEntity> handleInternalServerErrorException(InternalServerErrorException e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String error = "Erro Interno.";

        err.setStatus(status.value());
        err.setError(error);
        err.setMessage(e.getReason());
        err.setDate(Instant.now());

        return ResponseEntity.status(status).body(this.err);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(OptimisticLockingFailureException.class)
    public ResponseEntity<MessageErrorEntity> handleOptimisticLockingFailureException(OptimisticLockingFailureException e) {
        HttpStatus status = HttpStatus.CONFLICT;
        String error = "Erro de concorrencia. Outro usuário realizando operações nesse documento.";

        err.setStatus(status.value());
        err.setError(error);
        err.setMessage(e.getMessage());
        err.setDate(Instant.now());

        return ResponseEntity.status(status).body(this.err);
    }

    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    @ExceptionHandler(ExpectationFailedException.class)
    public ResponseEntity<MessageErrorEntity> handleExceptionFailedException(ExpectationFailedException e) {
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        String error = "Erro na solicitação.";

        err.setStatus(status.value());
        err.setError(error);
        err.setMessage(e.getReason());
        err.setDate(Instant.now());

        return ResponseEntity.status(status).body(this.err);
    }
}
