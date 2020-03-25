package Arv;

public class Foreleser extends Person implements Ansatt {
    private String ansattNummer;
    private String[] emner;

    public Foreleser(String navn, int alder, String ansattNummer, String[] emner) {
        super(navn, alder);
        this.ansattNummer = ansattNummer;
        this.emner = emner;
    }

    public String giAnsattNummer() {
        return ansattNummer;
    }

    @Override
    public String toString(){
        String printStreng = "Foreleser " + navn +"\n\nEmner:\n";
        
        for (int i = 0; i < emner.length; i++) {
            if (emner[i] != null) {
                printStreng += " " + emner[i] + "\n";
            }
        }

        return printStreng;
    }

}