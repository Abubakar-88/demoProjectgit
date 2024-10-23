package com.demol.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidation(MethodArgumentNotValidException e){
        return   ResponseEntity.badRequest().body(e.getFieldErrors().stream().map(error->
                error.getField()+":"+ error.getDefaultMessage()).toList());

    }
//    @ExceptionHandler(ResourceAlreadyExistsException.class)
//    public ResponseEntity<String> handleResourceAlreadyExistException(ResourceAlreadyExistsException ex){
//        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
//    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleSQLIntegrityConstraintViolationException(DataIntegrityViolationException ex){
        Map<String,String> error = new HashMap<>();
        String message = ex.getMessage();
        error.put("name",message);
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

}
