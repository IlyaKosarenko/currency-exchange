package com.karazin.currencychange.provider;

import com.karazin.currencychange.config.FeignConfig;
import com.karazin.currencychange.dto.CurrencyExchangeDto;
import com.karazin.currencychange.dto.CurrencyExchangeRangeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient(url = "${currency.exchange.url}", configuration = FeignConfig.class, name = "currencyExchangeProvider")
public interface CurrencyExchangeProvider {

    @GetMapping("/NBUStatService/v1/statdirectory/exchangenew")
    List<CurrencyExchangeDto> getRates(@RequestParam("valcode") String valCode,
                                       @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") LocalDate date,
                                       @RequestParam("json") boolean json);

    @GetMapping("/NBU_Exchange/exchange_site")
    List<CurrencyExchangeRangeDto> getRange(@RequestParam("valcode") String valCode,
                                            @RequestParam("start") @DateTimeFormat(pattern = "yyyyMMdd") LocalDate start,
                                            @RequestParam("end") @DateTimeFormat(pattern = "yyyyMMdd") LocalDate end,
                                            @RequestParam("json") boolean json);

}
