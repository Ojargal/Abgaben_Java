import java.util.Locale;

public class Schueler {
//    Eigenschaften
    private String name;
    private int schulstufe;
    private int note;
    private int anzahlSchuljahre;
    private String schule;

//    Standard Konstruktor
    public Schueler(){
        name = "Stefan Streber";
        schulstufe = 1;
        note = 3;
        anzahlSchuljahre = 0;
        schule = "Musterschule";
    }
//    Konstruktor mit Parametern

    public Schueler(String name, int schulstufe, int note, int anzahlSchuljahre, String schule) {
        setName(name);
        setNote(note);
        setSchulstufe(schulstufe);
        setAnzahlSchuljahre(anzahlSchuljahre);
        setSchule(schule);
    }
//    Setter-Methoden

    public void setName(String name) {
        this.name = name;
    }

    public void setSchulstufe(int schulstufe) {
        if  (schulstufe >= 1 && schulstufe <= 13){
            this.schulstufe = schulstufe;
        }
    }

    public void setNote(int note) {
        if (note >= 1 && note <= 5){
            this.note = note;
        }
    }

    public void setAnzahlSchuljahre(int anzahlSchuljahre){
        if (anzahlSchuljahre >= 0){
            this.anzahlSchuljahre = anzahlSchuljahre;
        }else {
            System.out.println("Fehler: Anzahl Schuljahre muss größer-gleich 0 sein. Wert " + anzahlSchuljahre + " ist ungültig.");
        }
    }

    public void setSchule(String schule) {
        this.schule = schule;
    }

//    Getter-Methoden

    public String getName() {
        return name;
    }

    public int getSchulstufe() {
        return schulstufe;
    }

    public int getNote() {
        return note;
    }

    public int getAnzahlSchuljahre() {
        return anzahlSchuljahre;
    }

    public String getSchule() {
        return schule;
    }

//    print

    public void print(){
        System.out.println("Name: " + name);
        System.out.println("Schulstufe:" + schulstufe);
        System.out.println("Note: " + note);
        System.out.println("Anzahlschuljahre: " + anzahlSchuljahre);
        System.out.println("Schule: " + schule);
    }

    public void aufsteigenOderWiederholen() {
        if (note != 5){
            if (schulstufe < 13){
                setSchulstufe(schulstufe + 1);
                setAnzahlSchuljahre(anzahlSchuljahre + 1);
                System.out.println(name + " hat keinen 5er und steigt in die " + schulstufe + " Klasse auf.");
            } else {
                setAnzahlSchuljahre(anzahlSchuljahre + 1);
                System.out.println(name + " hat die 13. Schulstufe erreicht und schließt die Schule ab.");
            }
        }else {
            setAnzahlSchuljahre(anzahlSchuljahre + 1);
            System.out.println(name + " hat einen 5er und muss die " + schulstufe + ". Klasse wiederholen. ");
        }
        System.out.println("------------------------\n");
    }

    public void lernen(){
        double zufallszahl = Math.random();
        if (zufallszahl <= 0.5){
            if (note > 1){
                setNote(note - 1);
                System.out.println(name + "hat fleißig gelernt! Die Note hat sich auf " + note + " verbessert.");
            }else System.out.println(name + " ist bereits Einser-Schüler! Die Note kann nicht weiter verbessert werden.");
        }else {
            if (note < 5){
                setNote(note + 1);
                System.out.println(name + " hatte wohl einen schlechten Tag. Die Note hat sich auf " + note + " verschlechtert.");
            }else {
                System.out.println(name + " hat bereits einen Fünfer. Die Note kann nicht weiter verschlechtert werden.");
            }
            System.out.println("-------------------------------------\n");
        }
    }



}
