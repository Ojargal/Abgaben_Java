public class Plakat {
    private int preis;
    private boolean farbe;
    private boolean dach;


    // Standardkonstruktor
    public Plakat() {
        this.preis = 40; // Kleinster erlaubter Wert als Default
        this.farbe = false;
        this.dach = false;
    }

    // Konstruktor mit Parametern
    public Plakat(int preis, boolean farbe, boolean dach) {
        setPreis(preis, farbe, dach);
        this.farbe = farbe;
        this.dach = dach;
    }

    // Getter-Methoden
    public int getPreis() {
        return preis;
    }

    public boolean hatFarbe() {
        return farbe;
    }

    public boolean hatDach() {
        return dach;
    }

    // Setter-Methoden
    public void setPreis(int preis, boolean farbe, boolean dach) {
        if (preis >= 200 && farbe) {
            this.preis = preis;
        } else if (preis >= 100 && !farbe && dach) {
            this.preis = preis;
        } else if (preis >= 40 && preis <= 99 && !farbe && !dach) {
            this.preis = preis;
        } else {
            System.out.println("Fehler: Ungültige Kombination für den Preis. Der Preis wurde auf den kleinsten erlaubten Wert (40) gesetzt.");
            this.preis = 40;
        }
    }

    public void setFarbe(boolean farbe) {
        this.farbe = farbe;
        // Da die Farbe den Preis beeinflussen kann, rufen wir setPreis mit den aktuellen Werten auf,
        // um Inkonsistenzen zu vermeiden.
        setPreis(this.preis, this.farbe, this.dach);
    }

    public void setDach(boolean dach) {
        this.dach = dach;
        setPreis(this.preis, this.farbe, this.dach);
    }


    public void print() {
        System.out.println("##########################");
        System.out.println("## Preis: " + preis);
        System.out.println("## Farbe: " + farbe);
        System.out.println("## Dach: " + dach);
        System.out.println("##########################");
    }
}
