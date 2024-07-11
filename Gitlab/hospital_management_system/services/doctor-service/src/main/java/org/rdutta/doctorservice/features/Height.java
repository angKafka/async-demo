package org.rdutta.doctorservice.features;


import org.rdutta.doctorservice.features.generic.Measurement;

public class Height extends Measurement<String> {
    public Height() {}
    public Height(String value, String unit) {
        super(value, unit);
    }
}
