package Arv;
/* 
 Personklassen er en abstrakt klasse. Det vil si at klassen ikke kan bli laget en utgave av direkte, men dersom det finnes subklasser (eller banreklasser) 
 som arver fra Person så få de klassene tilgang til alle metoder, offentlige og beskyttete variabler som finnes i denne klassen.
*/
public abstract class Person {
    // Det finnes tre type tilganger man kan få til variabler og metoder
    // Public - Alle har tilgang til dem og kan endre dem så mye de vil
    // Private - Bare klassen selv som har tilgang til den og ingen andre
    // Protected - Bare klassen og de klassene som arver fra klassen som har tilgang
    // Det er ofte smart å sette det meste til protected i absrakte klasser sånn at subklasser kan også fint få tilgang
    // til alle variabler og metoder som finnes inne i klassen. 
    
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