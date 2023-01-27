package com.in28minutes.learnspringframework.businsesscalculation;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringContextLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(SpringContextLauncher.class)) {
            // Use Context here
            Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

            // Get Business Calculation service and run findMax()
            var max = context.getBean(BusinessCalculationService.class).findMax();
            System.out.println(max);
        }
    }
}
