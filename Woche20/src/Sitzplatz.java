public class Sitzplatz {
    private String sitzplatzNr;
    private String sitzplatzTyp;
    private boolean verfuegbar;

    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String RESET = "\033[0m";  // Text Reset

    public Sitzplatz(String sitzplatzTyp) {
        setSitzplatzTyp(sitzplatzTyp);
    }

    public boolean reservieren() {
        if(verfuegbar) {
            verfuegbar = false;
            return true;
        }
        return false;
    }

    public void stornieren() {
        verfuegbar = true;
    }

    public String getSitzplatzNr() {
        return sitzplatzNr;
    }

    public void setSitzplatzNr(String sitzplatzNr) {
        this.sitzplatzNr = sitzplatzNr;
    }

    public String getSitzplatzTyp() {
        return sitzplatzTyp;
    }

    public void setSitzplatzTyp(String sitzplatzTyp) {
        if(sitzplatzTyp != null && (sitzplatzTyp.equalsIgnoreCase("VIP") || sitzplatzTyp.equalsIgnoreCase("Standard"))) {
            this.sitzplatzTyp = sitzplatzTyp;
        } else {
            this.sitzplatzTyp = "Standard";
            fehlermeldung("Sitzplatz Typ");
        }
    }

    public boolean isVerfuegbar() {
        return verfuegbar;
    }

    public void setVerfuegbar(boolean verfuegbar) {
        this.verfuegbar = verfuegbar;
    }

    private void fehlermeldung(String beschreibung) {
        System.out.println(RED_BOLD + "Fehler: " + beschreibung + " ungültig." + RESET);
    }

    @Override
    public String toString() {
        return "Sitzplatz{" +
                "sitzplatzNr='" + sitzplatzNr + '\'' +
                ", sitzplatzTyp='" + sitzplatzTyp + '\'' +
                ", verfuegbar=" + verfuegbar +
                '}';
    }
}
