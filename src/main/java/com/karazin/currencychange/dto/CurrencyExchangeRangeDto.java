package com.karazin.currencychange.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CurrencyExchangeRangeDto extends CurrencyExchangeDto {
    @JsonFormat(pattern = "dd.MM.yyyy")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate exchangedate;
    private String enname;
    private Integer units;
    private Double rate_per_unit;
    private String group;
    @JsonFormat(pattern = "dd.MM.yyyy")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate calcdate;

    @Override
    public LocalDate getExchangedate() {
        return exchangedate;
    }

    @Override
    public void setExchangedate(LocalDate exchangedate) {
        this.exchangedate = exchangedate;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public Double getRate_per_unit() {
        return rate_per_unit;
    }

    public void setRate_per_unit(Double rate_per_unit) {
        this.rate_per_unit = rate_per_unit;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public LocalDate getCalcdate() {
        return calcdate;
    }

    public void setCalcdate(LocalDate calcdate) {
        this.calcdate = calcdate;
    }

    @Override
    public String toString() {
        return "CurrencyExchangeRangeDto{" +
                "r030='" + super.getR030() +
                ", txt=" + super.getTxt() +
                ", rate=" + super.getRate() +
                ", cc=" + super.getCc() +
                ", exchangedate=" + exchangedate +
                ", enname='" + enname + '\'' +
                ", units=" + units +
                ", rate_per_unit=" + rate_per_unit +
                ", group='" + group + '\'' +
                ", calcdate=" + calcdate +
                '}';
    }



}
