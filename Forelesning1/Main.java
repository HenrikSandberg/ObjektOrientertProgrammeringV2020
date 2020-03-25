import Arv.*;
import java.util.Scanner;

/* 
 Denne Main klassen og funskjonen innehodler veldig mye kode. Det er anbefalt å ha så små main funksjoner som overhode mulig dersom det er mulig å gjøre. 
 Det er også en god del kode er som er statisk alstå ikke endrer seg som ikke burde være statisk. 
 Dette er for å først vise konsptene Arv, Polimorfi, abstrakte klasser og interfacer. 
 I tillegg til dette gjør jeg bruk at Scanner for å lese inn tekst skrevet i terminalen. Alt gått igjennom i denne forelesningen vil være essensielt for arbeidskravet deres. 
*/

public class Main {
    public static void main(String[] args) {
        String[] emner = {"TK2100", "PGR102", "PGR103", "PRO104"};
        Person[] personer = new Person[10];

        personer[0] = new Foreleser("Harald", 23, "BJ123", emner);
        personer[1] = new Student("Trine", 19, 63122, emner);

        // Har med vilje ikke overskrevet toString på Administrasjon for å vise at da vil Person sin toString bli brukt
        personer[2] = new Administrasjon("Hilde", 56, "TT37482"); 

        Scanner skannerObjekt = new Scanner(System.in);
        String tekstFraBruker = "";

        // Oppretter en evig løkke som kun avsluttes dersom bruker taster inn boksatevn q
        // compareTo samenlikner to verdier, men i motsettning til equals så kan den returnere 3 verider
        // Et negativt tall, altså verdien foran compareTo er mindre enn den inne i ()
        // Tallet null, da er begge like
        // eller et poestivt tall, da er verdien utenfor compareTo() større enn den inni
        while (tekstFraBruker.compareTo("q") != 0) {
            System.out.println("Hva ønsker du å gjøre?\n"+
            "Lag ny Student: s\n"+
            "Lag ny Foreleser: f\n"+
            "Lag ny Administrasjon: admin\n"+
            "Print ut alle studenter: a\n"
            +"Avslutt: q");
            tekstFraBruker = skannerObjekt.nextLine();

            if (tekstFraBruker.equals("s") || tekstFraBruker.equals("f") || tekstFraBruker.equals("admin")) {
                System.out.println("Hva heter person?");
                String navn = skannerObjekt.nextLine();

                System.out.println("Hvor gammel er person? ");
                String alder = skannerObjekt.nextLine();
                int tallAlder = Integer.parseInt(alder);


                for (int i = 0; i < personer.length; i++) {
                    if (personer[i] == null) {
                        if (tekstFraBruker.equals("s"))
                            personer[i] = new Student(navn, tallAlder, 1234, emner);
                        else if (tekstFraBruker.equals("f"))
                            personer[i] = new Foreleser(navn, tallAlder, "1234", emner);
                        else if (tekstFraBruker.equals("admin"))
                            personer[i] = new Administrasjon(navn, tallAlder, "1234");
                        break;
                    }
                }
            } else if (tekstFraBruker.equals("a")) {
                printinfoAbout(personer);
            } else if (tekstFraBruker.equals("q")) {
                break;
            } else {
                System.out.println("Beklager, men skjønte ikke komandoen din. Vil du prøve å skrive en gang til?");
            }
        }

        // Når programmet avsluttes så må scanneren også avsluttes på en ordentlig måte. Dette gjøres ved å bruke metoden .close() på objektet.
        skannerObjekt.close();
    }


    // Splittet koden fra forelesnignen inn i funskjoner slik at det skal bli lettere å lese igjennom.
    public static void printinfoAbout(Person[] personliste) {
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