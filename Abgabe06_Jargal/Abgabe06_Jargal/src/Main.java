public class Main {
    public static void main(String[] args) {
//  2 Instanzen
        Produkt p1 = new Produkt();
        Produkt p2 = new Produkt("Smart Handy", 150.00, 200);

        System.out.println("----------------------------------------");
//
        System.out.println("Verfügbare Stücke: " + p1.verfuegbar());
        System.out.println("Gesamtwert: " + p1.berechneGesamtwert());
        System.out.println("----------------------------------------");

//
        System.out.println("Verfügbare Stücke: " + p2.verfuegbar());
        System.out.println("Gesamtwert: " + p2.berechneGesamtwert());
        System.out.println("----------------------------------------");

//        Set-Methoden werden verändert

        p1.setMenge(250);
        p1.setPreis(1500.00);

        p2.setMenge(400);
        p2.setPreis(367.00);

        System.out.println("Verfügbare Stücke: " + p1.verfuegbar());
        System.out.println("Gesamtwert: " + p1.berechneGesamtwert());
        System.out.println("----------------------------------------");
//
        System.out.println("Verfügbare Stücke: " + p2.verfuegbar());
        System.out.println("Gesamtwert: " + p2.berechneGesamtwert());
        System.out.println("----------------------------------------");


//        Gesamtwert von beiden Produkten
        System.out.println("Gesamtwert von beiden Produkten: " + (p1.berechneGesamtwert() + p2.berechneGesamtwert()));

// Aufgabe 2
        System.out.println("--------------------------");
        System.out.println("--------------------------");

        System.out.println("Aufgabe 2");
        System.out.println("--------------------------");

        Sortiert3 s1 = new Sortiert3(10,5,17);
        s1.print();
        System.out.println("--------------------------");
        Sortiert3 s2 = new Sortiert3(33,45,100);
        s2.print();
        System.out.println("--------------------------");

        Sortiert3 s3 = new Sortiert3(15,16,21);
        s3.print();
        System.out.println("--------------------------");

// Aufgabe 3
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        System.out.println("Aufgabe 3");
        System.out.println("--------------------------");

        Taschnerechner t1 = new Taschnerechner();
        Taschnerechner t2 = new Taschnerechner(5,23, '/');

        t1.rechne();
        t2.rechne();

    }
}
