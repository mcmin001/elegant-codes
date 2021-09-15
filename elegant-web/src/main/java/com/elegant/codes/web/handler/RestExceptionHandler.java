package com.elegant.codes.web.handler;

import com.elegant.codes.common.exception.ClientException;
import com.elegant.codes.common.exception.SystemException;
import com.elegant.codes.web.common.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public JsonResult Execption(Exception e) {
        return JsonResult.error(e.getMessage());
    }

    @ExceptionHandler(ClientException.class)
    public JsonResult ClientException(ClientException e) {
        return JsonResult.error(e.getMessage());
    }

    @ExceptionHandler(SystemException.class)
    public JsonResult SystemException(SystemException e) {
        return JsonResult.error(e.getMessage());
    }
}
