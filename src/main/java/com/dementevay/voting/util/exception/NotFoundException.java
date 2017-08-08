package com.dementevay.voting.util.exception;

/**
 * Created by Andrey Dementev on 07.08.17.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}