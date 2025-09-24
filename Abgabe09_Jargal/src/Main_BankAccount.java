
import java.util.Scanner;
public class Main_BankAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        Bankkonto erstellen
        System.out.println("---Neues KOnto erstellen---");
        System.out.print("Vorname: ");
        String vorname = sc.nextLine().trim();

        System.out.print("Nachname: ");
        String nachname = sc.nextLine().trim();

        System.out.print("Anfangsguthaben (EUR): ");
        double guthaben = sc.nextDouble();
        sc.nextLine();

        System.out.print("Kontotyp (Girokonto/Sparbuch): ");
        String accouttyp = sc.nextLine();

//        Konto initialisieren
        BankAccount account = new BankAccount(vorname, nachname, guthaben, accouttyp);

        System.out.println("\nKonto erfolgreich erstellt!");
        account.print();

//        Benutzerinteraktion
        boolean running = true;
        while (running){
            System.out.println("\n---Aktion---");
            System.out.println("'e' - Einzahlen");
            System.out.println("'a' - Abheben");
            System.out.println("'z' - Zinsen berechnen");
            System.out.println("'q' - Beenden");
            System.out.print("Ihre Wahl: ");


            String choice = sc.nextLine().trim().toLowerCase();

            switch (choice){
                case "e":
                    handelEinzahlen(account, sc);
                    break;
                case "a":
                    handleAbheben(account, sc);
                    break;
                case "z":
                    handelZinsen(account, sc);
                    break;
                case "q":
                    running = false;
                    System.out.println("Auf Wiedersehen, " + account.getNachname() + "!");
                    break;
                default:
                    System.out.println("Ungültige Eingabe! Bitte 'e', 'a', 'z' oder 'q' wählen.");

            }
        }
        sc.close();

    }
//    Hilfsmethode: Einzahlen
    private static void handelEinzahlen(BankAccount account, Scanner sc){
        System.out.print("Betrag zum Einzahlen (EUR): ");
        int betrag = sc.nextInt();
        sc.nextLine(); // Consume newLine
        account.einzahle(betrag);
    }

//    Hilfsmethode: Abheben
private static void handleAbheben(BankAccount account, Scanner sc){
    System.out.print("Betrag zum Abheben (EUR): ");
    int betrag = sc.nextInt();
    sc.nextLine(); // Consume newLine
    account.abheben(betrag);
}

// Hilfsmethode: Zinsen berechnen
private static void handelZinsen(BankAccount account, Scanner sc){
    System.out.print("Zinssatz (%): ");
    double rate = sc.nextDouble();
    sc.nextLine(); // Consume newLine
    account.berechneZinsen(rate);
}
}
