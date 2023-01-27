package functional.programming.functional_programming;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 14, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "Azure", "Docker", "Kubernetes");
        //printAllNumbersInListStructured(numbers);
        //printEvenNumbersInListStructured(numbers);
        //printOddNumbersInListStructured(numbers);
        //printAllStrings(courses);
        //printAllSpring(courses);
        //printFourOrMore(courses);
        //printSquaresOfEvenNumbersInListStructured(numbers);
        printCubesOfOddNumbersInListStructured(numbers);
        printNumChars(courses);
    }

    // private static void print(int number) {
    //     System.out.println(number);
    // }

    // private static Boolean isEven(int number) {
    //     return number%2 == 0;
    // }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        // TODO: Convert list to stream of elts
        // Stream is a sequence of data elements that can be processed in parallel or sequentially.
        // Provides a set of classes for functional-style operations on streams of elements.
        // i.e filter, map, and reduce.
        // numbers.stream()
        //     .forEach(FP01Functional::print); // Method reference example (Form: {class-name}::{method-name})

        numbers.stream()
            .forEach(System.out::println);
    }

    private static void printAllStrings(List<String> courses) {
        courses.stream()
          .forEach(System.out::println);
    }

    private static void printAllSpring(List<String> courses) {
      courses.stream()
        .filter(course -> course.contains("Spring"))
        .forEach(System.out::println);
    }

    private static void printFourOrMore(List<String> courses) {
      courses.stream()
        .filter(course -> course.length() >= 4)
        .forEach(System.out::println);
    }

    private static void printNumChars(List<String> courses) {
      courses.stream()
        .map(course -> course.length())
        .forEach(System.out::println);
    }

    private static void printEvenNumbersInListStructured(List<Integer> numbers) {
        // numbers.stream()
        //     .filter(FP01Functional::isEven) //Filter - Only allow even numbers.
        //     .forEach(System.out::println);

        numbers.stream()
            .filter(number -> number%2==0) // Lambda expression
            .forEach(System.out::println);
    }

    private static void printOddNumbersInListStructured(List<Integer> numbers) {
        numbers.stream()
            .filter(number -> number%2!=0)
            .forEach(System.out::println);
    }

    private static void printSquaresOfEvenNumbersInListStructured(List<Integer> numbers) {
        numbers.stream()
            .filter(number -> number % 2 == 0) // Lambda expression
            .map(number -> number * number)
            .forEach(System.out::println);
    }

    private static void printCubesOfOddNumbersInListStructured(List<Integer> numbers) {
      numbers.stream()
          .filter(number -> number % 2 != 0) // Lambda expression
          .map(number -> number * number * number)
          .forEach(System.out::println);
  }
}
