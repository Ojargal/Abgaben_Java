import java.util.Scanner;

public class Main_Wettlauf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean nochmalSpielen = true;

        System.out.println("***** HASEN VS SCHILDKRÖTE RENNEN *****");

        while (nochmalSpielen) {
            Wettlauf rennen = new Wettlauf();

            // Benutzerauswahl
            System.out.println("\nWählen Sie Ihren Läufer:");
            System.out.println("1 - Hase");
            System.out.println("2 - Schildkröte");
            System.out.print("Ihre Wahl (1/2): ");
            int wahl = sc.nextInt();

            // Rennstart
            System.out.println("\nSTART!");
            rennen.startRace();

            // Ergebnisprüfung
            String gewinner = rennen.getWinner();
            boolean benutzerGewinnt =
                    (wahl == 1 && gewinner.equals("Hase")) ||
                            (wahl == 2 && gewinner.equals("Schildkröte"));

            System.out.println("\n" + (benutzerGewinnt ? "GLÜCKWUNSCH!" : "LEIDER VERLOREN!") +
                    " Der " + gewinner + " hat gewonnen!");

            // Wiederholungsabfrage
            System.out.print("\nMöchten Sie nochmal spielen? (j/n): ");
            nochmalSpielen = sc.next().equalsIgnoreCase("j");
        }

        System.out.println("\nSpiel beendet. Danke fürs Spielen!");
        sc.close();
    }
}