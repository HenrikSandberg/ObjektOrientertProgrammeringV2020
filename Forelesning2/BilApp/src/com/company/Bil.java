package com.company;

public abstract class Bil {
    protected String regnr;

    public Bil(String regnr) {
        this.regnr = regnr;
    }

    @Override
    public String toString() {
        return "Reg.nr: " + regnr;
    }
}
