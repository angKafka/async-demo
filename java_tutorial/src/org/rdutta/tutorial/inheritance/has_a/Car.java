package org.rdutta.tutorial.inheritance.has_a;

public class Car {
    private String model;
    private String color;
    private Engine engine; // Car HAS-A Engine

    public Car(String model, String color, Engine engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void startCar() {
        System.out.println("Starting the car...");
        engine.start();
    }

    public void stopCar() {
        System.out.println("Stopping the car...");
        engine.stop();
    }

    public void displayCarInfo() {
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Engine Type: " + engine.getType());
        System.out.println("Horsepower: " + engine.getHorsepower());
    }

    public static void main(String[] args) {
        Engine engine = new Engine("V8", 450);
        Car car = new Car("Ford Mustang", "Red", engine);

        car.displayCarInfo();
        car.startCar();
        car.stopCar();
    }
}
