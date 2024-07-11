package org.rdutta.tutorial.constructor;

import java.util.UUID;

public class Car {
    private UUID car_uid;
    private String company;
    private String model;

    public Car(UUID car_uid, String company, String model){
        this.car_uid = car_uid;
        this.company = company;
        this.model = model;
    }

    public Car(UUID car_uid, String company){
        this.car_uid = car_uid;
        this.company = company;
    }

    public static void main(String[] args) {
        Car object = new Car(
                UUID.randomUUID(),
                "AUDI"
        );


        System.out.println("Car_ID:: "+object.car_uid+"\n"+"Company:: "+object.company);
    }
}
