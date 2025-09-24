import java.util.Scanner;

public class Main_Schleife {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Eingabe der Grenze (0-200)
        int grenze;
        do {
            System.out.print("Grenze eingeben (0-200): ");
            grenze = sc.nextInt();
        } while (grenze < 0 || grenze > 200);
        Schleife s = new Schleife(grenze);

        // Test von while1() bis while9() mit Scanner-Eingaben
        System.out.println("\n--- while1(): 0 bis 10 ---");
        s.while1();

        System.out.println("\n--- while2(): 10 bis 20 (Schritt 2) ---");
        s.while2();

        System.out.println("\n--- while3(): 10 bis -10 (Schritt -1) ---");
        s.while3();

        System.out.print("\n--- while4(anzahl): Anzahl Werte ab 0 (Schritt 5) ---\nAnzahl: ");
        s.while4(sc.nextInt());

        System.out.println("\n--- while5(): 0 bis grenze mit '-' ---");
        s.while5();

        System.out.print("\n--- while6(start): Start bis grenze ---\nStartwert: ");
        s.while6(sc.nextInt());

        System.out.print("\n--- while7(gr1, gr2): Von klein zu groß ---\nZahl 1: ");
        int gr1 = sc.nextInt();
        System.out.print("Zahl 2: ");
        s.while7(gr1, sc.nextInt());

        System.out.print("\n--- while8(start): Gerade Zahlen bis grenze ---\nStartwert: ");
        s.while8(sc.nextInt());

        System.out.println("\n--- while9(): Bruchfolge bis Zähler = grenze ---");
        s.while9();

        sc.close();
    }
}