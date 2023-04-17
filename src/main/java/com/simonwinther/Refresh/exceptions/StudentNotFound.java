package com.simonwinther.Refresh.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class StudentNotFound extends RuntimeException {
    public StudentNotFound(){
        super("Den studerende kunne ikke findes!");
    }
}
