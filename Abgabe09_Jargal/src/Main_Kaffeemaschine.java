import java.util.Scanner;

public class Main_Kaffeemaschine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Kaffeemaschine maschine = new Kaffeemaschine();

        System.out.println("Willkommen zur Kaffeemaschinen-Steuerung!");

        // Hauptprogrammschleife
        while (true) {
            if (maschine.isEingeschaltet()) {
                // Menü für eingeschaltete Maschine
                boolean beenden = false;

                while (!beenden) {
                    System.out.println("\nMenü");
                    System.out.println("2 - Kaffeemaschine ausschalten");
                    System.out.println("3 - Wasser auffüllen");
                    System.out.println("4 - Bohnen auffüllen");
                    System.out.println("5 - Kaffee kochen");
                    System.out.println("6 - Status anzeigen");
                    System.out.println("0 - Programm beenden");
                    System.out.print("Ihre Wahl: ");

                    int auswahl = sc.nextInt();
                    sc.nextLine(); // Verbleibende Zeile konsumieren

                    switch (auswahl) {
                        case 2:
                            maschine.ausschalten();
                            beenden = true; // Verlässt das eingeschaltete Menü
                            break;

                        case 3:
                            System.out.print("Geben Sie die Menge Wasser in ml ein: ");
                            double wasserMenge = sc.nextDouble();
                            maschine.wasserAuffuellen(wasserMenge);
                            break;

                        case 4:
                            System.out.print("Geben Sie die Menge Bohnen in g ein: ");
                            int bohnenMenge = sc.nextInt();
                            maschine.bohnenAuffuellen(bohnenMenge);
                            break;

                        case 5:
                            System.out.println("\nKAFFEEAUSWAHL");
                            System.out.println("Espresso (30ml Wasser, 10g Bohnen)");
                            System.out.println("Latte (100ml Wasser, 20g Bohnen)");
                            System.out.println("Cappuccino (120ml Wasser, 25g Bohnen)");
                            System.out.print("Geben Sie den Namen der gewünschten Kaffeesorte ein: ");
                            String kaffeeArt = sc.nextLine().trim();
                            maschine.kochen(kaffeeArt);
                            break;

                        case 6:
                            System.out.println("\nAktueller Status:");
                            System.out.println("Eingeschaltet: " + maschine.isEingeschaltet());
                            System.out.println("Wasser: " + maschine.getWasserfuellstand() + " ml / "
                                    + maschine.getWasserKapazitaet() + " ml");
                            System.out.println("Bohnen: " + maschine.getBohnenFuellstand() + " g / "
                                    + maschine.getBohnenKapazitaet() + " g");
                            break;

                        case 0:
                            maschine.ausschalten();
                            System.out.println("Programm wird beendet...");
                            sc.close();
                            return;

                        default:
                            System.out.println("Ungültige Eingabe! Bitte wählen Sie 0, 2-6");
                    }
                }
            } else {
                // Menü für ausgeschaltete Maschine
                System.out.println("\nMaschine ist ausgeschaltet");
                System.out.println("1 - Kaffeemaschine einschalten");
                System.out.println("0 - Programm beenden");
                System.out.print("Ihre Wahl: ");

                int einSchalt = sc.nextInt();

                if (einSchalt == 1) {
                    maschine.einschalten();
                }
                else if (einSchalt == 0) {
                    System.out.println("Programm wird beendet...");
                    sc.close();
                    return;
                }
                else {
                    System.out.println("Fehler: Bitte wählen Sie 1 zum Einschalten oder 0 zum Beenden!");
                }
            }
        }
    }
}