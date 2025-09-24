import java.util.Scanner;
import java.util.Random;
public class SchiffeVersenken {
    private Spieler[] spielers;
    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();
    private char[][] spielfeldSpieler1;
    private char[][] spielfeldSpieler2;
    private char[][] sichtfeldSpieler1;
    private char[][] sichtfeldSpieler2;

    private boolean spieler1AmZug = true;
    private boolean spielLaeuft = true;

    // Standard Schiffsgrößen und Namen
    private final int[] standardSchiffsGroessen = {5, 4, 4, 3, 2};
    private final String[] standardSchiffsNamen = {"Flugzeugträger", "Schlachtschiff", "Kreuzer", "Zerstörer", "U-Boot"};

    // Benutzerdefinierte Schiffe
    private int[] benutzerSchiffsGroessen;
    private String[] benutzerSchiffsNamen;

    // Buchstaben für die Spalten
//    private final char[] buchstaben = new char[10];
//    public void buchstaben(){
//        for (int i = 0; i < buchstaben.length; i++){
//            buchstaben[i] = (char)('A' + i);
//        }
//    }
    private final char[] buchstaben = {'A','B','C','D','E','F','G','H','I','J'};

    public SchiffeVersenken(Spieler[] spielers){
        this.spielers = spielers;
        initializeSpielfelder();
    }

