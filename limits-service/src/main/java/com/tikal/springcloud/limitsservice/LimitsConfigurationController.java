package com.tikal.springcloud.limitsservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {


    @GetMapping("/limits")
    public LimitsConfiguration getLimitsConfiguration() {

        LimitsConfiguration limitsConfiguration = new LimitsConfiguration();
        limitsConfiguration.setMinimum(10);
        limitsConfiguration.setMaximum(20);
        return limitsConfiguration;

    }
}
