package br.com.fiap.orderservice.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static br.com.fiap.orderservice.exceptions.Exceptions.toMap;

public class ServerException extends Exception {

    public ServerException(String... searchParamsMap) {
        super("Internal server error " + toMap(String.class, String.class, searchParamsMap));
    }
}
