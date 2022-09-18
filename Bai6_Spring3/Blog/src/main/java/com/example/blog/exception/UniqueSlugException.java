package com.example.blog.exception;

public class UniqueSlugException extends RuntimeException{
    public UniqueSlugException(String message) {
        super(message);
    }
}
