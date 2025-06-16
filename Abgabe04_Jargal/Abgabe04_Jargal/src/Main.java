public class Main {
    public static void main(String[] args) {
        //Aufgabe 1
//        Moped m1 = new Moped();
//        Moped m2 = new Moped(false, 100, "David Alaba", 130, 1500);
//
//        m1.print();
//        m1.fahren(999);
//        m1.print();
//        m1.fahren(2000);
//        m1.print();
//        System.out.println("Servicekosten: " + m1.service());
//        m1.print();
//
//        m2.print();
//        m2.fahren(0);
//        m2.print();
//        m2.fahren(1);
//        m2.print();
//        System.out.println("Servicekosten: " + m2.service());
//        m2.print();
//        m2.aufbohren();
//        System.out.println("Servicekosten: " + m2.service());
//        m2.print();

        //Aufgabe 2
//        Auto a1 = new Auto();
//
//        a1.printInfo();
//        System.out.println("Alter: " + a1.berechneAlter());
//        System.out.println("Alter im Jahr 2010: " + a1.berechneAlter(2010));
//        a1.fahren();
//        a1.printInfo();
//        a1.fahren(200);
//        a1.printInfo();
//
//        Auto a2 = new Auto("Audi", 2020, true, true, 5, 10000);
//        a2.setBaujahr(2023);
//        a2.printInfo();
//        a2.setSitzplaetze(1);
//        a2.fahren(0);
//        a2.printInfo();
//
        //Aufgabe 3
        Plakat p1 = new Plakat(100, true, true);
        p1.print();
        Plakat p2 = new Plakat(90, false, true);
        p2.print();
        Plakat p3 = new Plakat(39, false, false);
        p3.print();
        Plakat p4 = new Plakat(233, false, false);
        p4.print();
        Plakat p5 = new Plakat(233, false, true);
        p5.print();
    }
}
