package com.in28minutes.learnspringframework.examples.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {

}

// NOTE: Lazy initialization is typically not recommended (otherwise called Eager initialization).
@Component
@Lazy // Prevent initialization (constructor call) at startup. Instead performed when first used by context.
class ClassB {

  private ClassA classA;

  // Example of dependency injection from constructor
  public ClassB(ClassA classA) {
      System.out.println("Some Initialization logic");
      this.classA = classA;
  }

  public void doSomething() {
      System.out.println("DO SOMETHING!!!");
  }
}

@Configuration
@ComponentScan 
public class LazyInitializationLauncherApplication {

    public static void main(String[] args) {
        try (var context = 
            new AnnotationConfigApplicationContext
                (LazyInitializationLauncherApplication.class)) {
            // Use context here.
            //Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println("Init of context is completed.");
            // Notice here is when constructor (initialization) for ClassB gets called!
            context.getBean(ClassB.class).doSomething();
        }
    }
}