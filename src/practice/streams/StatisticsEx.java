package practice.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StatisticsEx {
    public static void main(String[] args) {
        // Get count, min, max, sum, and the average for numbers
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics intSummaryStatistics = primes.stream()
                .mapToInt(x -> x)
                .summaryStatistics();
        System.out.println(intSummaryStatistics);

        // Calculate Average of Integers using Streams
        List<Integer> nums = Arrays.asList(1, 3, 6, 8, 10, 18, 36);
        double avg = nums.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
        System.out.println("average = " + avg);

        // Sum of even numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14);
        int sumOfEven = numbers.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(n -> n) // .mapToInt(Integer::intValue)
                .sum();
        System.out.println("sum of even = " + sumOfEven);

        // remove all duplicate elements from a list using streams
        List<Integer> nums2 = Arrays.asList(10, 23, 22, 23, 24, 24, 33, 15, 26, 15);
        List<Integer> removeDups = nums2.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("remove dups = " + removeDups);

        // find the maximum and minimum values in a list of integers
        List < Integer > nums3 = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);
        Integer max = nums3.stream()
                .max(Integer::compare)
                .orElse(null);
        System.out.println("max = " + max);

        // Find the min value
        Integer min = nums3.stream()
                .min(Integer::compare)
                .orElse(null);
        System.out.println("min = " + min);

        // Find the second smallest element
        Integer secondSmall = nums3.stream()
                .sorted()
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("second smallest = " + secondSmall);

        // Find the second largest element
        Integer secondLarge = nums3.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("second large = " + secondLarge);

    }
}
