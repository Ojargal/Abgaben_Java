import java.util.Scanner;

public class Main_MyMath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyMath mm = new MyMath();

        System.out.println("Welcome to My Math!");

//        1. Multiplication table
        System.out.print("Please enter a number between 1 and 10: ");
        int einmaleins = sc.nextInt();
        mm.einmaleinsTabelle(einmaleins);
//      2. Divisible numbers in range
        System.out.print("Please enter starting number: ");
        int von = sc.nextInt();
        System.out.print("Please enter ending number: ");
        int bis = sc.nextInt();
        System.out.print("Please enter divisor: ");
        int zahl = sc.nextInt();
        mm.teilbar(von, bis, zahl);
//      3. Product of numbers in range
        System.out.println("Please enter starting number of product: ");
        int vonP = sc.nextInt();
        System.out.println("Please enter ending number of product: ");
        int bisP = sc.nextInt();
        mm.produkt(vonP, bisP);

        sc.close();
    }
}
