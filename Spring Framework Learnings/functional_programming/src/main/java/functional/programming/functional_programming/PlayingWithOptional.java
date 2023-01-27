package functional.programming.functional_programming;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

// INSTEAD OF USING NULL, RECOMMENDED APPROACH IS TO USE: Optional's'

public class PlayingWithOptional {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "mango");
 
        Predicate<? super String> predicate = fruit -> fruit.startsWith("c");
        Optional<String> optional = fruits.stream().filter(predicate).findFirst();

        System.out.println(optional); // First item is banana
        System.out.println(optional.isEmpty()); // False, we found 1 item
        System.out.println(optional.isPresent()); // true, we found a value
        System.out.println(optional.get()); // get the value

        Optional<String> fruit = Optional.of("banana");
        Optional<String> empty = Optional.empty();
    }
}
