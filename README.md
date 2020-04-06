# Klassekode2020
 Dette er kode fra rep forelesninger holdt våren 2020.

## Oppgaver
Her er noen oppgaver dere kan gjøre dersom dere ønsker å øve mer Java.
http://folk.uio.no/inf1010/v17/oppgaver/ 

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

## Interfacer
Ofte i Java så skulle man ønske at man kunne arve fra mer enn en klasse, men det er dessverre ikke mulig. En klasse kan bare ha en superklasse over seg. En super klasse kan ha mange barn (subklasser), men det går da altså ikke den andre veien. 
Dette har da blitt løst med interfacer i stede. Et interface er en klasse uten en eneste implementasjon. Det vil si, den inneholder kun metode signaturer, og ingen implementasjon av metoden. Det er da opp til hver enkelt klasse som bruker interface hvordan de ønsker å implementere det. 

### Hva er en metode signatur?
En metode signatur er en unik identifikator for en metode som sier hvem som har tilgang til den, hva den returnerer og hvilke parametere den trenger. Slik som eksemplene under:

```java
public boolean erAStørreEnnB(int a, int b);

public void gjørNoe();

public int øktallet(int a);
```

Alle disse tre er eksempler på signaturer. De varierer med hva de returnerer og hvilke parametere de har, men ingen av dem har noen implemntasjon.

### Hva er en implementasjon
En implementasjon er hva en metode skal gjøre når den blir bett om å gjøre noe. Hvis vi tar utgangspunkt i de tre over så kunne inplemntasjonene dere sett slik ut:
```java
{
	return a > b;
}

{
	System.out.println("Nå er noe gjort");
}

{
	return a + 1;
}
```

Alle disse tre kunne vært implementasjoner av de tre forrige signaturene, men de må ikke være sånn. Jeg tipper du kan komme opp med andre implementasjoner og det hadde vært helt greit! Det er en av styrkene til å bruke interfacer i programmering.

## Hva er forskjellen mellom et Interface og en Abstrakt klasse
Dette er kanskje det mest vanlige spørsmålet jeg får så jeg tenker at jeg skrive ned mine tanker om hva som er forskjellige mellom dem her og hva de kan brukes til på forskjellige måter. 

### Abstrakt klasse er en klasse
Dette sier seg litt selv, men jeg synes allikevel at det er viktig å påpeke. En abstrakt klasse er 100% lik en vanlig klasse for uten om en ting, du kan aldri lage en instans av dem.

```java
public abstract class MinKlasse {.....}

MinKlasse navn = new MinKlasse(); //Delen etter likhetstegnet er ikke lov.

```

Men det betyr ikke at du ikke kan lage referanser eller lister av denne klassen. Det er lov! 

```java
public class ArverFraMinKlasse extends MinKlasse {.....}

ArrayList<MinKlasse> liste = new ArrayList<>(); // Dette er lov
MinKlasse k = new ArverFraMinKlasse(); //Dette er lov

liste.add(k); // Dette er lov

```


La oss si at du har tre klasser som er ganske like, men som har noen forskjeller. Dette er veldig typisk i programmering. I dette tilfellet er det fornuftig å skille dem på hva som gjør dem unike, men beholde det som er felles i en overordnet klasse, en super klasse. Men du vil kanskje da ikke at denne super klassen skal kunne få lov til å bli laget en kopi av:

```java
//For eksempel hvis du lager et sjakk spill så vil du at alle brikkene skal ha samme metoder og variabler, men implemntasjonen vil da kanskje være forskjellig fra hver enkelt brikke.

public abstract class Brikke {
	protected int poeng;
	protected boolean erHvit;
	
	public Brikke(int poeng, boolean erHvit){....}

	public void flyttBrikke(int gammelPlassering, int nyPlassering){......}
}

public class Konge extends Brikke {
	public Konge(int poeng, boolean erHvit){....}

	@Override
	public void flyttBrikke(int gammelPlassering, int nyPlassering){......}
}

public class Løper extends Brikke {
	public Løper(int poeng, boolean erHvit){....}

	@Override
	public void flyttBrikke(int gammelPlassering, int nyPlassering){......}
}
```

Over har jeg skrevet et tenkt scenario hvor jeg liksom lager et sjakk program. Vi vet alle at alle sjakk brikker forholder seg til samme regler. De kan bare flyttes når det er din tur, du kan bare flytte en, de er enten sorte eller hvite og de har en assosiert poengsum som sier noe om hvem som er mer verdifull å ta ut av spillet over en annen brikke. Sjakk er ganske komplisert og forskjellig i implementasjonen, men strukturen for hver enkelt brikke vil være identisk. Det vil derfor være gunstig å ha en felles abstrakt brikke som alle klasser arver av. Samtidig ønsker vi aldri å ha en utgave av brikke på sjakkbrettet vårt fordi en generisk sjakkbrikke ikke eksisterer. Det eneste som da trenger å være forskjellig kan bli handtert i hver enkelt subklasse altså konge, dronning, løper, osv. 

![Arv fra abrstrakt klasse][image-1]
Dette er et enkelt hierarki. Alle klasser har her felles nevneren brikke i toppen og det er så komplisert dette hierarkiet trenger å være. Men hva om vi lager et litt mer komplisert system. 

