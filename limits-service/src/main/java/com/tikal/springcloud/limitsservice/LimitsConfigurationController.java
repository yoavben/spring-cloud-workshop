package com.tikal.springcloud.limitsservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    private Configuration configuration;

    public LimitsConfigurationController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/limits")
    public LimitsConfiguration getLimitsConfiguration() {

        LimitsConfiguration limitsConfiguration = new LimitsConfiguration();
        limitsConfiguration.setMinimum(configuration.getMinimum());
        limitsConfiguration.setMaximum(configuration.getMaximum());
        return limitsConfiguration;

    }
}
