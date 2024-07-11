package org.rdutta.bmiservice.generic;

public class Measurement<T>{
    private T value;
    private T unit;

    public Measurement() {}

    public Measurement(T value, T unit) {
        this.value = value;
        this.unit = unit;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getUnit() {
        return unit;
    }

    public void setUnit(T unit) {
        this.unit = unit;
    }
}
