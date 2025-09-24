public class Aufgabe_4 {
    public static void main(String[] args) {
        spieleMitStrings();
    }

    public static void spieleMitStrings() {
        String beispiel = "  Hallo Welt!  ";
        String leerzeichen = "   ";
        String leer = "";
        String satz = "Java macht Spaß";

        System.out.println("----- Grundlegende String-Methoden -----");
        System.out.println("Original: '" + beispiel + "'");
        System.out.println("Länge: " + beispiel.length());
        System.out.println("Trim: '" + beispiel.trim() + "'");
        System.out.println("Großbuchstaben: '" + beispiel.toUpperCase() + "'");
        System.out.println("Kleinbuchstaben: '" + beispiel.toLowerCase() + "'");

        System.out.println("\n----- Zeichenzugriff -----");
        System.out.println("Char at 4: '" + beispiel.charAt(4) + "'");
        System.out.println("Substring (2-7): '" + beispiel.substring(2, 7) + "'");

        System.out.println("\n----- Vergleiche -----");
        System.out.println("Equals 'Hallo': " + beispiel.equals("Hallo"));
        System.out.println("EqualsIgnoreCase 'hALLO WELT!': " +
                beispiel.equalsIgnoreCase("hALLO WELT!"));
        System.out.println("CompareTo 'A': " + beispiel.compareTo("A"));

        System.out.println("\n----- Prüfungen -----");
        System.out.println("Is empty (leer): " + leer.isEmpty());
        System.out.println("Is blank (leerzeichen): " + leerzeichen.isBlank());
        System.out.println("Contains 'Welt': " + beispiel.contains("Welt"));
        System.out.println("StartsWith '  Ha': " + beispiel.startsWith("  Ha"));

        System.out.println("\n----- Manipulation -----");
        System.out.println("Replace 'l' mit 'X': '" + beispiel.replace('l', 'X') + "'");
        System.out.println("Concat mit '!!': '" + beispiel.concat("!!") + "'");

        System.out.println("\n----- Teilung/Zusammenfügung -----");
        String[] teile = satz.split(" ");
        System.out.println("Split Ergebnis:");
        for (String teil : teile) {
            System.out.println("- " + teil);
        }
        System.out.println("Join mit '-': " + String.join("-", teile));

        System.out.println("\n----- Formatierung -----");
        String format = String.format("Wert: %.2f, Text: %s", 3.1415, "Pi");
        System.out.println("Formatierte Ausgabe: " + format);
    }
}