public class Main {

    public static void main(String[] args) {

        int a = 5;
        int b = 10;
        int c = 15;

        //Aufgabe 1

        Formel1 f1 = new Formel1();

        int erg1 = f1.addition(a, b);
        int erg2 = f1.flaecheRechteck(a, b);
        int erg3 = f1.berechneY(a, b);
        int erg4 = f1.berechneZ(a, b, c);
        int erg5 = f1.division(b, a);
        int erg6 = f1.berechneZylinder(a, b);

        System.out.println("========== FORMEL1 ==========");
        System.out.println("Addition: " + erg1);
        System.out.println("Fläche Rechteck: " + erg2);
        System.out.println("Berechne Y: " + erg3);
        System.out.println("Berechne Z: " + erg4);
        System.out.println("Division: " + erg5);
        System.out.println("Berechne Zylinder: " + erg6);
        System.out.println();

        //Aufgabe 2

        Formel2 f2 = new Formel2();

        int erg7 = f2.berechneHoch3(a);
        int erg8 = f2.berechneHoch6(a);
        int erg9 = f2.berechneKreisFlaeche(b);
        int erg10 = f2.berechneZ(a, b);
        int erg11 = f2.berechneZylinderOberflaeche(a, b);
        int erg12 = f2.berechneZylinderVolumen(a, b);

        System.out.println("========== FORMEL2 ==========");
        System.out.println("Berechne Hoch3: " + erg7);
        System.out.println("Berechne Hoch6: " + erg8);
        System.out.println("Berechne Kreisflaeche: " + erg9);
        System.out.println("Berechne Z: " + erg10);
        System.out.println("Berechne Zylinderoberflaeche: " + erg11);
        System.out.println("Berechne Zylindervolumen: " + erg12);
    }
}
