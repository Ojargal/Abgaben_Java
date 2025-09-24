import java.util.Scanner;
import java.util.Random;
public class VierGewinnt {
    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();
    private Spieler[] spielers;

    private char[][] spielFeld;
    private boolean spieler1AmZug = true;
    private boolean spielLauft = true;

    public VierGewinnt(Spieler[] spielers) {
        this.spielers = spielers;
        initializeSpielfelder();
    }

    private void initializeSpielfelder() {
        this.spielFeld = new char[6][7];
        for (int i = 0; i < spielFeld.length; i++){
            for (int j = 0; j < spielFeld[i].length; j++){
                spielFeld[i][j] = '-';
            }
        }
    }



    public int spiele() {
        System.out.println("4 Gewinnt - Spiel startet!");
        System.out.println(spielers[0].getName() + " (X) vs " + spielers[1].getName() + " (O)");
        while (spielLauft) {
            printSpielfeld();

            String aktuellerSpielr = spieler1AmZug ? spielers[0].getName() : spielers[1].getName();
            System.out.print(aktuellerSpielr + ", wähle eine Spalte (1-7): ");
            int spalte;
            try {
                spalte = sc.nextInt() - 1;
                sc.nextLine();// Buffer leeren
            } catch (Exception e) {
                System.out.println("Ungültige Eingabe! bitte eine Zhal von 1-7 eingeben.");
                sc.nextLine();// Buffer leeren
                continue;
            }

            if (spalte < 0 || spalte > 6) {
                System.out.println("Ungültige Spalte! Bitte eine Zahl von 1-7 eingeben.");
                continue;
            }
            if (!steinEinwerfen(spalte)) {
                System.out.println("Diese Spalte ist bereits voll! Wähle eine andere.");
                continue;
            }

            // Gewinnprüfung
            char symbol = spieler1AmZug ? 'X' : 'O';
            if (pruefeGewinn(symbol)) {
                printSpielfeld();
                System.out.println(aktuellerSpielr + " hat gewonnen!");

                spielLauft = false;
                return spieler1AmZug ? 1 : 2;
            }
                //Unentschieden prüfen
                if (istSpielfeldVoll()) {
                    printSpielfeld();
                    System.out.println("Unentscheiden! Das Spielfeld ist voll.");
                    spielLauft = false;
                    return 0; // Unentschieden
                }
                // Zugwechsel
                spieler1AmZug = !spieler1AmZug;
            }
        return -1; // Sollte nicht erreicht werden
    }
    private boolean steinEinwerfen(int spalte) {
        char symbol = spieler1AmZug? 'X' : 'O';

        // Von unten nach oben suchen (Zeile 5 bis 0)
        for (int i = spielFeld.length-1; i >= 0; i--) {
            if (spielFeld[i][spalte] == '-'){
                spielFeld[i][spalte] = symbol;
                return true;
            }
        }
        return false; // Spalte ist voll
    }



    private boolean pruefeGewinn(char symbol) {
        // Horizontale Prüfung
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++){
                if (spielFeld[i][j] == symbol &&
                        spielFeld[i][j+1] == symbol &&
                        spielFeld[i][j+2] == symbol &&
                        spielFeld[i][j+3] == symbol) {
                    return true;
                }
            }
        }

        // Vertikale Prüfung
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<7; j++){
                if (spielFeld[i][j] == symbol &&
                        spielFeld[i+1][j] == symbol &&
                        spielFeld[i+2][j] == symbol &&
                        spielFeld[i+3][j] == symbol) {
                    return true;
                }
            }
        }

        // Diagonale Prüfung(↘)
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<4; j++){
                if (spielFeld[i][j] == symbol &&
                        spielFeld[i+1][j+1] == symbol &&
                        spielFeld[i+2][j+2] == symbol &&
                        spielFeld[i+3][j+3] == symbol) {
                    return true;
                }
            }
        }

        // Diagonale Prüfung
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<7; j++){
                if (spielFeld[i][j] == symbol &&
                        spielFeld[i+1][j-1] == symbol &&
                        spielFeld[i+2][j-2] == symbol &&
                        spielFeld[i+3][j-3] == symbol) {
                    return true;
                }
            }
        }
        return false;
    }



    private boolean istSpielfeldVoll() {
        for (int j = 0; j < 7; j++){
            if (spielFeld[0][j] == '-') {
                return false; // Es gibt, noch freie Felder
            }
        }
        return true; // Alle obersten Felder sind belegt
    }

    public void printSpielfeld() {
        System.out.println("\nAktuelles Spielfeld:");

        // Spaltennummern anzeigen
        System.out.print("  ");
        for (int i = 1; i <= 7; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Spielfeld anzeigen
        for (int i = 0; i < spielFeld.length; i++) {
            System.out.print("|");
            for (int j = 0; j < spielFeld[i].length; j++) {
                System.out.print(spielFeld[i][j] + "|");
            }
            System.out.println();
        }

        // Unterer Rand
        System.out.println("---------------");
    }

}
