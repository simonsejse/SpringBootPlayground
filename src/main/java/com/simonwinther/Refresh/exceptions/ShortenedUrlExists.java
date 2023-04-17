package com.simonwinther.Refresh.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class ShortenedUrlExists extends RuntimeException {
    public ShortenedUrlExists(){
        super("Cannot create a shortened URL with these settings!");
    }
}
