package com.example.xyz.plugin;

import org.jeasy.rules.api.Rules;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    Rules firstRuleSet() {
        System.out.println("First rule!");
        return new Rules(new FirstRule());
    }

    @Bean
    Rules secondRuleSet() {
        return new Rules(new SecondRule());
    }
}
