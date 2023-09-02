package com.bootcamp.project.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class ProjectException extends RuntimeException{
    public ProjectException(String message) {
        super(message);
    }
}
