package task_7;

public class DynamicBinding {

    public static void main(String[] args) {
        Vehicle bike = new Bicycle();
        bike.go(); // здесь применяется динамическое связывание
    }
}


abstract class Vehicle {
    public abstract void go();
}

class Bicycle extends Vehicle {
    public void go() {
        System.out.println("Ride a bike");
    }
}

class Car {
    void go() {
        System.out.println("Drive a car");
    }
}