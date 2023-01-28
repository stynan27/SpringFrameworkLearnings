package com.in28minutes.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All dependencies ready!");
    }

    // As soon as dependencies are auto-wired (ready)
    // Use of PostConstruct to immediately invoke say some dependency methods
    // ... before we use them!!! (i.e. VueJS onCreate())
    @PostConstruct
    public void initialize() {
        someDependency.getReady();
    }

    // Called when a Bean is destroyed (app terminates)
    // Release resources as needed.
    @PreDestroy
    public void cleanup() {
        System.out.println("Cleanup");
    }
}

@Component
class SomeDependency {

  public void getReady() {
      System.out.println("Some logic using some dependency.");
  }

}

@Configuration
@ComponentScan // No need to specify package name if components are here
public class PrePostAnnotationsContextLauncherApplication {

    public static void main(String[] args) {
        try (var context = 
            new AnnotationConfigApplicationContext
                (PrePostAnnotationsContextLauncherApplication.class)) {
            // Use context here.
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
