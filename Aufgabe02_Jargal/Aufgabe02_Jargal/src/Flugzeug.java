// Aufgabe 02
public class Flugzeug {
    //Eigenschaften der Klasse bzw. globale Variable
    private int duesen;
    private float spannweite;
    private String kennung;
    private int sitzplaezte;

    //    Standardkonstruktor

    public Flugzeug(){
        duesen = 4;
        spannweite = 80f;
        kennung = "A380";
        sitzplaezte = 853;
    }

    // Konstruktor mit Parametern
    public Flugzeug(int duesen, float spannweite, String kennung, int sitzplaezte){
       setDuesen(duesen);
       setSpannweite(spannweite);
       setKennung(kennung);
       setSitzplaezte(sitzplaezte);
    }

    public void setDuesen(int duesen){
        this.duesen = duesen;
    }
    public void setSpannweite(float spannweite){
        this.spannweite = spannweite;
    }
    public void setKennung(String kennung){
        this.kennung = kennung;
    }public void setSitzplaezte(int sitzplaezte){
        this.sitzplaezte = sitzplaezte;
    }

    public float getSpannweite() {
        return spannweite;
    }

    public int getDuesen() {
        return duesen;
    }

    public int getSitzplaezte() {
        return sitzplaezte;
    }

    public String getKennung() {
        return kennung;
    }

    public void print(){
        System.out.println("========== FLUGZEUG ==========");
        System.out.println("Kennung: " + kennung);
        System.out.println("Düsen: " + duesen);
        System.out.println("Spannweite: " + spannweite);
        System.out.println("Sitzplätze: " + sitzplaezte);

    }
}
