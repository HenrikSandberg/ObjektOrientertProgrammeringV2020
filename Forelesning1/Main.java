import Arv.*;

public class Main {
    public static void main(String[] args) {
        String[] emneliste = {"TK2100", "PGR102", "PGR103", "PRO104"};
        Person[] personliste = new Person[10];

        personliste[0] = new Foreleser("Harald", 23, "BJ123", emneliste);
        personliste[1] = new Student("Trine", 19, 63122, emneliste);

        // Har med vilje ikke overskrevet toString på Administrasjon for å vise at da vil Person sin toString bli brukt
        personliste[2] = new Administrasjon("Hilde", 56, "TT37482"); 

        for (int i = 0; i < personliste.length; i++){
            if (personliste[i] != null) {
                // Siden begge har en implementasjon av toString så vil dette vise begge sin utgave. 
                // Dersom det ikke var tilfellet ville den brukt Person sin toString()
                // Og hvis person ikke hadde hatt toString() så ville den brukt Object sin verson
                System.out.println(personliste[i].toString());

                // Dersom personen er av typen ansatt så skal den også skrive ut Ansatt nummeret til individet
                if (personliste[i] instanceof Ansatt) {
                    Ansatt midlertidigAnsattreferanse = (Ansatt) personliste[i];
                    System.out.println("Ansattnummer:\n " + midlertidigAnsattreferanse.giAnsattNummer());
                } else if (personliste[i] instanceof Student){
                    Student midlertidigStudentreferanse = (Student) personliste[i];
                    System.out.println("Emner:\n");
                    midlertidigStudentreferanse.printEmner();
                }
                System.out.println("\n");
            } 
        }
    }
}