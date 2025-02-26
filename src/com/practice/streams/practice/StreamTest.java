package com.practice.streams.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class TempStudent {
    public String name;
    public int age;
    public Address address;
    public List<MobileNumber> mobileNumbers;

    public TempStudent(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.mobileNumbers = mobileNumbers;
    }
}

class Student{
    private String name;
    private int age;
    private Address address;
    private List<MobileNumber> mobileNumbers;

    public Student(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.mobileNumbers = mobileNumbers;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public List<MobileNumber> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", mobileNumbers=" + mobileNumbers +
                '}';
    }
}

class Address{
    private String zipcode;

    public Address(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}

class MobileNumber{
    private String number;

    public MobileNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
public class StreamTest {
    public static void main(String[] args) {
        Student student1 = new Student(
                "Jayesh",
                20,
                new Address("1234"),
                Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

        Student student2 = new Student(
                "Khyati",
                20,
                new Address("1235"),
                Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

        Student student3 = new Student(
                "Jason",
                20,
                new Address("1236"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444"), new MobileNumber("1234"), new MobileNumber("1233")));

        List<Student> students = Arrays.asList(student1, student2, student3);

        /*****************************************************
         Get student with exact match name "jayesh"
         *****************************************************/
        students
                .stream()
                .filter((student) -> student.getName().equals("jayesh"))
                .findFirst();


        /*****************************************************
         Get student with matching address "1235"
         *****************************************************/
        students
                .stream()
                .filter(student -> student.getAddress().getZipcode().equals("12345"))
                .findFirst();

        /*****************************************************
         Get all student having mobile numbers 3333.
         *****************************************************/

        List<Student> stud2 = students.stream()
                .filter(student111 -> student111.getMobileNumbers().stream().anyMatch(x -> Objects.equals(x.getNumber(), "3333")))
                .collect(Collectors.toList());

        List<Student> collect = students
                .stream()
                .filter(student ->
                        student.getMobileNumbers()
                                .stream()
                                .anyMatch(mobileNumber -> Objects.equals(mobileNumber.getNumber(), "3333"))
                ).collect(Collectors.toList());
        System.out.println("collect = " + collect);

        /*****************************************************
         Get all student having mobile number 1233 and 1234
         *****************************************************/
        List<Student> collect1 = students
                .stream()
                .filter(student ->
                        student.getMobileNumbers()
                                .stream()
                                .allMatch(mobileNumber -> Objects.equals(mobileNumber.getNumber(), "1233") || Objects.equals(mobileNumber.getNumber(), "1234"))
                ).collect(Collectors.toList());
        System.out.println("collect1 " + collect1);


        /*****************************************************
         Create a List<Student> from the List<TempStudent>
         *****************************************************/
        TempStudent tmpStud1 = new TempStudent(
                "Jayesh1",
                201,
                new Address("12341"),
                Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));

        TempStudent tmpStud2 = new TempStudent(
                "Khyati1",
                202,
                new Address("12351"),
                Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));

        List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);

        List<Student> collect2 = tmpStudents
                .stream()
                .map(tempStudent -> new Student(tempStudent.name, tempStudent.age, tempStudent.address, tempStudent.mobileNumbers))
                .collect(Collectors.toList());


        /*****************************************************
         Convert List<Student> to List<String> of student name
         *****************************************************/
        List<String> collect3 = students
                .stream()
                .map(student -> student.getName())
                .collect(Collectors.toList());
        System.out.println(collect3.stream().collect(Collectors.joining(",")));
        System.out.println(collect3.stream().collect(Collectors.joining(",", "[", "]")));
        System.out.println("--------------------");
        /*****************************************************
         Convert List<students> to String
         *****************************************************/
        String collect4 = students
                .stream()
                .map(student -> student.getName())
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect4);
        System.out.println("--------------------");
        /*****************************************************
         Change the case of List<String>
         *****************************************************/
        List<String> nameList =
                Arrays.asList("Jayesh", "Dany", "Khyati", "Hello", "Mango");
        List<String> collect5 = nameList
                .stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(collect5);
        System.out.println("--------------------");

        /*****************************************************
         Sort List<String>
         *****************************************************/
        List<String> namesList =
                Arrays.asList("Jayesh", "Dany", "Khyati", "Hello", "Mango");
        namesList
                .stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("--------------------");

        /*****************************************************
         Conditionally apply Filter condition, say if flag is enabled then
         *****************************************************/


    }
}
