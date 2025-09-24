import com.sun.source.doctree.EscapeTree;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Spielerverwaltung sv = new Spielerverwaltung();


    public static void main(String[] args) throws IOException {


        FileInAnOut fia = new FileInAnOut();

        if(fia.readFromFile().length != 0) {
            sv.setSpieler(fia.readFromFile());
        }

        boolean playing = true;
        while(playing) {

            System.out.println("========== SPIELESAMMLUNG ==========");
            System.out.println("1 - Spielen");
            System.out.println("2 - Spieler verwalten");
            System.out.println("3 - Programm beenden");
            int auswahl = sc.nextInt();
            if (sv.wievieleSpiler() < 2) {
                auswahl = 2;
                System.out.println("Die Liste enthält nicht genügend Spieler");
            }

            switch (auswahl) {
                case 1:

                    System.out.println("Welches Spiel wollen Sie spielen?");
                    System.out.println("1 - Schiffe versenken");
                    System.out.println("2 - 4 Gewinnt");
                    System.out.println("3 - Tic Tac Toe");
                    boolean nochmalSpielen = true;
                    switch (sc.nextInt()) {

                        case 1:
                            while (nochmalSpielen) {
                                System.out.println("Willkommen bei SchiffeVersenken");
                                // Verfügbare Spieler anzeigen
                                verfuegbareSpielerAnzeigen();

                                System.out.println("Gib den Namen von Spieler 1 ein: ");
                                String name1 = sc.nextLine().toLowerCase().trim();

                                System.out.println("Gib den Namen von Spieler 2 ein: ");
                                String name2 = sc.nextLine().toLowerCase().trim();

                                Spieler spieler1 = sv.getSpieler(name1);
                                Spieler spieler2 = sv.getSpieler(name2);

                                if (spieler1 != null && spieler2 != null) {
                                    Spieler[] schiffVersenkenSpieler = {spieler1, spieler2};
                                    SchiffeVersenken schiffeVersenken = new SchiffeVersenken(schiffVersenkenSpieler);
                                    schiffeVersenken.spiele();
                                    System.out.println("Statistik wurde aktualisiert!");
                                } else {
                                    System.out.println("Mindestens ein Spieler wurde nicht gefunden!");
                                }

                                nochmalSpielen(nochmalSpielen);
                            }
                            break;

                        case 2:
                            while (nochmalSpielen){
                                System.out.println("Welkommen bei 4 Gewinnt!");
                                // Verfügbare Spieler anzeigen
                                verfuegbareSpielerAnzeigen();
                                System.out.println("Gib den Namen von Spieler 1 (X) ein: ");
                                String name1 = sc.nextLine().toLowerCase().trim();

                                System.out.println("Gib den Namen von Spieler 2 (O) ein: ");
                                String name2 = sc.nextLine().toLowerCase().trim();

                                Spieler spieler1 = sv.getSpieler(name1);
                                Spieler spieler2 = sv.getSpieler(name2);

                                if (spieler1 != null && spieler2 != null) {
                                    Spieler[] vierGewinnt = {spieler1, spieler2};
                                    VierGewinnt vierGewinnt1 = new VierGewinnt(vierGewinnt);
                                    vierGewinnt1.spiele();
                                    int ergebnis = vierGewinnt1.spiele();
                                    // Statistik aktualisieren
                                    switch (ergebnis) {
                                        case 0: // Unentschieden
                                            spieler1.vierGewinntUnentschieden();
                                            spieler2.vierGewinntUnentschieden();
                                            break;
                                        case 1: // Spieler 1 gewinnt
                                            spieler1.vierGewinntGewonnen();
                                            spieler2.vierGewinntVerloren();
                                            break;
                                        case 2: // Spieler 2 gewinnt
                                            spieler1.vierGewinntGewonnen();
                                            spieler2.vierGewinntVerloren();
                                            break;
                                    }
                                    System.out.println("Statistik wurde aktualisiert!");
                                } else {
                                    System.out.println("Mindestens ein Spieler wurde nicht gefunden!");
                                }
                                nochmalSpielen(nochmalSpielen);
                            }
                            break;
                        case 3:
                            while (nochmalSpielen){
                            System.out.println("Welkommen bei TicTacToe");
                            // Verfügbare Spieler anzeigen
                                verfuegbareSpielerAnzeigen();


                            System.out.print("Gib den Namen von Spieler 1 (X) ein: ");
                            String name1 = sc.nextLine().trim().toLowerCase();

                            System.out.print("Gib den Namen von Spieler 2 (O) ein: ");
                            String name2 = sc.nextLine().trim().toLowerCase();

                            Spieler spieler1 = sv.getSpieler(name1);
                            Spieler spieler2 = sv.getSpieler(name2);

                            if (spieler1 != null && spieler2 != null) {
                                Spieler[] ticTacToeSpieler = {spieler1, spieler2};
                                TicTacToe ticTacToe = new TicTacToe(ticTacToeSpieler);

                                int ergebnis = ticTacToe.spiele(); // Spiel starten und Ergebnis erhalten

                                // Statistik aktualisieren
                                switch (ergebnis) {
                                    case 0: // Unentschieden
                                        spieler1.ticTacToeUnentschieden();
                                        spieler2.ticTacToeUnentschieden();
                                        break;
                                    case 1: // Spieler 1 gewinnt
                                        spieler1.ticTacToeGewonnen();
                                        spieler2.ticTacToeVerloren();
                                        break;
                                    case 2: // Spieler 2 gewinnt
                                        spieler1.ticTacToeVerloren();
                                        spieler2.ticTacToeGewonnen();
                                        break;
                                }
                                System.out.println("Statistik wurde aktalisiert!");

                            } else {
                                System.out.println("Mindestens ein Spieler wurde nicht gefunden!");
                            }
                            nochmalSpielen(nochmalSpielen);

                        }
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Was wollen Sie tun?");
                    System.out.println("1 - Spieler hinzufügen");
                    System.out.println("2 - Alle Spieler anzeigen");
                    System.out.println("3 - Nach einem Spieler suchen");
                    System.out.println("4 - Spieler entfernen");

                    fall2();
                    break;
                case 3:
                    playing = false;
                    break;
            }
        }
        fia.writeToFile(sv.getSpieler());
    }

    private static void verfuegbareSpielerAnzeigen() {
        System.out.println("Verfügbare Spieler");
        Spieler[] alleSpieler = sv.getSpieler();
        for (Spieler s : alleSpieler) {
            if (s != null) {
                System.out.println("- " + s.getName());
            }
        }
        sc.nextLine(); // Buffer leeren
    }


    private static void nochmalSpielen(boolean nochmalSpielen) {
        System.out.println("\nWählen Sie:");
        System.out.println("Hauptmenu - (1)");
        System.out.println("Nochmals spielen - (2)");
        System.out.println("Programm beenden - (0)");

        int choice = sc.nextInt();
        sc.nextLine(); // Buffer leeren

        switch (choice) {
            case 1: // Hauptmenu
                nochmalSpielen = false;
                break;
            case 2: // Nochmals spielen
                nochmalSpielen = true;
                break;
            case 0: // Beenden
                System.out.println("Programm wird beendet...");
                System.exit(0);
                break;
            default:
                System.out.println("Ungültige Eingabe! Zurück zum Hauptmenu.");
                nochmalSpielen = false;
        }
    }

    private static void fall2() {
        switch (sc.nextInt()) {
            case 1:
                System.out.print("Wählen Sie einen Benutzername: ");
                sv.addSpieler(sc.next());
                break;
            case 2:
                System.out.println(sv);
                break;
            case 3:
                System.out.print("Geben Sie den Benutzername zum Suchen ein: ");
                Spieler ges = sv.getSpieler(sc.next());
                if (ges == null) {
                    System.out.println("Es wurde kein Spieler gefunden");
                } else System.out.println(ges);
                break;
            case 4:
                System.out.print("Welchen Spieler wollen Sie entfernen: ");
                sv.entferneSpieler(sc.next());
                break;
        }
    }
}
