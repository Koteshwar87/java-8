package com.educative.methods;

// Diamond problem
// Ambiguity occurs for the default method so compilation error

public class InterfaceDefaultMethod {
    public static void main(String[] args) {
        Main main = new Main();
        main.printSomething();
    }
}

class Main implements InterfaceA, InterfaceB {

    @Override
    public void printSomething() {
        System.out.println("I am inside Main class");

        InterfaceA.super.printSomething();
        InterfaceB.super.printSomething();
    }
}

interface InterfaceA {
    default void printSomething() {
        System.out.println("I am inside A interface");
    }
}

interface InterfaceB {
    default void printSomething() {
        System.out.println("I am inside B interface");
    }
}
