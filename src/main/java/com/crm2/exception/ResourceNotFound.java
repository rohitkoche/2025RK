package com.crm2.exception;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound (String msg){
        super(msg);
    }
}
