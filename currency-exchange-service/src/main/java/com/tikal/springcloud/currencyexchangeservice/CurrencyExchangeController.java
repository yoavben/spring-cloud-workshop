package com.tikal.springcloud.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Value("${server.port:8000}")
    int port;

    @GetMapping("/currency-exchange/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue = new ExchangeValue();
        exchangeValue.setId(1000L);
        exchangeValue.setFrom(from);
        exchangeValue.setTo(to);
        exchangeValue.setConversionMultiple(BigDecimal.valueOf(3.6));
        exchangeValue.setPort(port);
        return exchangeValue;
    }
}
