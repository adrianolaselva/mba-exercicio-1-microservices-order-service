package br.com.fiap.orderservice.exceptions;


public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(String s, String... searchParamsMap) {
        super(s);
    }
}
