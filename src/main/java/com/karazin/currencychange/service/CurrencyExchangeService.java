package com.karazin.currencychange.service;

import com.karazin.currencychange.dto.CurrencyExchangeDto;
import com.karazin.currencychange.dto.CurrencyExchangeRangeDto;
import com.karazin.currencychange.exception.CurrencyExchangeException;
import com.karazin.currencychange.provider.CurrencyExchangeProvider;
import com.karazin.currencychange.response.CurrencyExchangeAverageResponse;
import com.karazin.currencychange.response.CurrencyExchangeMaxResponse;
import com.karazin.currencychange.response.CurrencyExchangeMinResponse;
import com.karazin.currencychange.response.CurrencyExchangeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;

@Service
public class CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeProvider currencyExchangeProvider;

    public CurrencyExchangeResponse getRate(String currencyCode, LocalDate date) {

        if (!StringUtils.hasText(currencyCode)) {
            throw new CurrencyExchangeException("Currency rate is blank");
        }

        if (date == null) {
            date = LocalDate.now();
        }

        var dto = currencyExchangeProvider.getRates(currencyCode, date, true);

        if (dto == null || dto.isEmpty()) {
            throw new CurrencyExchangeException(String.format("Couldn't fetch currency rate %s for date %s", currencyCode, date));
        }

        return mapRateResponse(dto);
    }

    public CurrencyExchangeAverageResponse getAverage(String currencyCode, LocalDate from, LocalDate to) {

        if (!StringUtils.hasText(currencyCode)) {
            throw new CurrencyExchangeException("Currency rate is blank");
        }

        var rangeOfCurrencies = currencyExchangeProvider.getRange(currencyCode, from, to, true);

        Double average = rangeOfCurrencies.stream()
                .mapToDouble(CurrencyExchangeRangeDto::getRate)
                .average()
                .orElseThrow(() -> new CurrencyExchangeException(String.format("Couldn't calculate average of currency: %s from: %s to %s", currencyCode, from, to)));

        return new CurrencyExchangeAverageResponse(from, to, average, currencyCode);
    }

    public CurrencyExchangeMaxResponse getMax(String currencyCode, LocalDate from, LocalDate to) {
        if (!StringUtils.hasText(currencyCode)) {
            throw new CurrencyExchangeException("Currency rate is blank");
        }

        var rangeOfCurrencies = currencyExchangeProvider.getRange(currencyCode, from, to, true);

        Double max = rangeOfCurrencies.stream()
                .mapToDouble(CurrencyExchangeRangeDto::getRate)
                .max()
                .orElseThrow(() -> new CurrencyExchangeException(String.format("Couldn't calculate max of currency: %s from: %s to %s", currencyCode, from, to)));

        return new CurrencyExchangeMaxResponse(from, to, max, currencyCode);
    }

    public CurrencyExchangeMinResponse getMin(String currencyCode, LocalDate from, LocalDate to) {
        if (!StringUtils.hasText(currencyCode)) {
            throw new CurrencyExchangeException("Currency rate is blank");
        }

        var rangeOfCurrencies = currencyExchangeProvider.getRange(currencyCode, from, to, true);

        Double min = rangeOfCurrencies.stream()
                .mapToDouble(CurrencyExchangeRangeDto::getRate)
                .min()
                .orElseThrow(() -> new CurrencyExchangeException(String.format("Couldn't calculate min of currency: %s from: %s to %s", currencyCode, from, to)));

        return new CurrencyExchangeMinResponse(from, to, min, currencyCode);
    }

    private CurrencyExchangeResponse mapRateResponse(List<CurrencyExchangeDto> dto) {

        var currency = dto.get(0);

        return new CurrencyExchangeResponse(currency.getCc(), currency.getRate(), currency.getExchangedate());
    }

}
