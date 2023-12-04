package com.karazin.currencychange.response;

import java.time.LocalDate;

public class CurrencyExchangeMinResponse {
    private LocalDate from;
    private LocalDate to;
    private Double max;
    private String currencyCode;

    public CurrencyExchangeMinResponse(LocalDate from, LocalDate to, Double max, String currencyCode) {
        this.from = from;
        this.to = to;
        this.max = max;
        this.currencyCode = currencyCode;
    }

    public CurrencyExchangeMinResponse() {
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

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return "CurrencyExchangeMinResponse{" +
                "from=" + from +
                ", to=" + to +
                ", max=" + max +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}
