package com.wangsb.exception;

import org.springframework.util.CollectionUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

@RestControllerAdvice
public class CommonExceptionHandler {

    /**
     * 用于捕获@RequestBody类型参数触发校验规则抛出的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public String handleValidException(MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder();
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        if (!CollectionUtils.isEmpty(allErrors)) {
            for (ObjectError error : allErrors) {
                sb.append(error.getDefaultMessage()).append(";");
            }
        }
        return sb.toString();
    }

    /**
     * 用于捕获@RequestParam/@PathVariable参数触发校验规则抛出的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public String handleConstraintViolationException(ConstraintViolationException e) {
        StringBuilder sb = new StringBuilder();
        Set<ConstraintViolation<?>> conSet = e.getConstraintViolations();
        for (ConstraintViolation<?> con : conSet) {
            String message = con.getMessage();
            sb.append(message).append(";");
        }
        return sb.toString();
    }
}