public class Bus {
//    Eigenschaften
    private boolean linienbus;
    private int anzahlSitzpaetze, anzahlSitzplaetzeBesetzt;
    private String firma;


//    Standardkonstruktor
    public Bus(){
        linienbus = true;
        anzahlSitzpaetze = 50;
        firma = "Musterbus GmbH";
        anzahlSitzplaetzeBesetzt = 0;
    }
//    Konstruktor mit 4 Parametern
    public Bus(boolean linienbus, int anzahlSitzpaetze, String firma, int anzahlSitzpaetzeBesetzt){
        setLinenbus(linienbus);
        setAnzahlSitzplaetze(anzahlSitzpaetze);
        setFirma(firma);
        setAnzahlSitzplaetzeBesetzt(anzahlSitzpaetzeBesetzt);
    }
//    Getter-Methoden
    public boolean isLinienbus(){return linienbus;}
    public int getAnzahlSitzpaetze(){return anzahlSitzpaetze;}
    public String getFirma(){return firma;}
    public int getAnzahlSitzplaetzeBesetzt(){return anzahlSitzplaetzeBesetzt;}

//    Setter-Methoden

    public void setLinenbus(boolean linienbus){this.linienbus = linienbus;}
    public void setAnzahlSitzplaetze(int anzahlSitzpaetze){this.anzahlSitzpaetze = anzahlSitzpaetze;}
    public void setFirma(String firma){this.firma = firma;}
    public void setAnzahlSitzplaetzeBesetzt(int anzahlSitzplaetzeBesetzt){this.anzahlSitzplaetzeBesetzt = anzahlSitzplaetzeBesetzt;}

//    print-Methode
    public void print(){
        System.out.println("####################################");
        System.out.println("## Linenbus: " + linienbus);
        System.out.println("## Anzahl Sitzplätze: " + anzahlSitzpaetze);
        System.out.println("## Firma: " + firma);
        System.out.println("## Anzahl Sitzplätze besetzt: " + anzahlSitzplaetzeBesetzt);
        System.out.println("###################################");

    }

//    einsteigen(int)-Method

//    public void einsteigen(int anzahl){
//       if ((anzahl >= 1) && (anzahl <= (anzahlSitzpaetze - anzahlSitzplaetzeBesetzt))) {
//           anzahlSitzplaetzeBesetzt += anzahl;
//        }
//       else {System.out.println("Fehler: zu wenig Einsteiger oder nicht genug Sitzplätze");}
//    }
    public void einsteigen(int anzahl){
        if (anzahl >= 1){
            if (anzahl <= (anzahlSitzpaetze - anzahlSitzplaetzeBesetzt)){anzahlSitzplaetzeBesetzt += anzahl;}
            else {System.out.println("Fehler: zu wenig Sitzplätze");}
            }
        else {System.out.println("Fehler: zu wenig EinsteigerInnen");}
    }

//    aussteigen(int)-Method

    public void aussteigen(int anzahl){
        if (anzahl >= 1 && anzahl <= anzahlSitzplaetzeBesetzt){
            anzahlSitzplaetzeBesetzt -= anzahl;
        }
        else {
            System.out.println("Fehler");
        }
    }
//    Alles Aussteigen-Methode
    public void allesAussteigen(){
        anzahlSitzplaetzeBesetzt -= anzahlSitzplaetzeBesetzt;
    }
//    besetzt(): boolean Method

    public boolean besetzt(){
        if (anzahlSitzplaetzeBesetzt == anzahlSitzpaetze){
            return true;}

        return false;
    }
}
