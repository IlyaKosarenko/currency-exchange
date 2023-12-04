package com.karazin.currencychange.endpoint;


import com.karazin.currencychange.response.CurrencyExchangeAverageResponse;
import com.karazin.currencychange.response.CurrencyExchangeMaxResponse;
import com.karazin.currencychange.response.CurrencyExchangeMinResponse;
import com.karazin.currencychange.response.CurrencyExchangeResponse;
import com.karazin.currencychange.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/currency/exchange")
public class CurrencyExchangeEndpoint {

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    private static final HttpStatusCode OK = HttpStatusCode.valueOf(200);

    @GetMapping("/rate")
    public ResponseEntity<CurrencyExchangeResponse> getRate(@RequestParam("code")
                                                            String currencyCode,
                                                            @RequestParam(value = "date", required = false)
                                                            @DateTimeFormat(pattern = "dd-MM-yyyy")
                                                            LocalDate date) {

        return new ResponseEntity<>(currencyExchangeService.getRate(currencyCode, date), OK);

    }

    @GetMapping("/average")
    public ResponseEntity<CurrencyExchangeAverageResponse> getAverage(@RequestParam("code")
                                                                      String currencyCode,
                                                                      @RequestParam(value = "from")
                                                                      @DateTimeFormat(pattern = "dd-MM-yyyy")
                                                                      LocalDate from,
                                                                      @RequestParam(value = "to")
                                                                      @DateTimeFormat(pattern = "dd-MM-yyyy")
                                                                      LocalDate to) {
        return new ResponseEntity<>(currencyExchangeService.getAverage(currencyCode, from, to), OK);
    }

    @GetMapping("/max")
    public ResponseEntity<CurrencyExchangeMaxResponse> getMax(@RequestParam("code")
                                                                      String currencyCode,
                                                              @RequestParam(value = "from")
                                                                      @DateTimeFormat(pattern = "dd-MM-yyyy")
                                                                      LocalDate from,
                                                              @RequestParam(value = "to")
                                                                      @DateTimeFormat(pattern = "dd-MM-yyyy")
                                                                      LocalDate to) {
        return new ResponseEntity<>(currencyExchangeService.getMax(currencyCode, from, to), OK);
    }

    @GetMapping("/min")
    public ResponseEntity<CurrencyExchangeMinResponse> getMin(@RequestParam("code")
                                                              String currencyCode,
                                                              @RequestParam(value = "from")
                                                              @DateTimeFormat(pattern = "dd-MM-yyyy")
                                                              LocalDate from,
                                                              @RequestParam(value = "to")
                                                              @DateTimeFormat(pattern = "dd-MM-yyyy")
                                                              LocalDate to) {
        return new ResponseEntity<>(currencyExchangeService.getMin(currencyCode, from, to), OK);
    }

}