### Interface er ikke en klasse
Et interface er ikke som en abstrakt klasse fordi den er uavhengig av arve hierarkier. Den bryr seg ikke om hva annet klassen som implementerer den holder på med, så lenge den så lenge den har en «lovlig» implementasjon av de metode signaturene interface krever. La oss si at vi håndterer hundrevis av databaser, og i alle databaser er det standard å implementere et sett med instruksjoner de såkalte CRUD operasjonene (Create, Read, Update & Delete). Hva som er i databasene og hvor de arver fra er fullstendig irrelevant så lenge klassen som implementerer dette interface at en implementasjon av disse fire funksjonene.

```java

public interface API{
	public Object create();
	public Object read(int plass);
	public boolean update(int plass);
	public void delete(int plass);
}

```

Dette gir ikke helt mening uten og gjøre denne generisk, men vær med på leken akkurat nå. Som du ser i interface over så inneholder den fire signaturer på metoder den krever at et objekt må implementere. Hvordan disse implementeres er opp til hver enkelt klasse/objekt.
```
public class HundeDatabase implements API {
	ArrayList<Hund> hundeListe = new ArrayList<>();

	public Object create(){
		Scanner skanner = new Scanner(System.in);
		System.out.println("Hva heter hunden?")
		String navn = skanner.nextLine();
		Hund nyHund = new Hund(navn);
		hundeListe.add(nyHund);
	}

	public Object read(int plass){
		Hund lestHund = hundeListe.get(plass);
		return lestHund;
	}

	public boolean update(int plass){
		Scanner skanner = new Scanner(System.in);
		System.out.println("Hva er hundes nye navn?")
		String navn = skanner.nextLine();
		
		hundeListe.set(plass, new Hund(navn);
		return true;
	}

	public void delete(int plass){
		hundeListe.remove(plass);
	}
}

public class StudentDatabase implements API {
	ArrayList<Student> studentListe = new ArrayList<>();
	
	public Object create(){
		Scanner skanner = new Scanner(System.in);
		System.out.println("Hva heter studenten?")
		String navn = skanner.nextLine();

		Student nyStudent = new Student(navn);
		studentListe.add(nyStudent);
	}

	public Object read(int plass){
		Student lestStudent = studentListe.get(plass);
		return lestStudent;
	}

	public boolean update(int plass){
		Scanner skanner = new Scanner(System.in);
		System.out.println("Hva skal studentens navn endres til?")
		String navn = skanner.nextLine();
		
		Student endretStudent = studentListe.get(plass);
		endretStudent.endreNavn(navn);

		studentListe.set(plass, endretStudent);
		return true;
	}

	public void delete(int plass){
		studentListe.remove(plass);
	}
}
```

Som du kan se av de to eksemplene over så inneholder listene der helt forskjellige objekter/klasser som arver fra helt forskjellige superklassen, men begge klassene har implementert interface API og er med det nødt til å implementere de frie metodene med samme signatur. Objekter/klasser som implementerer de samme interfacene kan bli lagt inn i lister på lik linje som klasser som har samme super klasse.

```java
//... Betyr at her ville det vært kode dersom dette var et ordentlig eksempel. 
// Den koden er ikke viktig for dette eksempelt

public abstract class Dyr {...}
public abstract class Fugle extends Dyr {...}
public abstract class Pattedyr extends Dyr {...}
public class Gris extends Pattedyr {...}

public abstract class Fisk extends Dyr {...}
public class Abbor extends Fisk {...}

public abstract class Amfibie extends Dyr {...}

public interface Rovdyr {
	public boolean spiserDen(Dyr d);
}

public class Ulv extends Pattery implements Rovdyr {
	...
	
	public boolean spiserDen(Dyr d) {
		if (d instanceof Fugle || d instanceof Fisk || d instanceof Pattedyr && d !instanceof Ulv) {
			return true;
		} else {
			return false;
		}
	}
}

public class Ørn extends Fugle implements Rovdyr {
	...
	
	public boolean spiserDen(Dyr d) {
		if (d instanceof Fugle || d instanceof Fisk) {
			return true;
		} else {
			return false;
		}
	}	
}

public class Main {
	public static void main(String[] args){
		ArrayList<Rovdyr> rovdyrliste = new ArrayList<>();
		
		rovdyrliste.add(new Ulv());
		rovdyrliste.add(new Ørn());

		for (Rovdyr dyr : rovdyrliste) {
			if (dyr.spiserDen(new Gris())){
				System.out.println(dyr.toString() + " spsier Gris");
			} else {
				System.out.println(dyr.toString() + " spsier Gris");
			}
		}
		
	}
}
```

Her kan vi se et litt mer komplekst hierarki hvor to forskjellige grener i arve treet har implementert det samme interfacet. Det gjør at de kan legges i samme liste og de kan kalle på den samme funksjonen UTEN å sjekke `instanceof`. Dette er fordi vi har en garanti at to klasser som har implementert det samme interfacet har den samme funksjonen. 

![Interface][image-2]

[image-1]: img/abstrakt.jpeg "Abstract"
[image-2]: img/interface.jpeg "Interface"
