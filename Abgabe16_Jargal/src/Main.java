import javax.sound.midi.Soundbank;

public class Main {
    public static void main(String[] args) {
        aufgabe1();
        aufgabe2();
        aufgabe3();
    }

    private static void aufgabe3() {

                // Test Date class
                Date date1 =  new Date(15, 3, 2020);
                Date date2 = createDate(29, 2, 2020); // Leap year
                System.out.println("Date 1: " + date1);
                System.out.println("Date 2: " + date2);

                // Create vineyard
                Vineyard vineyard = new Vineyard("My Vineyard", 10, 2.5);

                // Add vines with proper date handling
                Date date3 = createDate(15, 3, 2020);
                Date date4 = createDate(20, 4, 2019);
                Date date5 = createDate(10, 5, 2021);

                if (date3 != null) {
                    vineyard.addAtEnd(new Vine("Riesling", date3, 3, false, 2.5));
                }
                if (date4 != null) {
                    vineyard.addAtEnd(new Vine("Chardonnay", date4, 4, true, 1.8));
                }
                if (date5 != null) {
                    vineyard.addAtBeginning(new Vine("Pinot Noir", date5, 5, false, 3.2));
                }

                // Output
                vineyard.print();
                System.out.println("\nDiseased vines: " + vineyard.countDiseased());
                System.out.println("Yield per hectare: " + vineyard.calculateYield());
                System.out.println("Free space: " + vineyard.freeSpacePercentage() + "%");

                // Grouped output
                vineyard.printGroupedByVariety();

                // Sort
                vineyard.sort();
                System.out.println("\nAfter sorting:");
                vineyard.print();
            }

            // Helper method to create dates with exception handling
            private static Date createDate(int day, int month, int year) {
                try {
                    return new Date(day, month, year);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error creating date: " + e.getMessage());
                    return null;
                }
            }







    private static void aufgabe2() {
        System.out.println("=== Test Laden mit Namen ===");

//        Laden erstellen
        Laden supermarket = new Laden("Supermarkt Müller");

//        Ablaufdaten erstellen
        Ablaufdatum ad1 = new Ablaufdatum(15, 3, 2025);
        Ablaufdatum ad2 = new Ablaufdatum(28, 2, 2025);
        Ablaufdatum ad3 = new Ablaufdatum(10, 4, 2025);

//        Produkte erstellen
        Produkt milch = new Produkt("Milch", "Milchbauer GmbH", 1.29, 10, ad1);
        Produkt brot = new Produkt("Brot", "Bäckerei Schmidt", 2.49, 5, ad2);
        Produkt kaese = new Produkt("Käse", "Käserei Weber", 3.99, 3, ad3);

//        Laden öffnen
        supermarket.oeffnen();

//        Lieferungen
        System.out.println("\n--- Lieferungen ---");
        supermarket.lieferung(milch);
        supermarket.lieferung(brot);
        supermarket.lieferung(kaese);

//        Sortiment anzeigen
        supermarket.printProdukte();

//        Verkauf testen
        System.out.println("\n--- Verkauf ---");
        double preis1 = supermarket.verkaufen("Milch");
        System.out.println("Verkaufspreis: " + preis1 + "€");

        double preis2 = supermarket.verkaufen("Brot", 2);
        System.out.println("Verkaufspreis 2xBrot: " + preis2 + "€");

//        Sortieren
        System.out.println("\n--- Sortieren ---");
        supermarket.sort();
        supermarket.printProdukte();

//        Abgelaufene Produkte
        System.out.println("\n--- Abgelaufene Produkte ---");
        int abgelaufen = supermarket.abgeLaufen(2025, 3);
        System.out.println("Abgelaufene Produkte: " + abgelaufen);

//        Produkt entfernen
        System.out.println("\n--- Produkt entfernen");
        supermarket.weg(kaese);

//        laden schließen
        supermarket.schliessen();

//        Versuch zu verkaufen wenn geschlossen
        System.out.println("\n--- Verkauf bei geschlossenem Laden ---");
        double preis3 = supermarket.verkaufen("Milch");
        System.out.println("Verkaufspreis: " + preis3 + "€");

    }

    private static void aufgabe1() {
        System.out.println("=== Test PersonenVerwaltung ===");

//         1. Konstruktor testen
        PersonenVerwaltung verwaltung = new PersonenVerwaltung(3);
        System.out.println("Array-Größe: " + verwaltung.getArraySize());
        System.out.println("Last-Index: " + verwaltung.getLast());

//        2. Personen einfügen
        System.out.println("\n--- Personen einfügen ---");
        verwaltung.einfuegenEnde(new Person("Alice", 25));
        verwaltung.einfuegenEnde(new Person("Bob", 18));
        verwaltung.einfuegenAnfang(new Person("Charlie", 45));
        verwaltung.einfuegenPosition(new Person("David", 39), 2);

//        3. Ausgabe testen
        System.out.println("\n--- Aktuelle Personen ---");
        verwaltung.printPersonen();

//        4. Suchen testen
        System.out.println("\n--- Suchen testen ---");
        int index = verwaltung.suchen("Bob");
        System.out.println("Bob gefunden an Position: " + (index + 1));

//        5. Anzahl testen
        verwaltung.einfuegenEnde(new Person("Alice", 23));
        System.out.println("Anzahl Personen mit Namen 'Alice': " + verwaltung.anzahl("Alice"));

//        6. Löschen testen
        System.out.println("\n--- Löschen testen ---");
        verwaltung.loeschenPosition(0);
        verwaltung.loeschenPersonen(new Person("Bob", 18));

//        7. Finale Ausgabe
        System.out.println("\n--- Finale Personenliste ---");
        verwaltung.printPersonen();

//        8. Array-Erweiterung testen
        System.out.println("\n--- Array-Erweiterung testen");
        verwaltung.einfuegenEnde(new Person("Eva", 45));
        verwaltung.einfuegenEnde(new Person("Frank", 85));
        verwaltung.einfuegenEnde(new Person("Grace", 99));
        System.out.println("Neue Array-Größe: " + verwaltung.getArraySize());

    }
}