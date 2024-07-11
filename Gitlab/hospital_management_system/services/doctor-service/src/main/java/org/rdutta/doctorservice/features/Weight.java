package org.rdutta.doctorservice.features;


import org.rdutta.doctorservice.features.generic.Measurement;

public class Weight extends Measurement<String> {
    public Weight() {}
    public Weight(String value, String unit) {
        super(value, unit);
    }
}
