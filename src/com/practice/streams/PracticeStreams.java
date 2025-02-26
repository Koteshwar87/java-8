package com.practice.streams;

import java.util.*;
import java.util.stream.Collectors;

public class PracticeStreams {
    public static void main(String[] args) {

//        1. Write a Java program to calculate the average of a list of integers using streams.
        List<Integer> nums = Arrays.asList(1, 3, 6, 8, 10, 18, 36);
        System.out.println("List of numbers: " + nums);
        double v = nums.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
        System.out.println(v);

//        2. Write a Java program to convert a list of strings to uppercase or lowercase using streams.
        List < String > colors = Arrays.asList("RED", "grEEn", "white", "Orange", "pink");
        System.out.println("List of strings: " + colors);
        // Convert strings to uppercase using streams
        colors.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

//        3. Write a Java program to calculate the sum of all even, odd numbers in a list using streams.
        List < Integer > numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Sum of even numbers
        int evenSum = numbers.stream()
                .filter(number -> (number % 2) == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(evenSum);

//        4. Write a Java program to remove all duplicate elements from a list using streams
        nums = Arrays.asList(10, 23, 22, 23, 24, 24, 33, 15, 26, 15);
        System.out.println("Original List of numbers: " + nums);
        // Remove duplicates
        List<Integer> collect = nums.stream()
                .distinct()
                .collect(Collectors.toList());

//        5. Write a Java program to count the number of strings in a list that start with a specific letter using streams.
        colors = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");
        System.out.println("Original list of strings (colors): " + colors);
        char startingLetter = 'B';
        // Count strings starting with a specific letter
        long count = colors.stream()
                .filter(color -> color.startsWith(Character.toString(startingLetter)))
                .count();
        System.out.println(count);

//        6. Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.
        colors = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");
        System.out.println("Original List of strings(colors): " + colors);
        // Sort strings in ascending order
        List<String> ascending = colors.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(ascending);
        // Sort strings in descending order
        List<String> descending = colors.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(descending);

//        7. Write a Java program to find the maximum and minimum values in a list of integers using streams.
        nums = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);
        System.out.println("Original list of numbers: " + nums);
        // Find the maximum value
        Integer maxVal = nums.stream()
                .max(Integer::compare)
                .orElse(null);
        System.out.println(maxVal);

        Integer minVal = nums.stream()
                .min(Integer::compare)
                .orElse(null);

//        8. Write a Java program to find the second smallest and largest elements in a list of integers using streams.
        nums = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);
        System.out.println("List of numbers: " + nums);
        // Find the second smallest element
        Optional<Integer> first = nums.stream()
                .sorted()
                .skip(1)
                .findFirst();


        // Find the second largest element
        nums.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
    }
}
