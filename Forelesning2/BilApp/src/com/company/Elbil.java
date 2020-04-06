package com.company;

public class Elbil extends Bil {
    private double kWh;

    public Elbil(String regnr, double kWh) {
        super(regnr);
        this.kWh = kWh;
    }

    @Override
    public String toString(){
        return "Type motorvogn:      Elbil\n" +
                super.toString() +
                "\nBatterikapasitet (kWh): " + kWh;
    }
}