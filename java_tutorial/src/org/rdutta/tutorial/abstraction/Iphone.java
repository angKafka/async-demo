package org.rdutta.tutorial.abstraction;

import java.util.UUID;

public class Iphone extends PhoneFeatures{

    @Override
    public String message(String msg) {
        return super.message(msg);
    }

    @Override
    public String call(String contact) {
        return super.call(contact);
    }

    @Override
    public boolean isClick(UUID image_UID) {
        return super.isClick(image_UID);
    }

    @Override
    public String camera(String image) {
        UUID image_UUID = UUID.fromString(image);
        if (!isClick(image_UUID)){
            return "No Image Taken!!";
        }else{
            return "Image Taken with id: " + image_UUID;
        }
    }
}
