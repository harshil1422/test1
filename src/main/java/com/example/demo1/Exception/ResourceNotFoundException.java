package com.example.demo1.Exception;

public class ResourceNotFoundException extends RuntimeException {



    public ResourceNotFoundException() {
        super(
                String.format("resource not found Exception ")
        );
    }
}
