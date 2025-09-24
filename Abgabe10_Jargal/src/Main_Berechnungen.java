import java.util.Scanner;

public class Main_Berechnungen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Berechnungen br = new Berechnungen();

        System.out.println("***** Berechnungs-Menü *****");
        System.out.println("1. Potenzberechnung (x^n)");
        System.out.println("2. Bruchfolge generieren");
        System.out.println("3. Zinseszinsberechnung");
        System.out.println("4. Freier Fall Simulation");
        System.out.print("Wählen Sie eine Option (1-4): ");

        int option = sc.nextInt();

        switch(option) {
            case 1:
                // Hochzahl berechnen
                System.out.print("Geben Sie den Exponenten ein: ");
                int exponent = sc.nextInt();
                br.hochzahl(exponent);
                break;

            case 2:
                // Bruchfolge generieren
                System.out.print("Start-Zähler: ");
                int zaehler = sc.nextInt();
                System.out.print("Start-Nenner: ");
                int nenner = sc.nextInt();
                System.out.print("Anzahl der Schritte: ");
                int grenze = sc.nextInt();
                br.folge(zaehler, nenner, grenze);
                break;

            case 3:
                // Zinseszins berechnen
                System.out.print("Jährlicher Zinssatz (%): ");
                int prozent = sc.nextInt();
                System.out.print("Laufzeit in Jahren: ");
                int jahre = sc.nextInt();
                br.gewinn(prozent, jahre);
                break;

            case 4:
                // Freier Fall simulieren
                System.out.print("Starthöhe (m): ");
                int startHoehe = sc.nextInt();
                System.out.print("Fallzeit (s): ");
                int zeit = sc.nextInt();
                br.falling(startHoehe, zeit);
                break;

            default:
                System.out.println("Ungültige Option!");
        }

        sc.close();
    }
}