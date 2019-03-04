package com.tikal.springcloud.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    CurrencyExchangeClientProxy currencyExchangeClientProxy;

    @GetMapping("currency-converter-feign/from/{from}/to/{to}/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        ExchangeValue exchangeValue = currencyExchangeClientProxy.retrieveExchangeValue(from,to);

        CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean();
        currencyConversionBean.setId(1L);
        currencyConversionBean.setFrom(from);
        currencyConversionBean.setTo(to);
        currencyConversionBean.setCurrencyMultiple(exchangeValue.getConversionMultiple());
        currencyConversionBean.setQuantity(quantity);
        currencyConversionBean.setPort(exchangeValue.getPort());
        BigDecimal totalAmount = quantity.multiply(exchangeValue.getConversionMultiple());
        currencyConversionBean.setTotalCalculatedAmount(totalAmount);
        return currencyConversionBean;
    }



    @GetMapping("currency-converter/from/{from}/to/{to}/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        RestTemplate restTemplate = new RestTemplate();
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        ResponseEntity<ExchangeValue> responseEntity =
                restTemplate.getForEntity("http://localhost:8000/currency-exchange/{from}/to/{to}"
                        , ExchangeValue.class, uriVariables);
        ExchangeValue exchangeValue = responseEntity.getBody();

        CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean();
        currencyConversionBean.setId(1L);
        currencyConversionBean.setFrom(from);
        currencyConversionBean.setTo(to);
        currencyConversionBean.setCurrencyMultiple(exchangeValue.getConversionMultiple());
        currencyConversionBean.setQuantity(quantity);
        currencyConversionBean.setPort(exchangeValue.getPort());
        BigDecimal totalAmount = quantity.multiply(exchangeValue.getConversionMultiple());
        currencyConversionBean.setTotalCalculatedAmount(totalAmount);
        return currencyConversionBean;
    }

}
