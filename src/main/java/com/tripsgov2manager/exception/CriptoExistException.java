package com.tripsgov2manager.exception;

public class CriptoExistException extends  Exception{
    private static final long serialVersionUID = 1L;

    public CriptoExistException(String message) {
        super(message);
    }
}
