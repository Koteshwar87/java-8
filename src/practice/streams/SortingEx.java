package practice.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingEx {
    public static void main(String[] args) {
        List<String> colors = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");
        // sort a list of strings in alphabetical order, ascending and descending using streams.
        List<String> sortedCol = colors.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedCol);

        // Descending
        List<String> descCol = colors.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(descCol);
    }
}
