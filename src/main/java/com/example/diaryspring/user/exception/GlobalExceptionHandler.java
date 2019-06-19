package com.example.diaryspring.user.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UnauthorizedException.class)
    protected ModelAndView handleUnauthorizedException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        response.setHeader("WWW-Authenticate", "Basic realm=\"Access to user information\"");

        return new ResponseStatusExceptionResolver()
                .resolveException(request, response, handler, ex);
    }
}