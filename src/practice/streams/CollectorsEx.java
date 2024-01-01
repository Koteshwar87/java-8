package practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsEx {
    public static void main(String[] args) {
        // Remove all empty Strings from List
        List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
        List<String> filteredList = strList.stream().filter((str) -> !str.isEmpty()).collect(Collectors.toList());
        System.out.println("filtered List = " + filteredList);

        // Create a List with String more than 2 characters
        List<String> moreThan3Len = strList.stream().filter((str) -> str.length() > 3).collect(Collectors.toList());
        System.out.println("len more than 3 = " + moreThan3Len);
    }
}
