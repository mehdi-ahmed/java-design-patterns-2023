package com.mytutos.java.designpatterns.springcore.common;

// No @Component annotation
public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("In constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim like Phelbs Bruh !!!";
    }
}
