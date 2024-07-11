package org.rdutta.tutorial.abstraction;

import java.util.UUID;

public abstract class PhoneFeatures {

    public String message(String msg){
        return "Sending Message:: "+msg;
    }

    public String call(String contact){
        return "Calling to "+contact+":: "+UUID.randomUUID()+"...";
    }

    public boolean isClick(UUID image_UID){
        return image_UID != null;
    }

    public abstract String camera(String image);
}
