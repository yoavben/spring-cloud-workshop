package com.tikal.springcloud.currencyconversionservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @GetMapping("currency-converter/from/{from}/to/{to}/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean();
        currencyConversionBean.setId(1L);
        currencyConversionBean.setFrom("USD");
        currencyConversionBean.setTo("NIS");
        currencyConversionBean.setCurrencyMultiple(BigDecimal.TEN);
        currencyConversionBean.setQuantity(BigDecimal.TEN);
        currencyConversionBean.setPort(0);
        currencyConversionBean.setTotalCalculatedAmount(BigDecimal.TEN);
        return currencyConversionBean;
    }

}
