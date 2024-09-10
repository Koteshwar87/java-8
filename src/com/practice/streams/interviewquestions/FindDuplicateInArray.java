package com.practice.streams.interviewquestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDuplicateInArray {
    public static void main(String[] args) {
        // Sample array with duplicates
        int[] array = {1, 2, 3, 4, 5, 2, 6, 7, 8, 9, 1, 10};

        /*List<Integer> collect = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy((i -> i), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(ele -> ele.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());*/

        List<Integer> collect = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy((n -> n), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(num -> num.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(collect);

    }
}
