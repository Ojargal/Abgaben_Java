import exponate.*;
import museum.Museum;

public class Main {
    public static void main(String[] args) {
        // Exponate erstellen
        Gemaelde monaLisa = new Gemaelde("Mona Lisa", 500, 860000000, "Braun");
        Skulptur david = new Skulptur("David", 520, 100000000, "Marmor");
        Fossilien tRex = new Fossilien("T-Rex", 68000000, 5000000, "Calcium");

        // Museum erstellen und Exponate hinzufügen
        Museum louvre = new Museum();
        louvre.setGemaelde(monaLisa);
        louvre.setSkulptur(david);
        louvre.setFossil(tRex);

        // Testen
        monaLisa.print();
        david.print();
        tRex.print();

        System.out.println("Wert von Mona Lisa: " + louvre.getWertForExpo("Mona Lisa"));
        System.out.println("Wert von David: " + louvre.getWertForExpo("David"));
        System.out.println("Wert von T-Rex: " + louvre.getWertForExpo("T-Rex"));
    }
}