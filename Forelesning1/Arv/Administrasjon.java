package Arv;

public class Administrasjon extends Person implements Ansatt {
    private String ansattNummer;

    public Administrasjon(String navn, int alder, String ansattNummer){
        super(navn, alder);
        this.ansattNummer = ansattNummer;
    }

    @Override
    public String giAnsattNummer(){
        return ansattNummer;
    }
}