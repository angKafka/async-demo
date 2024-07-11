package org.rdutta.tutorial.abstraction;

import java.util.UUID;

public class Customer extends Iphone{
    public static void main(String[] args) {
        PhoneFeatures phoneFeatures = new Iphone();

        System.out.println(
                phoneFeatures.call("7992204910")+"\n"+
        phoneFeatures.message("Hi Raj")+"\n"+
        phoneFeatures.camera(String.valueOf(UUID.randomUUID()))
        );
    }
}