    private void initializeSpielfelder() {
        spielfeldSpieler1 = new char[10][10];
        spielfeldSpieler2 = new char[10][10];
        sichtfeldSpieler1 = new char[10][10];
        sichtfeldSpieler2 = new char[10][10];

        // Spielfelder initialisieren
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                spielfeldSpieler2[i][j] = '~'; // Wasser
                sichtfeldSpieler1[i][j] = '~';
                spielfeldSpieler1[i][j] = '~';
                sichtfeldSpieler2[i][j] = '~';
            }
        }
    }

    public void spiele() {
        System.out.println("Schiffe Versenken - Spiel startet!");
        System.out.println(spielers[0].getName() + " vs " + spielers[1].getName());

        // Schiffsauswahl und plazieren
        schiffeKonfigurieren();

        System.out.println("Schiffe wurden plaziert. Das Spiel beginnt!");

        while (spielLaeuft) {
            char[][] aktuellesSichtfeld = spieler1AmZug? sichtfeldSpieler1 : sichtfeldSpieler2;

            char[][] gegnerSpielfeld = spieler1AmZug? spielfeldSpieler2 : spielfeldSpieler2;

            String aktuellerSpieler = spieler1AmZug? spielers[0].getName() : spielers[1].getName();

            System.out.println("\n" + aktuellerSpieler + " ist am Zug:");
            printSpielfeld(aktuellesSichtfeld, true);

            int[] koordinaten = getEingabe();
            if (koordinaten == null) continue;

            int reihe = koordinaten[0];
            int spalte = koordinaten[1];

            // Schuss ausführen
            char resultat = schussAusfueren(gegnerSpielfeld, aktuellesSichtfeld, reihe, spalte);

            if (resultat == 'X'){
                System.out.println("Treffer!");
                if (istSchiffVersenkt(gegnerSpielfeld, reihe, spalte)) {
                    System.out.println("Schiff versenkt!");
                }
            } else if (resultat == 'O') {
                System.out.println("Daneben!");
                spieler1AmZug = !spieler1AmZug; // Zugwechsel nur bei Fehlschuss
            }

            // Prüfen ob Spiel vorbei
            if (istSpielVorbei(gegnerSpielfeld)) {
                spielLaeuft = false;
                System.out.println("\n" + aktuellerSpieler + " hat gewonnen!");
                printSpielfeld(aktuellesSichtfeld, true);

                // Statistik aktualisieren
                if (spieler1AmZug) {
                    spielers[0].schiffeVersenkenGewonnen();
                    spielers[1].schiffeVersenkenVerloren();
                } else {
                    spielers[1].schiffeVersenkenGewonnen();
                    spielers[0].schiffeVersenkenVerloren();
                }
            }
        }

    }

    private void schiffeKonfigurieren() {
        System.out.println("\n=== Schiffe Konfigurieren ===");
        System.out.println("1. Standard-Schiffe verwenden");
        System.out.println("2. Eigene Schiffe erstellen");
        System.out.print("Wähle eine Option: ");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 2){
            benutzerSchiffeErstellen();
        } else {
            benutzerSchiffsGroessen = standardSchiffsGroessen;
            benutzerSchiffsNamen = standardSchiffsNamen;
        }

        // Platzierung für beide Spieler
        for (int i = 0; i < 2; i++) {
            System.out.println("\n" + spielers[i].getName() + ", wähle deine Schiffsplatzierung:");
            System.out.println("1. Automatisch platzieren");
            System.out.println("2. Manuell platzieren");
            System.out.print("Wähle eine Option: ");

            int platzierungChoice = sc.nextInt();
            sc.nextLine();

            char[][] spielfeld = (i == 0)? spielfeldSpieler1 : spielfeldSpieler2;

            if (platzierungChoice == 2) {
                schiffeManuellPlatzieren(spielfeld, spielers[i].getName());
            } else {
                schiffeAutomatischPlatzieren(spielfeld);
            }

            // Für Debugging: Zeige das platzierte Spielfeld
            System.out.println("\nDeine Schiffsplatzierung:");
            printKomplettesSpielfeld(spielfeld);
            System.out.println("Drücke Enter um fortzufahren...");
            sc.nextLine();
        }
    }

    private void benutzerSchiffeErstellen() {
        System.out.print("Wie viele Schiffe möchtest du erstellen? (1-10): ");
        int anzahl = sc.nextInt();
        sc.nextLine();

        if (anzahl < 1 || anzahl > 10) {
            System.out.println("Ungültige Anzahl! Verwende Standard-Schiffe.");
            benutzerSchiffsGroessen = standardSchiffsGroessen;
            benutzerSchiffsNamen = standardSchiffsNamen;
            return;
        }

        benutzerSchiffsGroessen = new int[anzahl];
        benutzerSchiffsNamen = new String[anzahl];

        for (int i = 0; i < anzahl; i++) {
            System.out.println("\nSchiff " + (i+1) + ":");
            System.out.print("Name des Schiffs: ");
            benutzerSchiffsNamen[i] = sc.nextLine();

            System.out.print("Größe des Schiffs (2-5):");
            int groesse = sc.nextInt();
            sc.nextLine();

            if (groesse < 2 || groesse > 5) {
                System.out.println("Ungültige Größe! Verwende 3.");
                groesse = 3;
            }

            benutzerSchiffsGroessen[i] = groesse;
        }

        System.out.println("\nDeine Schiffsflotte:");
        for (int i = 0; i < anzahl; i++){
            System.out.println((i+1) + ". " + benutzerSchiffsNamen[i] + " (Größe: " + benutzerSchiffsGroessen[i] + ")");
        }
    }

    private void schiffeManuellPlatzieren(char[][] spielfeld, String spielerName) {
        System.out.println("\n" + spielerName + ", plazierre diene Schiffe:");

        for (int i = 0; i < benutzerSchiffsGroessen.length; i++){
            boolean platziert = false;

            while (!platziert) {
                System.out.println("\nPlatziere: " + benutzerSchiffsNamen[i] + "(Größe: " + benutzerSchiffsGroessen[i] + ")");
                printKomplettesSpielfeld(spielfeld);

                System.out.println("Standotposition (z.B. A1): ");
                String position = sc.nextLine().toUpperCase().trim();

                System.out.print("Ausrichtung (H für horizontal, V für vertikal): ");
                String ausrichtung = sc.nextLine().toUpperCase().trim();

                boolean horizontal = ausrichtung.equals("H");

                int[] koordinaten = parseKoordinaten(position);
                if (koordinaten ==null) {
                    continue;
                }

                int reihe = koordinaten[0];
                int spalte = koordinaten[1];

                if (kannSchiffPlatzieren(spielfeld, reihe, spalte, benutzerSchiffsGroessen[i], horizontal)) {
                    platziereSchiff(spielfeld, reihe, spalte, benutzerSchiffsGroessen[i], horizontal);
                    platziert = true;
                    System.out.println("Schiff platziert!");
                } else {
                    System.out.println("Kann Schiff nier nicht platzieren! Versuche es erneut.");
                }
            }
        }
    }

    private void schiffeAutomatischPlatzieren(char[][] spielfeld) {
        for (int i = 0; i < benutzerSchiffsGroessen.length; i++){
            boolean platziert = false;
            while (!platziert){
                boolean horizontal = random.nextBoolean();
                int reihe = random.nextInt(10);
                int spalte = random.nextInt(10);

                if (kannSchiffPlatzieren(spielfeld, reihe, spalte, benutzerSchiffsGroessen[i], horizontal)) {
                    platziereSchiff(spielfeld, reihe, spalte, benutzerSchiffsGroessen[i], horizontal);
                    platziert = true;
                }
            }
        }
    }

    private int[] parseKoordinaten(String input) {
        if (input.length() < 2 || input.length() > 3) {
            System.out.println("Ungültiges Format! Verwende z.B. A1");
            return null;
        }

        char buchstabe = input.charAt(0);
        String zahlStr = input.substring(1);

        int spalte = -1;
        for (int i = 0; i < buchstaben.length; i++) {
            if (buchstaben[i] == buchstabe) {
                spalte = i;
                break;
            }
        }

        if (spalte == -1) {
            System.out.println("Ungültiger Buchstabe! Erlaubt: A-J");
            return null;
        }

        try {
            int zahl = Integer.parseInt(zahlStr);
            if (zahl < 1 || zahl > 10) {
                System.out.println("Zahl muss zwischen 1 und 10 sein!");
                return null;
            }
            return new int[]{zahl - 1, spalte}; // Reihe, Spalte
        } catch (NumberFormatException e) {
            System.out.println("Ungültige Zahl!");
            return null;
        }
    }

    private int[] getEingabe()  {
        while (true) {
            System.out.print("Gib Koordinate ein (z.B A5): ");
            String eingabe = sc.nextLine().toUpperCase().trim();

            if (eingabe.length() < 2 || eingabe.length() > 3) {
                System.out.println("Ungültige Eingabe! Format: BuchstabeZahl (z.B. A5");
                continue;
            }

            char buchstabe = eingabe.charAt(0);
            String zahlStr = eingabe.substring(1);

            // Buchstabe validieren
            int spalte = -1;
            for (int i = 0; i < buchstaben.length; i++){
                if (buchstaben[i] == buchstabe) {
                    spalte = i;
                    break;
                }
            }

            if (spalte == -1) {
                System.out.println("Ungültiger Buchstabe! Erlaubt: A-J");
                continue;
            }

            // Zahl validieren
            try {
                int zahl = Integer.parseInt(zahlStr);
                if (zahl < 1 || zahl > 10) {
                    System.out.println("Zahl muss zwischen 1 und 10 sein!");
                    continue;
                }
                int reihe = zahl - 1; // Convert to 0-based index

                // Prüfen ob Feld schon beschossen
                char[][] aktuellesSichtfeld = spieler1AmZug? sichtfeldSpieler1 : sichtfeldSpieler2;
                if (aktuellesSichtfeld[reihe][spalte] == 'X' ||
                aktuellesSichtfeld[reihe][spalte] == 'O') {
                    System.out.println("Dieses Feld wurde bereits beschossen!");
                    continue;
                }
                return new int[]{reihe, spalte};
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Zahl! Format: BuchstabeZahl (z.B. A5)");
            }
        }
    }

    private char schussAusfueren(char[][] gegnerSpielfeld, char[][] sichtfeld, int reihe, int spalte) {
        if (gegnerSpielfeld[reihe][spalte] == 'S') {// Schiff getroffen
            sichtfeld[reihe][spalte] = 'X';
            gegnerSpielfeld[reihe][spalte] = 'X';
            return 'X';
        } else {
            sichtfeld[reihe][spalte] = 'O';
            gegnerSpielfeld[reihe][spalte] = 'O';
            return 'O';
        }
    }

    private boolean istSchiffVersenkt(char[][] spielfeld, int reihe, int spalte){
        // Prüfen in alle Richtungen ob Schiff komplett versenkt
        return !(hatWeitereTeile(spielfeld, reihe, spalte, 1, 0) ||
                hatWeitereTeile(spielfeld, reihe, spalte, -1, 0) ||
                hatWeitereTeile(spielfeld, reihe, spalte, 0, 1) ||
                hatWeitereTeile(spielfeld, reihe, spalte, 0, -1));
    }

    private boolean hatWeitereTeile(char[][] spielfeld, int reihe, int spalte, int deltaReihe, int deltaSpalte) {
        int neueReihe = reihe + deltaReihe;
        int neueSpalte = spalte + deltaSpalte;

        if (neueReihe < 0 || neueReihe >= 10 || neueSpalte < 0 || neueSpalte >= 10 ) {
            return false;
        }
        return spielfeld[neueReihe][neueSpalte] == 'S'; // Ungetroffenes Schiffsteil
    }


    private boolean istSpielVorbei(char[][] spielfeld) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (spielfeld[i][j] == 'S') {
                    return false;
                }
            }
        }
        return  true;
    }

    private boolean kannSchiffPlatzieren(char[][] spielfeld, int reihe, int spalte, int groesse, boolean horizontal) {
        if (horizontal) {
            if (spalte + groesse > 10) return false;
            for (int j = spalte; j < spalte + groesse; j++) {
                if (spielfeld[reihe][j] != '~' || hatNachbarSchiff(spielfeld, reihe, j)) {
                    return false;
                }
            }
        } else {
            if (reihe + groesse > 10) return false;
            for (int i = reihe; i < reihe + groesse; i++) {
                if (spielfeld[i][spalte] != '~' || hatNachbarSchiff(spielfeld, i, spalte)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hatNachbarSchiff(char[][] spielfeld, int reihe, int spalte) {
        for (int i = reihe - 1; i <= reihe + 1; i++){
            for (int j = spalte - 1; j <= spalte + 1; j++) {
                if (i >= 0 && i < 10 && j >= 0 && j < 10 && spielfeld[i][j] == 'S') {
                    return true;
                }
            }
        }
        return false;
    }

    private void platziereSchiff(char[][] spielfeld, int reihe, int spalte, int groesse, boolean horizontal) {
        if (horizontal) {
            for (int j = spalte; j < spalte + groesse; j++) {
                spielfeld[reihe][j] = 'S';
            }
        } else {
            for (int i = reihe; i < reihe + groesse; i++) {
                spielfeld[i][spalte] = 'S';
            }
        }
    }

    private void printSpielfeld(char[][] spielfeld, boolean istSichtfeld) {
        System.out.print("   ");
        for (char c : buchstaben) {
            System.out.print(c + " ");
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.printf("%2d", i + 1);
            for (int j = 0; j < 10; j++) {
                char anzeige = spielfeld[i][j];
                if (istSichtfeld) {
                    if (anzeige == 'X' || anzeige == 'O') {
                        System.out.print(anzeige + " ");
                    }else {
                        System.out.print("~ ");
                    }
                } else {
                    System.out.print(anzeige + " ");
                }
            }
            System.out.println();
        }
    }

    private void printKomplettesSpielfeld(char[][] spielfeld) {
        System.out.print("  ");
        for (char c : buchstaben) {
            System.out.print(c + " ");
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.printf("%2d",i+1);
            for (int j = 0; j<10; j++){
                System.out.print(spielfeld[i][j] + " ");
            }
            System.out.println();
        }
    }




}
