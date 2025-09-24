import java.util.Scanner;

public class Main_Notenpruefung {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        Notenpruefung p1 = new Notenpruefung();

        System.out.println("Wenisten Punkte: " + p1.getPunkte());
        Scanner sc = new Scanner(System.in);
        System.out.println("Geben Sie bitte Punkte ein: ");
        int i = sc.nextInt();
        Notenpruefung pI = new Notenpruefung(i);
        pI.pruefeNote();
//        System.out.println("Geben Sie bitte die Punkte ein: ");

        sc.close();
    }
}