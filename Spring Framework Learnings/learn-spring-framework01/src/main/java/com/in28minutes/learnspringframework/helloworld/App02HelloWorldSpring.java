package com.in28minutes.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    // Type "main" + [TAB] to create main()
    public static void main(String[] args) {
        // 1: Launch Spring Context
        // try/with resources example
        try (var context = 
                new AnnotationConfigApplicationContext
                      (HelloWorldConfiguration.class)) {
            // 3: Retrieving Beans managed by Spring
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));
            System.out.println(context.getBean("address2"));
            System.out.println(context.getBean("address3"));
            System.out.println(context.getBean(Person.class)); // could also use object type

            // Returns a list of all Spring Bean names
            System.out.println("TESTING");
            Arrays.stream(context.getBeanDefinitionNames())
              .forEach(System.out::println); // ::println -> method reference
            context.getBeanDefinitionNames();
            // Returns the count of all Spring Beans 
            //context.getBeanDefinitionCount();
        } catch (BeansException e) {
          e.printStackTrace();
        }
    }
}
