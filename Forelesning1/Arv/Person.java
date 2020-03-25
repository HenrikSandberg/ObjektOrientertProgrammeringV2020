package Arv;

public abstract class Person {
    protected String navn;
    private int alder;

    public Person(String navn, int alder) {
        this.navn = navn;
        this.alder = alder;
    }

    @Override 
    public String toString() {
        return "Hallo, mitt navn er " + navn + " og jeg er " + alder + " år gammel.";
    }

    public String giNavn() {
        return navn;
    }

    public void økAlder() {
        alder = alder + 1;
    }

    public int giAlder() {
        return alder;
    }

}