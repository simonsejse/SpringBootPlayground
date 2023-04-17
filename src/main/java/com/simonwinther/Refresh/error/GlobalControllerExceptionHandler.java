package com.simonwinther.Refresh.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Optional;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {
    private static final HttpStatus DEFAULT_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ApiErrorResponse> defaultExceptionHandler(RuntimeException ex){
        var httpStatus = Optional.ofNullable(ex.getClass().getAnnotation(ResponseStatus.class))
                .map(ResponseStatus::code)
                .orElse(DEFAULT_STATUS);

        return ResponseEntity
                .status(httpStatus)
                .body(ApiErrorResponse.builder()
                        .status(httpStatus)
                        .code(httpStatus.value())
                        .timestamp(LocalDateTime.now())
                        .message(ex.getMessage())
                        .build()
                );
    }
}
