package com.bruno.hexagonal.domain.exceptions;

public class ProdutoNotFoundException extends RuntimeException{

    public ProdutoNotFoundException(String message){
        super(message);
    }

}
