package com.karazin.currencychange.response;

import java.time.LocalDate;

public class CurrencyExchangeResponse {
    private String code;
    private double rate;
    private LocalDate date;

    public CurrencyExchangeResponse(String code, double rate, LocalDate date) {
        this.code = code;
        this.rate = rate;
        this.date = date;
    }

    public CurrencyExchangeResponse() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CurrencyExchangeResponse{" +
                "code='" + code + '\'' +
                ", rate=" + rate +
                ", date=" + date +
                '}';
    }
}
