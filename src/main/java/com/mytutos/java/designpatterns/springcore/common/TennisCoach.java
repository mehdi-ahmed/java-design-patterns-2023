package com.mytutos.java.designpatterns.springcore.common;

import org.springframework.stereotype.Component;

@Component
//@Lazy
public class TennisCoach implements Coach {

    public TennisCoach() {
        System.out.println("In constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Work that swing baby";
    }
}
