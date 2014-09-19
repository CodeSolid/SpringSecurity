package com.codesolid.goalboost.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class NotFoundException
 * Description:
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) {
        super(msg);
    }
    public NotFoundException() {
        super();
    }
}
