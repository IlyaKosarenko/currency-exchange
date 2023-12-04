package com.karazin.currencychange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CurrencyExchangeExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    protected ResponseEntity<Object> handleCurrencyExchangeException(CurrencyExchangeException ex) {
        return new ResponseEntity<>(new Payload(ex.getMessage()), HttpStatusCode.valueOf(404));
    }

    private static class Payload {
        private String message;

        public Payload(String message) {
            this.message = message;
        }

        public Payload() {
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }



}
