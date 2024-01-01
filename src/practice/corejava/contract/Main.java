package practice.corejava.contract;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Book> books = new HashSet<>();

        Book book1 = new Book("Java Basics", "John Doe");
        Book book2 = new Book("Java Basics", "Jane Doe");

        books.add(book1);
        books.add(book2);

        System.out.println("Number of books in set: " + books.size());
        System.out.println("Books in set: " + books);
    }
}