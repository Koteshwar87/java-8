package practice.streams;

import java.util.Arrays;
import java.util.List;

public class FilterEx {
    public static void main(String[] args) {
        // Counting Empty String
        List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
        long count = strList.stream().filter((str) -> str.isEmpty()).count();
        System.out.println(count);

        // Count String whose length is more than three
        long len3 = strList.stream().filter((str) -> str.length() > 3).count();
        System.out.println("len3 = " + len3);

        // Count number of String which starts with "a"
        long startA = strList.stream().filter((str) -> !str.isEmpty() && str.charAt(0) == 'a').count();
        System.out.println("start a = " + startA);
    }
}
