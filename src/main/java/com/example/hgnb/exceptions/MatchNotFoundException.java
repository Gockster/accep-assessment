package com.example.hgnb.exceptions;

public class MatchNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1;

    public MatchNotFoundException(String message) {
        super(message);
    }
}
