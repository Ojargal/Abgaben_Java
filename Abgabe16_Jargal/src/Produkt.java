

public class Produkt {
//    Eigenschaften
    private String name;
    private String hersteller;
    private double preis;
    private int anzahl;
    private Ablaufdatum haltbar;

//    Konstruktor


    public Produkt(String name, String hersteller, double preis, int anzahl, Ablaufdatum haltbar){
        setName(name);
        setHersteller(hersteller);
        setAnzahl(anzahl);
        setPreis(preis);
        setHaltbar(haltbar);

    }

    //    Getter und Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public Ablaufdatum getHaltbar() {
        return haltbar;
    }

    public void setHaltbar(Ablaufdatum haltbar) {
        this.haltbar = haltbar;
    }

//    Prüft ob Produkt abgelaufen ist
    public boolean abgeLaufen(int jahr, int monat){
        return haltbar.istVor(jahr, monat);
    }

//    Verkauft eine bestimmte Anzahl
    public void verkaufen(int anzahl){
        if (anzahl <= this.anzahl && anzahl > 0){
            this.anzahl -= anzahl;
            System.out.printf("Produkt: %s wurde %d Stk verkauft ud rest sind: %d%n", getName(), anzahl, this.anzahl);
        } else {
            System.out.println("Fehler: verkaufen() Anzahl ist 0, negativ oder zu Viel!");
        }
    }

//    Prüft ob zwei Produkte gleich sind (nur Name)
    public boolean gleich(Produkt p){
        return this.name.equals(p.name);
    }

//    Prüft ob zwei Produkte komplett gleich sind (Name + Hersteller + Ablaufdatum)
    public boolean komplettGleich(Produkt p){
        return this.name.equals(p.name) &&
                this.hersteller.equals(p.hersteller) &&
                this.haltbar.gleich(p.haltbar);
    }

//    toString für Ausgabe
    @Override
    public String toString() {
        return name + "(" + hersteller + ") - " + preis + "€ - " + anzahl +
                " Stück - Haltbar bis: " + haltbar.toString();
    }

}
