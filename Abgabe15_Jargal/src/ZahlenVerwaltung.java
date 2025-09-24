import java.util.Random;
import java.util.Scanner;

public class ZahlenVerwaltung {

    private double[] ar;

    public ZahlenVerwaltung(int anzahl) {
        this.ar = new double[anzahl];
    }

    public boolean fuellen(){

       for (int i = 0; i < ar.length; i++) {
           Random random = new Random();
           double zahl = random.nextDouble(201) - 100;
           ar[i] = zahl;
       }
        return false;
    }

    public void eingeben(){

        Scanner sc = new Scanner(System.in);
        int index = 0;
        System.out.println("Bitte geben Sie Zahlen ein (Abbruch mit ungültiger Eingabe):");

        while (index < ar.length){
            System.out.print("Zahl " + (index + 1) + ": ");
            double bz = sc.nextDouble();
            if (bz >= -100 && bz <= 100){
                ar[index] = bz;
                index++;
            }else {
                sc.next();
                System.out.println("Ungültige Eingabe. Rest wird mit Zufallszahlen gefüllt.");
                break;
            }
        }
        for (int i = index; i < ar.length; i++) {
            Random random = new Random();
            double zahl = random.nextDouble(201) - 100;
            ar[i] = zahl;
        }

    }

    public void ausgeben (){
        for (int i = 0; i < ar.length; i++){
            System.out.printf("%8.2f", ar[i]);
            if ((i + 1) % 5 == 0 && i != ar.length - 1){
                System.out.println();
            } else if (i < ar.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public double mul(){
        if (ar == null || ar.length == 0){
            return 0.0;
        }
        double mul = 1.0;

        for (double zahl : ar){
                mul *= zahl;
        }
        return mul;
    }

    public double durch(){
        double gesamtSumme = 0.0;
        for (double zahl : ar){
            gesamtSumme += zahl;
        }
        return gesamtSumme / ar.length;
    }

    public double min(){
        if (ar == null || ar.length == 0) {
            throw new IllegalStateException("Array ist leer oder nicht initialisiert!");
        }
        double min = ar[0];
        for (int i = 1; i < ar.length; i++){
            if (ar[i] < min){
                min = ar[i];
            };
        }
        return min;
    }

    public double max2(){
        if (ar == null || ar.length < 2) {
            throw new IllegalStateException("Array muss mindestens 2 Elemente haben!");
        }
        double max1 = Math.max(ar[0], ar[1]);
        double max2 = Math.min(ar[0], ar[1]);

        for (int i = 2; i < ar.length; i++){
            if (ar[i] > max1){
                max2 = max1;
                max1 = ar[i];
            } else if (ar[i] > max2 && ar[i] != max1) {
                max2 = ar[i];
            }
        }
        return max2;
    }

    public void sort(){
        if (ar == null || ar.length <= 1){
            return;
        }

        for (int i = ar.length - 1; i > 0; i--){
            // Durchlaufe das Array von 0 bis i (reduziert sich nach jedem Durchlauf)
            for (int j = 0; j < i; j++){
                if (ar[j] > ar[j+1]){
                    swap(j, j +1);
                }
            }
        }
    }

    private void swap(int j, int i) {
        double temp =  ar[j];
        ar[j] = ar[i];
        ar[i] = temp;
    }
}
