package com.in28minutes.learnspringframework.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// record is a new feature of jdk 16.
// Eliminates verbosity so you don't need to create biolerplate setter/getter methods.

record Person (String name, int age, Address address) { };
record Address (String firstLine, String city) { };

// Data annotation for a configuration class
@Configuration
public class HelloWorldConfiguration {
    // An object managed by Spring FW container
    @Bean
    public String name() {
        return "Shamoose";
    }

    @Bean
    public int age() {
        return 26;
    }

    // Person obj defined by record above.
    @Bean
    public Person person() {
        var person = new Person("Seamus", 25, new Address("Main St.", "Rochester"));
        return person;
    }

    // custom bean name example
    @Bean(name = "address2")
    @Primary
    public Address address() {
        var address = new Address("2106 Oak Lane", "Buffalo, New York");
        return address;
    }

    @Bean(name = "address3")
    public Address address3() {
        var address = new Address("2107", "Death, Star");
        return address;
    }

    // Create a new Spring Bean with a relationship to an existing Bean
    // Inheritence!
    @Bean
    public Person person2MethodCall() {
        // Use existing method calls to define!
        return new Person(name(), age(), address()); // name, age
    }

    // Or pass by parameter, with names of previously created beans.
    @Bean
    public Person person3Parameters(String name, int age, Address address2) {// name,age,address2
        // Use existing method calls to define!
        return new Person(name, age, address2); // name, age, address2
    }

    @Bean
    @Primary
    public Person person4Parameters(String name, int age, Address address) {// name,age,address2
        // Use existing method calls to define!
        return new Person(name, age, address); 
    }
}
