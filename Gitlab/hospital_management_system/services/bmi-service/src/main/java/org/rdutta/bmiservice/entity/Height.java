package org.rdutta.bmiservice.entity;

import org.rdutta.bmiservice.generic.Measurement;

public class Height extends Measurement<String> {
    public Height() {}
    public Height(String value, String unit) {
        super(value, unit);
    }
}
