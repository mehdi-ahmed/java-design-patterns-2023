package com.mytutos.java.designpatterns.springcore.config;

import com.mytutos.java.designpatterns.springcore.common.Coach;
import com.mytutos.java.designpatterns.springcore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwimConfig {

    @Bean("aqua")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
