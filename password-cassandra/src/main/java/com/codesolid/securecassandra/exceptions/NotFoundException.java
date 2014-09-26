package com.codesolid.securecassandra.exceptions;

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
