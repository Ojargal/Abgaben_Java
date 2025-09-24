
import java.util.Scanner;
public class TicTacToe{
    private Spieler[] spielers;
    Scanner sc = new Scanner(System.in);
    private String[][] spielPlatz = new String[3][3];
    private boolean spieler1AmZug = true;
    private boolean spielLaeuft = true;

    public TicTacToe(Spieler[] spielers){
        this.spielers = spielers;
        spielPlaetzNummerieren();
    }


    public void spielPlaetzNummerieren() {
        int platzNumber = 1;
        for (int i = 0; i < spielPlatz.length; i++) {
            for (int j = 0; j < spielPlatz[i].length; j++) {
                spielPlatz[i][j] = String.valueOf(platzNumber);
                platzNumber++;
            }
        }
    }


    public boolean elementTausch(String auswahl) {
        String symbol = spieler1AmZug ? "X" : "O";
        for (int i = 0; i < spielPlatz.length; i++) {
            for (int j = 0; j < spielPlatz[i].length; j++) {
                if (spielPlatz[i][j].equals(auswahl)) {
                    spielPlatz[i][j] = symbol;
                   return true;
                }
            }
        }
        return false;
    }


    public void printSpielfeld() {
        System.out.println("\nAktuelles Spielfeld:");
        for (int i = 0; i < spielPlatz.length; i++) {
            for (int j = 0; j < spielPlatz[i].length; j++) {
                System.out.print(spielPlatz[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public String pruefeGewinn() {
        // Horizontale Prüfung
        for (int i = 0; i < 3; i++){
            if(spielPlatz[i][0].equals(spielPlatz[i][1]) &&
            spielPlatz[i][1].equals(spielPlatz[i][2])){
                return spielPlatz [i][0];
            }
        }
        // Vertikal Prüfung
        for (int j = 0; j < 3; j++) {
            if(spielPlatz[0][j].equals(spielPlatz[1][j]) &&
                    spielPlatz[1][j].equals(spielPlatz[2][j])){
                return spielPlatz [0][j];
            }
        }
        // Diagonale Prüfung (links oben nach rechts unten)
        if (spielPlatz[0][0].equals(spielPlatz[1][1]) &&
        spielPlatz[1][1].equals(spielPlatz[2][2])){
            return spielPlatz[0][0];
        }
        // Diagonale Prüfung (rechts oben nach links unten)
        if (spielPlatz[0][2].equals(spielPlatz[1][1]) &&
                spielPlatz[1][1].equals(spielPlatz[2][0])){
            return spielPlatz[0][2];
        }
        // Unentschieden prüfen
        boolean unetschieden = true;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (!spielPlatz[i][j].equals("X") && !spielPlatz[i][j].equals("O")){
                    unetschieden = false;
                }
            }
        }

        return unetschieden? "Unentschieden" : null;
    }

    public int spiele(){
        System.out.println("Tic Tac Toe - Spiel startet!");
        System.out.println(spielers[0].getName() + "(X) vs " + spielers[1].getName() + " (O)");

        while (spielLaeuft){
            printSpielfeld();

            String aktuellerSpieler = spieler1AmZug ? spielers[0].getName() : spielers[1].getName();

            System.out.print(aktuellerSpieler + ", wähle eine Zahl (1-9): ");

            String eingabe = sc.nextLine();

            if (eingabe.matches("[1-9]")){
                if (elementTausch(eingabe)){
                    String ergebnis = pruefeGewinn();

                    if(ergebnis != null){
                        printSpielfeld();
                        if (ergebnis.equals("Unentschieden")){
                            System.out.println("Unentschieden");
                            return 0;
                        } else {
                            String gewinnerName = ergebnis.equals("X") ? spielers[0].getName() : spielers[1].getName();
                            System.out.println(gewinnerName + " hat gewonnen!");
                            return ergebnis.equals("X") ? 1 : 2; // 1 = Spieler1, 2 = Spieler2
                        }

                    } else {
                        spieler1AmZug = !spieler1AmZug;
                    }
                }else {
                    System.out.println("Dieses Feld ist bereits belegt!");
                }
            }else {
                System.out.println("Ungültige Eingabe! Bitte eine Zahl von 1-9 eingeben.");
            }
        }
        return -1; // Sollte nicht erreicht werden
    }

    private String werHatGewonnen(String a) {
        return a.equals("X")? spielers[0].getName() : spielers[1].getName();
    }

    public void spielrAuswahl(int sp) {
        if (sp == 1){
            Spieler spieler1;
        } else if (sp == 2) {
            Spieler spieler2;
        } else {
            System.out.println("Fehler: Ungültige Nummer!");
        }
    }
}