package practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapfunctionalEx {
    public static void main(String[] args) {
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");

        // Convert String to uppercase and Join them with coma
        String commaSeperated = G7.stream().map((str) -> str.toUpperCase())
                .collect(Collectors.joining(","));
        System.out.println(commaSeperated);

        // Create a List of the square of all distinct numbers
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);

        List<Integer> squares = numbers.stream()
                .distinct()
                .map((num) -> num * num)
                .collect(Collectors.toList());
        System.out.println("squares = " + squares);

        List<String> colors = Arrays.asList("RED", "grEEn", "white", "Orange", "pink");
        // Convert strings to uppercase using streams
        List<String> upper = colors.stream()
                .map(x -> x.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(upper);

        // Convert strings to lower using streams with Method reference
        List<Object> lower = colors.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        System.out.println(lower);
    }
}
