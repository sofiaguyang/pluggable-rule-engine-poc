package com.example.xyz.service;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    @Qualifier("firstRuleSet")
    Rules firstRules;

    @Autowired
    @Qualifier("secondRuleSet")
    Rules secondRules;

    @GetMapping("first")
    String firstRulesEngineEndpoint() {
        RulesEngine rulesEngine = new DefaultRulesEngine();
        Facts facts = new Facts();
        facts.put("hello", "world");
        rulesEngine.fire(firstRules, facts);
        return facts.get("hello");
    }

    @GetMapping("second")
    String secondRulesEngineEndpoint() {
        RulesEngine rulesEngine = new DefaultRulesEngine();
        Facts facts = new Facts();
        facts.put("hello", "world");
        rulesEngine.fire(secondRules, facts);
        return facts.get("hello");
    }
}
