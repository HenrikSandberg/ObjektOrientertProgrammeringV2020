package com.company;

public class Lastebil extends Fossilbil {
    private double nyttevekt;

    public Lastebil(String regnr, double utslipp, double nyttevekt) {
        super(regnr, utslipp);
        this.nyttevekt = nyttevekt;
    }

    @Override
    public String toString(){
        return "Type motorvogn:      Lastebil\n" +
                super.toString() +
                "\nNyttevekt: " + nyttevekt;
    }
}

