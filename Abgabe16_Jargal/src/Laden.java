import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Laden {
//    Eigenschaften
    private String name;
    private boolean offen;
    private int last;
    private Produkt[] produkte;

//    Konstruktor
    public Laden(String name){
        setName(name);
        offen = false; // Laden startet geschlossen
        this.last = -1; // Array ist zunächst leer
        this.produkte = new Produkt[10]; // Standardgröße 10
    }

//    Getter/Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOffen() {
        return offen;
    }

    public void setOffen(boolean offen) {
        this.offen = offen;
    }


    public int getLast() {
        return last;
    }

    public Produkt[] getProdukte() {
        return produkte;
    }


//    Laden öffnen
    public void oeffnen(){
        offen = true;
        System.out.println(name + " ist jetzt geöffnet.");
    }

//    Laden schließen
    public void schliessen(){
        offen = false;
        System.out.println(name + " ist jetzt geschlossen.");
    }

//   Verkauft 1 Stück einens Produkts
    public double verkaufen(String name){
        if (!offen){
            System.out.println("Laden ist geschlossen!");
            return 0.0;
        }
        for (int i = 0; i <= last; i++){
            if (produkte[i].getName().equals(name)){
                if (produkte[i].getAnzahl() > 0){
                    produkte[i].verkaufen(1);
                    double preis = produkte[i].getPreis();

                    if (produkte[i].getAnzahl() == 0){
                        entfernen(i);
                    }
                    return preis;
                }
            }
        }
        System.out.printf("Produkt '%s' nicht gefunden oder nicht vorrätig", name);
        return 0.0;
    }

//    Verkauft mehrere Stück eines Produkts
    public double verkaufen(String name, int anzahl){
        if (!offen){
            System.out.println("Laden ist geschlossen!");
            return 0.0;
        }
        for (int i = 0; i <= last; i++){
            if (produkte[i].getName().equals(name)){
                if (produkte[i].getAnzahl() >= anzahl){
                    produkte[i].verkaufen(anzahl);
                    double gesamtPreis = produkte[i].getPreis() * anzahl;

                    if (produkte[i].getAnzahl() == 0){
                        entfernen(i);
                    }
                    return gesamtPreis;
                } else {
                    System.out.printf("Nicht genug '%s' vorrätig.", name);
                    return 0.0;
                }
            }
        }
        System.out.printf("Produkt '%s' nicht gefunden.", name);
        return 0.0;
    }

//    Lieferung - fügt Produkt hinzu oder erhöht Anzahl
    public void lieferung(Produkt p){
        // Prüfe ob identisches Produkt bereits existiert
        for (int i = 0; i <= last; i++){
            if (produkte[i].komplettGleich(p)){
                produkte[i].setAnzahl(produkte[i].getAnzahl() + p.getAnzahl());
                System.out.printf("Anzahl von '%s' erhöht.", p.getName());
                return;
            }
        }

        // Neues Produkt Hinzufügen
        if (last == produkte.length - 1){
            erweitereProdukte();
        }
        produkte[++last] = p;
        System.out.printf("Neues Produkt '%s' hinzugefügt.", p.getName());
    }


    //    Entfernt Produkt P
    public boolean weg(Produkt p){
        for (int i = 0; i <= last; i++){
            if (produkte[i].komplettGleich(p)){
                entfernen(i);
                System.out.printf("Produkt '%s' entfernt.%n", p.getName());
                return true;
            }
        }
        System.out.printf("Produkt '%s' nicht gefunden.", p.getName());
        return false;
    }

//    Sortiert nach Ablaufdatum
    public void sort(){
        if (last == -1){
            System.out.println("Keine Produkte zum Sortierten.");
            return;
        }

        Arrays.sort(produkte, 0, last + 1, new Comparator<Produkt>() {
            @Override
            public int compare(Produkt p1, Produkt p2) {
                Ablaufdatum ad1 = p1.getHaltbar();
                Ablaufdatum ad2 = p2.getHaltbar();

                if (ad1.aelter(ad2)) return -1;
                if (ad1.aelter(ad2)) return 1;
                return 0;
            }
        });
        System.out.println("Produkte nach Haltbarkeit sortiert.");
    }

//    Zählt abgelaufene Produkte
    public int abgeLaufen(int jahr, int monat){
        int count = 0;
        for (int i = 0; i <= last; i++){
            if (produkte[i].abgeLaufen(jahr, monat)){
                count++;
            }
        }
        return count;
    }

//    Sucht Produkt nach Namen
    public Produkt sucheProdukt(String name){
        for (int i = 0; i <= last; i++){
            if (produkte[i].getName().equals(name)){
                return produkte[i];
            }
        }
        return null;
    }

//    Gibt Gesamtbestand aus
    public int gesamtBestand(){
        int gesamt = 0;
        for (int i = 0; i <= last; i++){
            gesamt += produkte[i].getAnzahl();
        }
        return gesamt;
    }

//    Hilfes Methoden
    private void entfernen(int index){
        for (int i = index; i <= last; i++){
            produkte[i] = produkte[i + 1];
        }
        produkte[last] = null;
        last--;
    }
    private void erweitereProdukte(){
        Produkt[] neueProdukte = new Produkt[produkte.length * 2];
        System.arraycopy(produkte, 0, neueProdukte, 0, produkte.length);
        produkte = neueProdukte;
        System.out.printf("Produkt-Array erweitert auf %d Plätze.", produkte.length);
    }

//    Gibt Sortiment aus
    public void printProdukte(){
        if (last == -1){
            System.out.println("Soriment ist leer");
            return;
        }
        System.out.println("\n=== Sortiment von " + name + " ===");
        System.out.println("Status: " + (offen ? "Geöffnet" : "Geschlossen"));
        System.out.println("Gesamtbestand: " + gesamtBestand() + " Stück");
        System.out.println("------------------------------");

        for (int i = 0; i <= last; i++){
            System.out.printf("%d. %s%n", (i + 1), produkte[i]);
        }
    }
//    Gibt Produkt-Details aus
    public void printProduktDetails(String name){
        Produkt produkt = sucheProdukt(name);
        if(produkt != null){
            System.out.printf("Details: %s%n", produkt);
            System.out.printf("Abgelaufen: %s%n", produkt.abgeLaufen(2025, 3) ? "Ja" : "Nein");
        } else {
            System.out.printf("Produkt '%s' nicht gefunden.%n", name);
        }
    }




}
