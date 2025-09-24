public class PrimUndEcke {

    public static boolean istPrim(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public void printPrim(int start, int ende){
        int count = 0;
        for (int i = start; i <= ende; i++){
            if (istPrim(i)){
                System.out.printf("%7d", i);
                count++;
                if (count % 10 == 0){
                    System.out.println();
                }
            }
        }
        if (count % 10 != 0){
            System.out.println();
        }
    }

//    printEcke1(int hoehe) Methode

    public void printEcke1(int hoehe){


        for (int i = 0; i < hoehe; i++){
            for (int j = 0; j <= i; j++ ){

                System.out.print(" *");
            }
            System.out.println();
        }
    }

//  printEcke2(int hoehe) Methode

public void printEcke2(int hoehe){
    for (int i = hoehe-1; i >= 0; i--){
        for (int j = 0; j <= i; j++ ){

            System.out.print(" *");
        }
        System.out.println();
    }
}

// printEcke3 - Methode
public void printEcke3(int hoehe, char z1, char z2){

        for (int i = 0; i < hoehe; i++){
        for (int j = 0; j <= i; j++ ){
                if ((j+i) % 2 == 0) {System.out.print(z1);
                }
                else {System.out.print(z2);}
        }
        System.out.println();
        }

    }

    public void printEcke4(int hoehe, char z1, char z2) {
        for (int i = 1; i <= hoehe; i++) {
             for (int j = 1; j <= i; j++) {
                if (i == 1 || j == hoehe) {
                    System.out.print(z1+" ");
                } else {
                    System.out.print(z2+" ");
                }
            }


            System.out.println();
        }
    }




}


