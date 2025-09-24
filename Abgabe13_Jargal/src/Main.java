import java.io.PrintStream;

public class Main{
    public static void main(String[] args) {
//    aufgabe1();
//    aufgabe2();
      aufgabe3();


    }

    private static void aufgabe3() {
//        Bäume erstellen
        Baum buche = new Baum("Buche", (short) 30, 25.0, false, 1.2);
        Baum eiche = new Baum("Eiche", (short) 45, 55.0, false, 1.8);
        Baum krankeFichte = new Baum("Fichte", (short) 20, 30.0, true, 0.9);
//        MiniWald erstellen
        MiniWald wald = new MiniWald("Mein Wald");
        wald.pflanzen(buche);
        wald.pflanzen(eiche);
        wald.pflanzen(krankeFichte);

//        Testausgaben
        System.out.println("==== Initialer Zustand =====");
        wald.print();

//        Baum fällen
        System.out.println("\n==== Fällen ====");
        Baum gefaellt = wald.faellen();
        if (gefaellt != null){
            System.out.println("Gefällt: " + gefaellt.getName());
        }

        System.out.println("\n==== Zustand nach Fällen ====");
        wald.print();

//        Neuen Baum pflanzen
        System.out.println("\n==== Neuen Baum pflanzen ====");
        wald.pflanzen(new Baum("Birke", (short)5, 8.0, false, 0.5));
        wald.print();
    }

    private static void aufgabe2() {
        // USB-Sticks erstellen
        USBStick stick1 = new USBStick("DataKing", 1024, 30);
        USBStick stick2 = new USBStick("", 256, 120); // Fehlerhafte Werte

        // Computer erstellen
        Computer pc = new Computer("Office-PC", 599);
        pc.setUsb0(stick1);
        pc.setUsb1(stick2);

        // Testausgaben
        System.out.println("\n--- USB-Stick 1 ---");
        stick1.printUSBStick();

        System.out.println("\n--- USB-Stick 2 ---");
        stick2.printUSBStick();

        System.out.println("\n--- Computer ---");
        pc.printComputer();

        System.out.println("\nGesamtverkaufspreis: " + pc.summeVerkaufsPreis() + "€");
    }

    private static void aufgabe1() {
        Person pr1 = new Person();
        Person pr2 = new Person("Odkhuu", "Jargal", 32, 200, true);
        Person pr3 = new Person("Max", "Muster", 18, 150, true);
        Person pr4 = new Person("Don", "Carolino", 25, 35, true);
        Person pr5 = null;


        Sportwagen sp1 = new Sportwagen("lambo", 2500, 25, pr2, pr1);
        Sportwagen sp2 = new Sportwagen("Mus", 3000, 10, pr4, pr5);
        Sportwagen sp3 = new Sportwagen("Toy", 700, 20, pr3, pr2);
        Sportwagen sp4 = new Sportwagen("Mac", 600, 30, pr4, pr3);

        System.out.

                println("#".repeat(20));
        sp1.

                schnellfahren(150);
        sp1.

                printSportwagen();
        System.out.

                println("#".repeat(20));
        sp2.

                schnellfahren(150);
        sp2.

                printSportwagen();
        System.out.

                println("#".repeat(20));
        sp3.

                schnellfahren(150);
        sp3.

                printSportwagen();
        System.out.

                println("#".repeat(20));
        sp4.

                schnellfahren(150);
        sp4.

                printSportwagen();
        System.out.

                println("#".repeat(20));

    }
}




