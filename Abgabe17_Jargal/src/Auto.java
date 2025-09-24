import java.util.regex.Pattern;

public class Auto {
    private String kennzeichen, marke, modell, farbe;

//    Konstruktor mit 4 Prametern
    public Auto(String kennzeichen, String marke, String modell, String farbe){
        setKennzeichen(kennzeichen);
        setMarke(marke);
        setModell(modell);
        setFarbe(farbe);
    }

//    Setter mit Validierung

    public void setKennzeichen(String kennzeichen) {
        if (kennzeichen == null || kennzeichen.trim().isEmpty()) {
            throw new IllegalArgumentException("Kennzeichen darf nicht null oder leer sein");
        }
        // Überprüfung mit Regular Expression: mindestens 2 Buchstaben, eine Zahl, erstes Zeichen Buchstabe
        String regex = "^(?=.*[A-Za-z].*[A-Za-z])(?=.*\\d).*$";
        if (!Pattern.matches(regex, kennzeichen)){
            throw new IllegalArgumentException("Kennzeichen muss mindestens 2 Buchstaben und eine Zahl enthalten, und mit einem Buchstaben beginnen");
        }
        this.kennzeichen = kennzeichen.trim();
    }

    public void setMarke(String marke) {
        if (marke == null || marke.trim().isEmpty()) {
            throw new IllegalArgumentException("Marke darf nicht null oder leer sein");
        }
        this.marke = marke;
    }

    public void setModell(String modell) {
        if (modell == null || modell.trim().isEmpty()) {
            throw new IllegalArgumentException("Modell darf nicht null oder leer sein");
        }
        this.modell = modell;
    }

    public void setFarbe(String farbe) {
        if (farbe == null || farbe.trim().isEmpty()) {
            throw new IllegalArgumentException("Farbe darf nicht null oder leer sein");
        }
        this.farbe = farbe;
    }

//    Getter

    public String getKennzeichen() {
        return kennzeichen;
    }

    public String getMarke() {
        return marke;
    }

    public String getModell() {
        return modell;
    }

    public String getFarbe() {
        return farbe;
    }

    @Override
    public String toString() {

        return String.format(
                "Kennzeichen: %s%nMarke: %s%nModell: %s%nFarbe: %s%n",
                kennzeichen, marke, modell, farbe);

    }
}
