package com.simonwinther.Refresh.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
public record ApiErrorResponse (
        HttpStatus status,
        int code,
        @JsonFormat(pattern="HH:mm:ss dd-MM-yyyy") LocalDateTime timestamp,
        String message
){ }
