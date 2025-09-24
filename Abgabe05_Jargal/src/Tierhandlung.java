public class Tierhandlung {
//    Eigencschaften
    private String besitzer;
    private int anzahltiere, maxAnzahlTiere;
    private double miete;
    private boolean offen;

//    Standardkonstruktor
    public Tierhandlung(){
        besitzer = "Toni Tierlieb";
        anzahltiere = 5;
        maxAnzahlTiere = 10;
        miete = 100;
        offen = false;
    }

//    Konstruktor mit 5 Parametern
    public Tierhandlung(String besitzer, int anzahltiere, int maxAnzahlTiere, double miete, boolean offen){
        setBesitzer(besitzer);
        setMaxAnzahlTiere(maxAnzahlTiere);
        setAnzahltiere(anzahltiere);

        setMiete(miete);
        setOffen(offen);
    }

//    Setter-Methoden
    public void setBesitzer(String besitzer){this.besitzer = besitzer;}
    public void setAnzahltiere(int anzahltiere){
        if(anzahltiere > 0 && anzahltiere <= maxAnzahlTiere)
        {this.anzahltiere = anzahltiere;}
        else {
            System.out.println("Fehler: Anzahl der Tiere werden Default ersetzt");
            this.anzahltiere = 5;
        }
    }
    public void setMaxAnzahlTiere(int maxAnzahlTiere){
        if (maxAnzahlTiere > 0){this.maxAnzahlTiere = maxAnzahlTiere;}
        else {

            System.out.println("Fehler: Maximal Anzahl der Tiere werden Defaultwert ersetzt");
            this.maxAnzahlTiere = 10;
        }
    }
    public void setMiete(double miete){
        if (miete > 1000){
            if (anzahltiere >= 100){
                this.miete = miete;
            } else {System.out.println("Fehler: zu weniger Tiere oder zu hoher Miete");}
        }else {this.miete = miete;}

    }
    public void setOffen(boolean offen){this.offen = offen;}

//    getter Methoden
    public String getBesitzer(){return besitzer;}
    public int getAnzahltiere(){return anzahltiere;}
    public int getMaxAnzahlTiere(){return maxAnzahlTiere;}
    public double getMiete(){return miete;}
    public boolean isOffen(){return offen;}

//    String ausgeben
    public String Offnen(){if (offen){return "Geöffnet";}else {return "Geschlossen";}}

//    Print - Method
    public void printTierhandlung(){
        System.out.println("###############################");
        System.out.println("## Besitzer: " + besitzer);
        System.out.println("## Anzahl Tiere: " + anzahltiere);
        System.out.println("## Maximal Anzahl Tiere: " + maxAnzahlTiere);
        System.out.println("## Miete: " + miete);
        System.out.println("## Offen: " + Offnen());

//        if (offen){System.out.println("## Offen: Geöffnet");}
//        else {System.out.println("## Offen: Geschlossen");}

        System.out.println("###############################");
    }
    public void tierVerkauf(int anzahl){
        if (anzahl > 0 && anzahl <= anzahltiere){
            if (offen){
                anzahltiere -= anzahl;
            }else {System.out.println("Leider wir sind geschlossen");}

        }else {System.out.println("Fehler: falsche Anzahl");}
    }
    public void mieteErhoehen(double prozent){
        if (prozent > 0){
            miete *= prozent/100;
        }else {System.out.println("Keine Mietzinse oder negative wert");}
    }
    public boolean voll(){
        if (maxAnzahlTiere == anzahltiere){
            return true;
        }else {return false;}
    }


}
