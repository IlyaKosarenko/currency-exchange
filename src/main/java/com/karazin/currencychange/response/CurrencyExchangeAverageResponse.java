package com.karazin.currencychange.response;

import java.time.LocalDate;

public class CurrencyExchangeAverageResponse {
    private LocalDate from;
    private LocalDate to;
    private Double average;
    private String currencyCode;

    public CurrencyExchangeAverageResponse(LocalDate from, LocalDate to, Double average, String currencyCode) {
        this.from = from;
        this.to = to;
        this.average = average;
        this.currencyCode = currencyCode;
    }

    public CurrencyExchangeAverageResponse() {
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return "CurrencyExchangeAverageResponse{" +
                "from=" + from +
                ", to=" + to +
                ", average=" + average +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}
