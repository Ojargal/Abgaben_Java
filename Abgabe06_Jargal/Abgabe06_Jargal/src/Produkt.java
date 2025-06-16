public class Produkt {
//    Eigenschagten
    private String produktName;
    private double preis;
    private int menge;

//    Standard Konstruktor
    public Produkt(){
        preis = 1000.0;
        produktName = "Laptop";
        menge = 10;
    }

//    Konstruktor mit 3 Parametern
    public Produkt(String produktName, double preis, int menge){
        setProduktName(produktName);
        setPreis(preis);
        setMenge(menge);
    }


// Getter-Methoden
    public String getProduktName() {
        return produktName;
    }

    public double getPreis() {
        return preis;
    }

    public int getMenge() {
        return menge;
    }
//    Setter-Methoden


    public void setProduktName(String produktName) {
        this.produktName = produktName;
    }

    public void setPreis(double preis) {
        if (preis > 0) {
            this.preis = preis;
        }else {
            System.out.println("Fehler: Preis muss angegeben werden.");
        }
    }

    public void setMenge(int menge) {
        if (menge >= 0) this.menge = menge;
        else {
            System.out.println("Fehler: Negative Menge");
        }
    }

    public int verfuegbar(){
            if (menge > 0){
                return menge;
            }else {
                return menge = 0;
            }
    }

    public double berechneGesamtwert(){return menge * preis;}

}
