public class Person {
//    Eigenschaften
    private String vorname;
    private String nachname;
    private int alter;
    private double bargeld;
    private boolean fuererschein;

//    standard constructor


    public Person(){
        vorname = "Max";
        nachname = "Muster";
        alter = 16;
        bargeld = 80;
        fuererschein = false;
    }


    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        if(vorname != null && !vorname.isBlank()){
            this.vorname = vorname;
        }else {
            System.out.println("Fehler: Eingabe ungültig. (vorname)");
            this.vorname = "Max";
        }
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        if(nachname != null && !nachname.isBlank()){
            this.nachname = nachname;
        }else {
            System.out.println("Fehler: Eingabe ungültig. (nachname)");
            this.nachname = "Muster";
        }
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        if (alter > 0){
            this.alter = alter;

        }else {
            System.out.println("Fehler: Alter darf nicht negativ sein.");

        }
    }

    public double getBargeld() {
        return bargeld;
    }

    public void setBargeld(double bargeld) {
        if (bargeld >= 0){
            this.bargeld = bargeld;
        }else {
            System.out.println("Fehler: Keine Bargeld");
            this.bargeld = 0;
        }
    }

    public boolean isFuererschein() {

             return fuererschein;

    }

    public void setFuererschein(boolean fuererschein) {
        if (fuererschein && alter > 17){
            this.fuererschein = fuererschein;
        }else {
            this.fuererschein = false;
        }
    }

    public Person(String vorname, String nachname, int alter, double bargeld, boolean fuererschein) {
        setNachname(nachname);
        setVorname(vorname);
        setAlter(alter);
        setBargeld(bargeld);
        setFuererschein(fuererschein);
    }

    @Override
    public String toString() {
        return "Person " +
                "\nVorname " + vorname +
                "\nNachname " + nachname +
                "\nAlter " + alter +
                "\nBargeld " + bargeld +
                "\nFürerschein " + (fuererschein ? "Ja": "Nein");
    }

    public void printPerson(){
        System.out.println(toString());
    }

    public boolean zahlen(int betrag){
        if (betrag <= bargeld){
            bargeld -= betrag;
            return true;
        }return false;
    }
}
