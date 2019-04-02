package br.com.fiap.orderservice.exceptions;

import static br.com.fiap.orderservice.exceptions.Exceptions.generateMessage;
import static br.com.fiap.orderservice.exceptions.Exceptions.toMap;

public class OrderNotFoundException extends Exception {
    public OrderNotFoundException(Class clazz, String... searchParamsMap) {
        super(generateMessage(clazz.getSimpleName(), toMap(String.class, String.class, searchParamsMap)));
    }
}
