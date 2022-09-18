package com.example.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(ResourceAlreadyExistsException .class)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(ResourceAlreadyExistsException ex, WebRequest request) {
        String details = ex.getLocalizedMessage();
        ErrorResponse error = new ErrorResponse("Not found", details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
        String details = ex.getLocalizedMessage();
        ErrorResponse error = new ErrorResponse("SERVER_ERROR", details);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(UniqueSlugException .class)
    public final ResponseEntity<ErrorResponse> uniqueSlugException(UniqueSlugException ex, WebRequest request) {
        String details = ex.getLocalizedMessage();
        ErrorResponse error = new ErrorResponse(ex.getMessage(), details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
