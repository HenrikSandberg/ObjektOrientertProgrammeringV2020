package com.company;

public class Personbil extends Fossilbil {
    private int seter;

    public Personbil(String regnr, double utslipp, int seter){
        super(regnr, utslipp);
        this.seter = seter;
    }

    @Override
    public String toString(){
        return "Type motorvogn:      Personbil\n" +
                super.toString() +
                "\nSeter: " + seter;
    }
}
