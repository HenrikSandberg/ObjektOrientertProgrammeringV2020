package Arv;

/* 
    Et interface er ikke en klasse som kan bygges litt slik som en abstrakt klasse, 
    men den inneholder heller ikke noen krav om implementasjon, altså hva som skal være imellom {} etter deklarasjonen av metoden.
    Det eneste et interface krever er at de klassene som implemnterer den må ha en implemntasjon av metodene. 
    Å bruke interfacer til å kreve at visse metoder er implementert er svært så nyttig dersom du har en stor og kompleks kode struktur. 
    I motsettning til super klasser så kan klasser implemnetere mer enn et interface. 
    I dette litt kunstige oppsettet så implemnterer både forelser og administrasjon dette veldig enkle interfacet. 
*/
public interface Ansatt {
    public String giAnsattNummer();
}