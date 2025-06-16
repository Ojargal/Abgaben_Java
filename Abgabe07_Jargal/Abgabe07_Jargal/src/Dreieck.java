public class Dreieck {
//    Eigenschaften

    private int a;
    private int b;
    private int c;

//    Standard-Methode
    public Dreieck(){
        a = 1;
        b = 1;
        c = 1;
    }

//    Konstruktor mit Parametern

    public Dreieck(int a, int b, int c) {
        setA(a);
        setB(b);
        setC(c);
    }

//    Setter-Methode

    public void setA(int a) {
            if(a >= 1 && a <= 1000){
                this.a = a;
            }else {
                System.out.println("Fehler: Ungültige Wert. Das Wert wird um 1 gesetzt.");
                this.a = 1;
            }
    }

    public void setB(int b) {
            if(b >= 1 && b <= 1000){
                this.b = b;
            }else {
                System.out.println("Fehler: Ungültige Wert. Das Wert wird um 1 gesetzt.");
                this.b = 1;
            }
    }

    public void setC(int c) {
            if(c >= 1 && c <= 1000){
                this.c = c;
            }else {
                System.out.println("Fehler: Ungültige Wert. Das Wert wird um 1 gesetzt.");
                this.c = 1;
            }
    }
//    Getter-Methode

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
//    Allgemein-Methode
    public boolean istAllgemein(){
        if (a + b > c && a + c > b && b + c > a){
            return true;
        }return false;
    }


//    Rechtwinklig-Method
    public boolean istRechtwinklig(){

        if (istAllgemein()){
            int ak = a * a;
            int bk = b * b;
            int ck = c * c;
            if (ak + bk == ck || bk + ck == ak || ck + ak == bk) {
                return true;
            }else {return false;}
        }return false;

    }
// Gleichseitig - Methode
    public boolean istGleichseitig(){
        if (istAllgemein()){

            if (a == b && b == c) {
                return true;
            }else {return false;}
        }return false;
    }

//    Gleichschenkelig - Methode
    public boolean istGleichschenkelig(){
        if (istAllgemein()){

            if (a == b) {
                return true;
            }else {return false;}
        }return false;
    }

    public String dReieck(){
        if (istRechtwinklig()){
            return "rechtwicklig";
        }else if (istGleichseitig()) {
            return "gleichseitig";
        } else if (istGleichschenkelig()) {
            return "gleichschenkelig";
        }else {return "unerwartete";}
    }

//    PRINT

    public void print(){
        if (istAllgemein()){
        System.out.println("Das Dreieck mit den Seiten " + a + ", " + b + " und " + c + " ist " + dReieck());}
        else {
            System.out.println("Das ist kein Dreieck");
        }
    }

}


