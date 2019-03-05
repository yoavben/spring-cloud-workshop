package com.tikal.springcloud.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeClientProxy {
    @GetMapping("/currency-exchange/{from}/to/{to}")
    ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
