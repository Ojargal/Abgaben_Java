public class Formel1 {
    private int pi = 3;

    public Formel1(){

    }

    public int flaecheRechteck(int a, int b){
        int ergebnis = a * b;
        return ergebnis;
    }
    public int addition(int a, int b){
        int ergebnis = a + b;
        return ergebnis;
    }
    public int division(int a, int b){
        int ergebnis = a / b;
        return ergebnis;
    }
    public int berechneY(int a, int b){
        int x = 3*a + 6*b-(a*a);
        int ergebnis = 5*x - 2*b;
        return ergebnis;
    }
    public int berechneZylinder(int a, int b){
        int g = a*a*pi;
        int ergebnis = g*b;
        return ergebnis;
    }
    public int berechneZ(int a, int b, int c){
        var u = 3*a + 6*b-(a*a);;
        int o = (3 * a + 6) / (b - c * c);
        int ergebnis = 5*u - 2*o;
        return ergebnis;
    }



}
