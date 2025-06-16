public class Notenpruefung {
//    Eigenschaften
    private int punkte;
//    Standard Konstruktor
    public Notenpruefung(){
        punkte = 75;
    }
//    Konstruktor mit Parametern
    public Notenpruefung(int punkte){
        setPunkte(punkte);
    }
//    Gitter-Methode


    public int getPunkte() {
        return punkte;
    }
//    Setter-Methode

    public void setPunkte(int punkte) {

        if (punkte >= 0 && punkte <= 100){
            this.punkte = punkte;
        }else {
            System.out.println("Fehler: Ungültige WERT");
        }
    }
//    pruefeNote-Methode
    public  void pruefeNote(){
        if (punkte >= 90 && punkte <= 100 ){
            System.out.println("Sehr gut");

        } else if (punkte >= 80 && punkte < 90) {
//            return "Gut";
            System.out.println("Gut");
        }else if (punkte >= 70 && punkte < 80) {
            System.out.println("Befriedigend");
//            return "Befriedigend";
        }else if (punkte >= 60 && punkte < 70) {
//            return "Genügend";
            System.out.println("Genügend");
        }else if (punkte >= 0 && punkte < 60) {
            System.out.println("Nicht Genügend");
//            return "Nicht Genügend";
        }
    }

}
