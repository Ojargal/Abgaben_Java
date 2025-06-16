public class Main {
    public static void main(String[] args) {

        //Aufgabe 1
//        Buch b1 = new Buch();
//        Buch b2 = new Buch(true, 254, "Duckscher Geheimdienst 01", "Walt Disney");
//        Buch b3 = new Buch(false, 1258, "Java ist auch eine Insel", "Christian Ullenboom");
//
//        b1.print();
//        System.out.println();
//        b2.print();
//        System.out.println();
//        b3.print();

        //Aufgabe 2
        Flugzeug f1 = new Flugzeug();
        Flugzeug f2 = new Flugzeug(0, 0, "A320", 0);
        Flugzeug f3 = new Flugzeug(4, 68, "747-8", 364);

        f1.print();
        System.out.println();
        f2.print();
        System.out.println();
        f3.print();

        //Aufgabe 3
        testDatentypen();
    }

    public static void testDatentypen() {
        //Implementieren Sie hier Aufgabe 3
        boolean wahrheit = true;
        byte age = 127;
        short zäne = 32767;
        char buchstaben = 'a';
        int ganzeZahlen = 2147;
        float pZahl = 3.14f;
        long ganzeZahlenLong = 96L;
        double gleitKommaZahl = 1.5d;
        String night = "day2700";

   }
}
