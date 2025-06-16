public class Formel2 {

    private int pi = 3;

    public int getPi() {
        return pi;
    }
    public Formel2(){

    }

   public int berechneHoch3(int a){
        int ergebnis = a*a*a;
        return ergebnis;
    }
    public int berechneHoch6(int a){
       int ergebnis = this.berechneHoch3(a) * this.berechneHoch3(a);
       return ergebnis;
    }
    public int berechneKreisFlaeche(int x){
       int ergebnis = x*x*pi;
       return ergebnis;
    }
    public int berechneZylinderVolumen(int a, int b){
        int ergebnis = this.berechneKreisFlaeche(a)*b;
        return ergebnis;
    }
    public int berechneZ(int a, int c){
        int b = a*a*a + c * 5;
        int u = 3*a +6*b - a*a;
        int o = (3*a + 6) / (b-c*c);
        int ergebnis = 5*u -2*o;
        return ergebnis;
    }
    public int berechneZylinderOberflaeche(int r, int h){
       int ergebnis = this.berechneKreisFlaeche(r) * h;
       return ergebnis;
    }





}
