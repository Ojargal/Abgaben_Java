import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Aufgabe1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Gib ein Nummer ein:");
        int num = sc.nextInt();
        papierschnitt(num);
    }

    public static void papierschnitt(int n) {
        List<String> alleMoeglichkeiten = new ArrayList<>();
        generiereMoeglichkeiten(n, "", alleMoeglichkeiten);

        System.out.println("Für n = " + n + " gibt es " + alleMoeglichkeiten.size() +
                " Möglichkeiten:");
        for (int i = 0; i < alleMoeglichkeiten.size(); i++) {
            System.out.println((i + 1) + ": " + alleMoeglichkeiten.get(i));
        }
    }

    // Rekursive Hilfsmethode
    private static void generiereMoeglichkeiten(int restLaenge, String aktuellerSchnitt, List<String> ergebniss) {
        // Basisfall: Papier komplett geschnitten
        if (restLaenge == 0) {
            ergebniss.add(aktuellerSchnitt.trim());
            return;
        }

        // Schneide 1 cm ab(wenn möglich)
        if (restLaenge >= 1) {
            generiereMoeglichkeiten(restLaenge - 1, aktuellerSchnitt + "1 ", ergebniss);
        }

        // Schneide 2 cm ab (wenn möglich)
        if (restLaenge >= 2) {
            generiereMoeglichkeiten(restLaenge -2, aktuellerSchnitt +
            "2 ", ergebniss);
        }
    }
}