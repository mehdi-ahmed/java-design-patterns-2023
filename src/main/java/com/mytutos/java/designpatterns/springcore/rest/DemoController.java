package com.mytutos.java.designpatterns.springcore.rest;

import com.mytutos.java.designpatterns.springcore.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final Coach myCoach;
    private final Coach anotherCoach;


    // Define a constructor for Dependency Injection
    // @Autowired in constructor is optional if only have 1 constructor
    @Autowired
    public DemoController(@Qualifier("aqua") Coach myCoach,
                          @Qualifier("aqua") Coach anotherCoach) {
        System.out.println("In constructor " + getClass().getSimpleName());
        this.anotherCoach = anotherCoach;
        this.myCoach = myCoach;
    }

    // init method
    @PostConstruct
    public void checkLifecyclePost() {
        System.out.println("Inside Init");
    }

    // destroy method
    @PreDestroy
    public void checkLifecyclePre() {
        System.out.println("Inside Destroy");
    }

    @GetMapping("/workout")
    public String getWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        // returns true when Bean scope = Singleton
        // Returns false when bean scope = Prototype(Creates a new Bean Instance per new injection)
        return "Comparing beans: myCoach == anotherCoach = " + (myCoach == anotherCoach);

    }
}
