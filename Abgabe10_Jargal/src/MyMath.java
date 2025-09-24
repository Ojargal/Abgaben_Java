public class MyMath{


    public void einmaleinsTabelle(int zahl){
        if (zahl < 1 || zahl > 10){
            System.out.println("Error: Number must be between 1 and 10!");
            return;
        }
        System.out.println("Multiplication table for " + zahl + ":");
        for (int i = 1; i <= 10; i++){
            System.out.println(i + " * " + zahl + " = " + (i * zahl));
        }
    }
    public void teilbar(int von, int bis, int zahl) {
        if (zahl == 0){
            System.out.println("Error: Division by 0 is not allowed!");
            return;
        }
        if (von > bis){
            System.out.println("Error: 'von' must be greater than 'bis'!");
            return;
        }

        if (von % zahl != 0){
//            von += zahl - (von % zahl);
            while(von % zahl != 0){
                von ++;
            }
        }
        System.out.println("In the interval [" + von + ", " + bis + "], the following numbers are divisible by " + zahl + ": ");
        StringBuilder output = new StringBuilder();
        for (int i = von; i <= bis; i += zahl){
            output.append(i).append(", ");
        }
        // Entferne das letzte Komma und Leerzeichen
        if (output.length() > 0){
            output.setLength(output.length() - 2);
        }
        System.out.println(output);
    }

    public void produkt(int von, int bis){
        if (von > bis) {
            System.out.println("Error: 'von' must be greater than 'bis'!");
            return;
        }

        int produkt = 1;
        String ausgabe = "" + von; // Start mit der ersten Zahl

        for (int i = von + 1; i <= bis; i++){
            produkt *= 1;
            ausgabe += " * " + i;
        }

        System.out.println(ausgabe + " = " + produkt);
    }
}
