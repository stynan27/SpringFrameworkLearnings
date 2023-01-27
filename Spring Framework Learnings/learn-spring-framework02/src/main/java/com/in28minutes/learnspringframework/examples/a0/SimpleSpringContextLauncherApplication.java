package com.in28minutes.learnspringframework.examples.a0;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan // No need to specify package name if components are here
public class SimpleSpringContextLauncherApplication {

    public static void main(String[] args) {
        try (var context = 
            new AnnotationConfigApplicationContext
                (SimpleSpringContextLauncherApplication.class)) {
            // Use context here.
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
