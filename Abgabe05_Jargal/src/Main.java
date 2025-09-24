
    public class Main {
        public static void main(String[] args) {
            // Aufgabe 1
            Bus b1 = new Bus();
            Bus b2 = new Bus(false, 100, "Reisbus GmbH", 90);

            b1.print();

            b1.einsteigen(40);
            System.out.println("Bus b1 besetzt? " + b1.besetzt());
            b1.print();

            b1.einsteigen(0);
            System.out.println("Bus b1 besetzt? " + b1.besetzt());
            b1.print();

            b1.einsteigen(100);
            System.out.println("Bus b1 besetzt? " + b1.besetzt());
            b1.print();

            b1.aussteigen(10);
            System.out.println("Bus b1 besetzt? " + b1.besetzt());
            b1.print();

            b1.aussteigen(40);
            System.out.println("Bus b1 besetzt? " + b1.besetzt());
            b1.print();

            System.out.println("Bus b1 besetzt? " + b1.besetzt());
            b1.allesAussteigen();
            b1.print();

            b2.print();

            b2.einsteigen(10);
            System.out.println("Bus b2 besetzt? " + b2.besetzt());
            b2.print();

            b2.aussteigen(100);
            System.out.println("Bus b2 besetzt? " + b2.besetzt());
            b2.print();

            b2.einsteigen(10);
            System.out.println("Bus b2 besetzt? " + b2.besetzt());
            b2.print();

            b2.allesAussteigen();
            b2.print();

            //Aufgabe 2
            Minimum m1 = new Minimum();

            System.out.println("min2 : " + m1.min2(5, 10));
            System.out.println("min3 : " + m1.min3(20, 4, 100));
            System.out.println("min4 : " + m1.min4(9, 80, 1, 8));

            //Aufgabe 3
            Tierhandlung t1 = new Tierhandlung();
            Tierhandlung t2 = new Tierhandlung("Hans Huhn", 120, 200, 1500.0, true);

            t1.printTierhandlung();

            t1.mieteErhoehen(-10.0);
            t1.mieteErhoehen(50.0);

            t1.printTierhandlung();
            System.out.println("Tierhandlung t1 voll? " + t1.voll());

            t2.printTierhandlung();

            t2.tierVerkauf(400);
            t2.tierVerkauf(100);

            t2.printTierhandlung();
        }
    }


