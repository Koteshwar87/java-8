package com.educative.methods;

public class InterfaceStaticMethod {
}

class Car implements Vehicle {
    /*@Override  // Cannot override a Static method of the interface
    public void cleanVehicle() {
        System.out.println("Cleaning the vehicle");
    }*/

    public static void main(String[] args) {
        Car car = new Car();
        // car.cleanVehicle(); //This will not compile, because it is a static method. It is only accessible with Interface name
        Vehicle.cleanVehicle();
    }
}

interface Vehicle {
    static void cleanVehicle () {
        System.out.println("I am cleaning vehicle");
    }
}
