package com.lukushin.socks.exception_handling;

public class NotEnoughSocksForDeleteException extends RuntimeException{
    public NotEnoughSocksForDeleteException(String message) {
        super(message);
    }
}
