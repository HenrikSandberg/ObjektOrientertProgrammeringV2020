package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Bil> bilListe = new ArrayList<>();
        Scanner skanner = new Scanner(System.in);
        String brukerKommando = "";
        boolean forstettAASkriveInn = true;

        while (forstettAASkriveInn) {
            System.out.println("\nTast inn en av foolgende komandoer:\n"+
                    "Lag en ny Elbil - e\n"+
                    "Lag en ny Personbil - p\n"+
                    "Lag en ny Lastebil - l\n"+
                    "Print alle biler - a\n"+
                    "Avslutt programmet - q");
            brukerKommando = skanner.nextLine();

            switch (brukerKommando) {
                case "e":
                    Elbil bil = genererElbil(skanner);
                    bilListe.add(bil);
                    break;
                case "p":
                    Personbil personbil = genererPrivatbil(skanner);
                    bilListe.add(personbil);
                    break;
                case "l":
                    Lastebil lastebil = genererLastebil(skanner);
                    bilListe.add(lastebil);
                    break;
                case "a":

                    //for (int i = 0; i < bilListe.size(); i++) {
                    //    System.out.println(bilListe.get(i).toString()); //navn[i] -> navn.get(i)
                    //}

                    for (Bil b : bilListe) {
                        System.out.println(b.toString());
                    }

                    break;
                case "q":
                    forstettAASkriveInn = false;
                    System.out.println("Avslutter program\nTakk for i dag! :)");
                    break;
                default:
                    System.out.println("Kommando " + brukerKommando + " er ukjent.");
            }
        }
    }

    private static String genererRegNr(Scanner skanner) {
        System.out.println("Skriv inn regNr: ");
        String regNr = skanner.nextLine();
        return regNr;
    }

    private static double genererUtslipp(Scanner skanner) {
        System.out.println("Skriv inn CO2-utslipp for bilen: ");
        String utslipp = skanner.nextLine();
        double tallUtslipp = Double.parseDouble(utslipp);
        return  tallUtslipp;
    }

    private static Elbil genererElbil(Scanner skanner) {
        String regNr = genererRegNr(skanner);
        System.out.println("Skriv inn batterikapasitet: ");

        String batterikap = skanner.nextLine();
        double tallBatteri = Double.parseDouble(batterikap);

        Elbil e = new Elbil(regNr, tallBatteri);
        return e;
    }

    private static Personbil genererPrivatbil(Scanner skanner){
        String regNr = genererRegNr(skanner);
        double utslipp = genererUtslipp(skanner);

        System.out.println("Tast inn antall seter: ");
        String seterTekst = skanner.nextLine();
        int seter = Integer.parseInt(seterTekst);

        Personbil p = new Personbil(regNr, utslipp, seter);
        return p;
    }

    private static Lastebil genererLastebil(Scanner skanner){
        String regNr = genererRegNr(skanner);
        double utslipp = genererUtslipp(skanner);

        System.out.println("Skriv inn nyttevekt: ");
        String tekstNyttevekt = skanner.nextLine();
        double nyttevekt = Double.parseDouble(tekstNyttevekt);

        Lastebil l = new Lastebil(regNr, utslipp, nyttevekt);
        return l;
    }
}
