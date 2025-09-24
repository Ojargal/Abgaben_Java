import java.util.Scanner;
import java.text.DecimalFormat;

import static java.lang.String.*;

public class Main {
    public static void main(String[] args) {

        aufgabe1();
        aufgabe2();
        aufgabe3();

    }

    private static void aufgabe3() {
        Scanner sc = new Scanner(System.in);
//        Wald erstellen
        System.out.println("Geben Sie bitte einen Namen für Ihren Wald ein:");
        String name = sc.nextLine();
        Wald wald = new Wald(name);

//        Bäume pflanzen
        wald.pflanzen(new Baum("Eiche", 12, 5.23,false, 22.5));
        wald.pflanzen(new Baum("Buche", 18, 4.5,false, 15));
        wald.pflanzen(new Baum("Fichte", 42, 8,true, 30));
        wald.pflanzen(new Baum("Eiche", 60, 25.0, false, 1.2));
        wald.pflanzen(new Baum("Buche", 40, 20.0, true, 0.8));
        wald.pflanzen(new Baum("Fichte", 30, 15.0, false, 0.5));
        wald.pflanzen(new Baum("Eiche", 250, 10,false, 1200));

//        Waldinformationen ausgeben
        System.out.println("------- Waldzustand --------");
        wald.print();

//        Baum fällen (wenn älter als 50 Jahre)
        Baum gefaellterBaum = wald.faellen();
        if (gefaellterBaum != null){
            System.out.println("\nGefällter Baum");
            gefaellterBaum.print();
        } else {
            System.out.println("\nKein Baum zum Fällen.");
        }

        System.out.println("Geben Sie bitte Wert des Waldes (Euro/m3): ");
        System.out.println("\nWert des Waldes: " + String.format("%2f", wald.wert(sc.nextDouble())) + " Euro");


//         Kranke Bäume zählen
        System.out.println("Anzahl kranker Bäume: " + wald.anzahlKrank());

    sc.close();

    }

    private static void aufgabe2() {

                // Test-Array erstellen
                String[] testArray = {"Hallo", "Welt", "Java", "Programmierung"};
                StringArray sa = new StringArray(testArray);

                // Originales Array ausgeben
                System.out.println("Originales Array:");
                sa.print();

                // Array umdrehen
                sa.umdrehen();
                System.out.println("\nArray nach umdrehen():");
                sa.print();

                // Array nach rechts schieben
                sa.rechtsSchieben();
                System.out.println("\nArray nach rechtsSchieben():");
                sa.print();

                // Array nach links schieben (um 2 Stellen)
                sa.linksschieben(2);
                System.out.println("\nArray nach linksschieben(2):");
                sa.print();

                // Suche nach einem String
                String suchString = "Java";
                System.out.println("\nIst \"" + suchString + "\" im Array? " + sa.suchen(suchString));

                // Zufälligen String generieren
                int laenge = 5;
                System.out.println("\nZufälliger String der Länge " + laenge + ": " + StringArray.zufall(laenge));
            }


    private static void aufgabe1() {

        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
//        1. Array erstellen
        System.out.print("Geben Sie die Größe des Arrays ein: " );
        int groesse = sc.nextInt();
        ZahlenVerwaltung zv = new ZahlenVerwaltung(groesse);
//        2. Array befüllen (Benutzer oder Zufall)
        System.out.println("\n--- Methode'fuellen()' ---");
        zv.fuellen();
        System.out.println("Array mit Zufallszahlen (-100 bis 100):");
        zv.ausgeben();

        System.out.println("\n--- Methode'eingeben()' ---");
        zv.eingeben(); // Manuelle Eingabe + ggf. Zufallszahlen
        System.out.println("\nFinales Array:");
        zv.ausgeben();

//        3. Methoden testen
        System.out.println("\n--- Methoden-Testen ---");
        System.out.println("Kleinste Zahl (min): " + df.format(zv.min()));
        System.out.println("Zweitgrößte Zahl (max2): " + df.format(zv.max2()));
        System.out.println("Produkt aller Zahlen (mul): " + df.format(zv.mul()));
        System.out.println("Durchschnitt (durch): " + df.format(zv.durch()));

//        4. Array sortieren
        System.out.println("\n--- Sortiertes Array ---");
        zv.sort();
        zv.ausgeben();

        sc.close();
    }
}