package org.rdutta.bmiservice.entity;

import org.rdutta.bmiservice.generic.Measurement;

public class Weight extends Measurement<String> {
    public Weight() {}
    public Weight(String value, String unit) {
        super(value, unit);
    }
}
