# Klassekode2020
 Dette er kode fra rep forelesninger holdt våren 2020.

## Oppgaver
Her er noen oppgaver dere kan gjøre dersom dere ønsker å øve mer Java.
[\[Oppgaver Inf1010] http://folk.uio.no/inf1010/v17/oppgaver/ ]()

## Objektorientert programmering
En fornuftig tanke å ta med seg når man tenker objektorientert programmering er at man tenker at man samler ting som har noe med hverandre å gjøre inn i en engen samling. Denne samlingen for et objekt eller klasse i Java. Dette er også hovedtanken som rår igjennom hele språket. I fjor så lærte vi at JavaScript leser kode fra topp til bunn, men det er ikke tilfellet når man starter et Java program. For når vi skriver et Java terminal program så starter koden med å lete etter metoden `public static void main(String[] args)`. Dette er den offisielle starteren på alle terminal programmer i Java. Herifra kan koden hoppe fra klasse fil til klasse fil og mellom forskjellige funksjoner for å eksekvere forskjellige oppgaver. 

## Klasse
Strukturen på en klasse er ganske så standarisert. Du bør alltid samle informasjon som har noe med hverandre å gjøre inne i en klasse. Tenk på en klasse også som en beskrivelse av hvordan et slik objekt skal kunne se ut og oppføre seg. Selve klasse fila er ikke en spesifikk utgave, men heller et sett med instruksjoner og metoder som kan brukes for alle utgaver av klassen.
Som et eksempel så kan vi lage en klasse som heter hund:
```java
public class Hund {
	String navn;
	int alder;
	
	public Hund(String navn, int alder) {
		this.navn = navn;
		this.alder = alder;
	}

	public void bjeff() {
		System.out.println("Woff Woff");
	}

}
```

Denne klassen inneholder litt forskjellige. Først finner vi to variabler. Begge disse starter med verden null. Siden jeg ikke har spesifisert hvor tilgjengelig de er så er begge offentlige (public). Det vil si at hvem som helst vil kunne manipulere variablene så mye de vil etter at en instans av klassen har blitt startet opp.

### Konstruktør
Under variablene finner vi  en konstruktør. Konstruktører er nødvendige for å kunne starte opp en utgave av en klasse. En klasse kan inneholde så mange konstruktører du bare vil, men husk å sette verdiene over til noe, ellers vil du kunne få `NullPointerException` og programmet ditt vil kunne krasje. Under har jeg tre eksempler på konstruktører som kunne være lagt inn i klassen over i tillegg til den ene som allerede er der.

```java
public Hund(String navn) {
	this.navn = navn;
	alder = 0;
}

public Hund(int alder) {
	navn = "";
	this.alder = alder;
}

public Hund() {
	navn = "";
	alder = 0;
}

```

Med disse konstruktørene så kan man lage mange forskjellige utgaver av hund og fremdeles være sikker på at det fungerer. 
```java
Hund fido = new Hund("Fido", 2);
Hund rex = new Hund("Rex");
Hund gatehund = new Hund(2);
Hund ukjent = new Hund();
```

Alle disse fire måtene vil være lovlige måter å generere en klasse på dersom alle fire konstruktørene er implementert.

#### This
Som du kanskje har lagt merke til bruker jeg ordet this. foran variablene mine hver gang jeg sette en variabel lokalt likt en av variablene til klassen. Dette er fordi Java ikke skjønner at jeg mener den referansen til navn utenfor krøll parentesene når jeg er i mellom dem og jeg har en variabel med sammen navn der inne. Jeg kunne gjort dette på denne måten også og det hadde vært helt greit:

```java
public Hund(String n, int a) {
	navn = n;
	alder = a;
}
```

Men dette gjør koden mye mindre lesbar. Ja det er enkelt å forstå i et så enkelt eksempel som dette, men med en gang man begynner å kode mer komplekse klasser eller jobber i større prosjekter så er litt besparelse på tid ikke verdt det i forhold til god lesbarhet. Det er derfor bedre å kalle de det samme også heller bare legge til en this referanse for å få tak i variabler utenfor konstruktøren i stede. 

### Metoder
Når man lager en klasse så lager man streng tatt ikke lenger funksjoner, men heller metoder. Dette er streng tatt litt flisespikkeri for de som liker det da metoder er funksjoner, men som tilhører en klasse. Det er den store forskjellen 🙄

Metoder I Java bygges på litt forskjellige måter avhengig av hva du ønsker å oppnå ved å bruke dem. Det som er veldig forskjellige fra JavaScript er at dette er viktig å deklarere i signaturen til en metode. I stede for å legge ut i en lang tekst her så er det bedre at jeg beskriver det med en metode eller to:
```java
// Signaturen her sier at dette er en offentlig metode som kan
// bli kalt på utenfor klassen. Den skal ikke returnere noe. 
// Den tar imot et tall og endrer et annet tall unefor metoden til dette nye tallet. 
// Dette er en meget klassisk setter metode som brukes til stadighet i Java.
public void setTall(int nyttTall){
	tall = nyttTall;
}

// Signaturen her sier at dette er en offentlig metode som kan bli kalt på utenfor klassen. 
// Den skal returnere en boolean (true, false). 
// Den heter samenlikn og den krever to parametere nemlig to inter a og b.
public boolean samenlikn(int a, int b) { 
	boolean resultat = a < b;
	return resultat;
}

// Denne metoden er privat for klassen og kan bare bli kalt internt. 
// Det vil si, kun andre metoder inne i samme klasse vil kunne kalle på denne metoden. 
// Det virker kanskej litt fjernt nå, men dette er en veldig vanslig ting å gjøre i Java prigrammering.
private void reset(){
	poeng = 0;
	spiller = null;
}




```

Slik som i JavaScript så kan altså metoder returnere verdier, men det må sies fra i forkant og den må ende med å returnere noe. Det som ikke kommer helt klart frem her er at metodene dine hvis de har en return verdi også kan returnere `null`. Dersom det er tilfellet så er det smart å alltid passe på å gjøre en `if` sjekk bare for å unngå `NullPointerException`. 


## Abstrakte klasser
Abstrakte klasser er klasser som det ikke kan lages en instans av. Det vil si du kan aldri lage en spesifikt utgave av dem. Så hvorfor i alle dager har vi dem da, spør du kanskje? Vel, de er veldig smarte å bruke dersom det er en del felles nevnere inne i koden din. La oss si at du lager et du lager IMDB for TV programmer. I stede for å lage en klasse for skuespiller, regissør, produsent, statist, osv. med alle variabler så kan det være smart å flytte alle felles nevnere som navn, alder, bilde, osv til en super klasse som heter for eksempel person. Denne klassen kan da inneholde alle felles nevnere for alle de andre klassene. Men du vil jo helst ikke ha en variant av denne klassen i databasen din. Derfor burde du gjøre denne klassen abstrakt. Abstrakte klasser fungerer helt som en vanlig klasse annet annet at du ikke kan lage en konkret utgave av den klassen. 

```java
public abstract class Person {
	String navn;
	Person(String navn) {
		this.navn = navn;
	}
}

public Skuspiller extends Person {
	Skuspiller(String navn){
		super(navn);
	}
}

Person peron = new Person("Grete"); // Dette er ikke lov
Person nils = new Skuspiller("Nils"); // Dette er lov
Skuspiller harald = new Skuspiller("Harald"); // Dette er lov

```

Det er ikke bare variabler som trenger å være felles, det kan også være metoder. De er helt like andre super klasser. 

