package com.lukushin.socks.exception_handling;

public class NoSuchSocksException extends RuntimeException{
    public NoSuchSocksException(String message) {
        super(message);
    }
}
