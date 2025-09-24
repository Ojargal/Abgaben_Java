public class Ablaufdatum {
//    Eigenschaften
    private int tag;
    private int monat;
    private int jahr;

    public  Ablaufdatum(int tag, int monat, int jahr){
        setJahr(jahr);
        setMonat(monat);
        setTag(tag);
    }

    public int getTag() {
        return tag;
    }
// Getter und Setter
    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getMonat() {
        return monat;
    }

    public void setMonat(int monat) {
        this.monat = monat;
    }

    public int getJahr() {
        return jahr;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

//    Prüft ob zwei Ablaufdaten gleich sind
    public boolean gleich(Ablaufdatum ab){
        return this.tag == ab.tag &&
                this.monat == ab.monat &&
                this.jahr == ab.jahr;
    }

//    Prüft ob das dieses Datum älter ist als das andere
    public boolean aelter(Ablaufdatum ab){
        if (this.jahr < ab.jahr) return true;
        if (this.jahr > ab.jahr) return false;

        if (this.monat < ab.monat) return true;
        if (this.monat > ab.monat) return false;

        return this.tag < ab.tag;
    }

//    toString für schöne Ausgabe


    @Override
    public String toString() {
        return String.format("%02d.%02d.%04d", tag, monat, jahr);
    }

//    Hilfsmethode für Vergleich mit Jahr/Monat
    public boolean istVor(int jahr, int monat){
        if(this.jahr < jahr) return true;
        if (this.jahr > jahr) return false;
        return this.monat < monat;
    }
}
