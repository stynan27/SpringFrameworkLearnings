package com.in28minutes.learnspringframework.examples.g1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named // Same as @Component implementation (but jakarta package)
class BusinessService {
    private DataService dataService;

    public DataService getDataService() {
      System.out.println("Setter Injection");
      return dataService;
    }

    //@Autowired // Dependency injection via setter method. (Usually unspecified if constructor)
    @Inject // Same as @Autowired implementation (but jakarta package)
    public void setDataService(DataService dataService) {
      this.dataService = dataService;
    }
}

//@Component
@Named
class DataService {

}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {

    public static void main(String[] args) {
        try (var context = 
            new AnnotationConfigApplicationContext
                (CdiContextLauncherApplication.class)) {
            // Use context here.
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BusinessService.class).getDataService());
        }
    }
}
