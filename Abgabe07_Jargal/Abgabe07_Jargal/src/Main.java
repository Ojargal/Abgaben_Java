//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Zeit z1 = new Zeit();
        Zeit z2 = new Zeit(15,23,59);
        Zeit z3 = new Zeit(1,2, 4);

        z1.printZeit();
        z1.addiereSekunden(4523);
        z1.printZeit();
        z1.addiereMinuten(60);
        z1.printZeit();
        z1.addiereStuden(120);
        z1.printZeit();
        System.out.println("------------------");
        z2.printZeit();
        z2.addiereSekunden(4523);
        z2.printZeit();
        z2.addiereMinuten(400);
        z2.printZeit();
        z2.addiereStuden(120);
        z2.printZeit();


        System.out.println("------------");
        System.out.println("Aufgabe 2");
        System.out.println("------------");
        Dreieck d1 = new Dreieck();
        Dreieck d2 = new Dreieck(2,3,5);
        Dreieck d3 = new Dreieck(2,5,4);
        Dreieck d4 = new Dreieck(15,15,26);

        d1.print();
        d1.setC(4);
        d1.setA(5);
        d1.setB(3);
        d1.print();
        System.out.println("------------");
        d1.print();
        d1.setC(4);
        d1.setA(5);
        d1.setB(3);
        d1.print();
        System.out.println("------------");



        System.out.println("------------");
        System.out.println("Aufgabe 3");
        System.out.println("------------");


        Schueler schueler1 = new Schueler();
        schueler1.print();

        schueler1.lernen(); // Note ändern
        schueler1.print();

        schueler1.aufsteigenOderWiederholen(); // Schulstufe ändern
        schueler1.print();




        System.out.println("\n===== Testfall 2: Schüler mit spezifischen Werten (Note 5) =====");
        Schueler schueler2 = new Schueler("Anna Mustermann", 7, 5, 6, "Gymnasium Alpha");
        schueler2.print();

        schueler2.aufsteigenOderWiederholen(); // Sollte wiederholen, da Note 5
        schueler2.print();

        schueler2.lernen(); // Versuchen, die Note zu verbessern
        schueler2.print();

        schueler2.aufsteigenOderWiederholen(); // Erneut versuchen aufzusteigen
        schueler2.print();




        System.out.println("\n===== Testfall 3: Schüler kurz vor Schulabschluss =====");
        Schueler schueler3 = new Schueler("Max Fleißig", 12, 2, 11, "Berufsschule IT");
        schueler3.print();
        schueler3.aufsteigenOderWiederholen(); // Sollte aufsteigen
        schueler3.print();
        schueler3.aufsteigenOderWiederholen(); // Sollte Schulabschluss melden
        schueler3.print();

        System.out.println("\n===== Testfall 4: Schüler mit Note 1 (kann nicht besser werden) =====");
        Schueler schueler4 = new Schueler("Lisa Super", 4, 1, 3, "Grundschule Sonnenblume");
        schueler4.print();
        schueler4.lernen(); // Sollte Meldung ausgeben, dass Note 1 ist
        schueler4.print();

        System.out.println("\n===== Testfall 5: Ungültige Werte bei der Erstellung (werden von Settern abgefangen) =====");
        Schueler schueler5 = new Schueler("Fehler Schüler", 0, 6, -1, ""); // Schulstufe, Note, AnzahlSchuljahre, Schule ungültig
        schueler5.print(); // Output sollte die Fehlermeldungen der Setter zeigen





    }
}