package com.in28minutes.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//YourBusinessClass
//Dependency1
//Dependency2

// Create a Bean per Component
@Component
class YourBusinessClassFieldInjection {
    // Field injection using reflection (@Autowired). 
    // Reflecting back on other component implementations to define.
    @Autowired
    Dependency1 dependency1;
    @Autowired
    Dependency2 dependency2;

    public String toString() {
        System.out.println("Field injection");
        return "Using " + dependency1 + " and " + dependency2;
    }
}

@Component
class YourBusinessClassSetterInjection {
    Dependency1 dependency1;
    Dependency2 dependency2;

    // Setter injection using reflection (@Autowired). 
    @Autowired
    public void setDependency1(Dependency1 dependency1) {
        this.dependency1 = dependency1;
    }

    @Autowired
    public void setDependency2(Dependency2 dependency2) {
        this.dependency2 = dependency2;
    }

    public String toString() {
        System.out.println("Setter injection");
        return "Using " + dependency1 + " and " + dependency2;
    }
}

@Component
class YourBusinessClassConstructorInjection {
    Dependency1 dependency1;
    Dependency2 dependency2;

    // Constructor injection - @Autowired NOT mandatory!
    public YourBusinessClassConstructorInjection(Dependency1 dependency1, Dependency2 dependency2) {
      System.out.println("CONSTRUCTOR");
      this.dependency1 = dependency1;
      this.dependency2 = dependency2;
    }

    public void setDependency1(Dependency1 dependency1) {
        this.dependency1 = dependency1;
    }

    public void setDependency2(Dependency2 dependency2) {
        this.dependency2 = dependency2;
    }

    public String toString() {
        System.out.println("Constructor injection");
        return "Using " + dependency1 + " and " + dependency2;
    }
}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}

@Configuration
@ComponentScan // No need to specify package name if components are here (defined above)
public class DepInjectionLauncherApplication {

    public static void main(String[] args) {
        try (var context = 
            new AnnotationConfigApplicationContext
                (DepInjectionLauncherApplication.class)) {
            // Use context here.
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(YourBusinessClassFieldInjection.class));
            System.out.println(context.getBean(YourBusinessClassSetterInjection.class));
            System.out.println(context.getBean(YourBusinessClassConstructorInjection.class));
        }
    }
}
