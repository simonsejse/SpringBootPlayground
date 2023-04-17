package com.simonwinther.Refresh.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ShortenedUrlDoesNotExist extends RuntimeException {
    public ShortenedUrlDoesNotExist(){
        super("This slug is not associated with a url!");
    }
}
