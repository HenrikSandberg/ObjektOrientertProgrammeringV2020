package com.company;

public abstract class Fossilbil extends Bil {
    protected double utslipp;

    public Fossilbil(String regnr, double utslipp) {
        super(regnr);
        this.utslipp = utslipp;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCO2-utslipp: " + utslipp;
    }
}

