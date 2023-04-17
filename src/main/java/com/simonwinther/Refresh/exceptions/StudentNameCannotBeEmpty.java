package com.simonwinther.Refresh.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class StudentNameCannotBeEmpty extends RuntimeException {
    public StudentNameCannotBeEmpty(){
        super("Navnet kan ikke være tomt!");
    }
}
