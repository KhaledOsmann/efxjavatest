package com.gft.exfjavatest.Config;

import com.gft.exfjavatest.Service.PriceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PriceConfig {

    @Bean
    PriceService priceService() {
        return new PriceService();
    }
}
