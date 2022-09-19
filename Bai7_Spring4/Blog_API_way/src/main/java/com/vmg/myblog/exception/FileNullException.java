package com.vmg.myblog.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FileNullException extends RuntimeException{
    private int code;
    private String message;
}
