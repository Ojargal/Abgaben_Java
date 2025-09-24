import java.util.Arrays;

public class Raum {
    private Sitzplatz[][] sitzplaetze;
    private String raumNr;

    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String RESET = "\033[0m";  // Text Reset

    public Raum(String raumNr) {
        setRaumNr(raumNr);
        sitzplaetze = new Sitzplatz[5][3];
    }

    public Sitzplatz sucheSitzplatzNr(String sitzplatzNr) {
        //Zeile und Spalte aus der SitzplatzNr auslesen
        if (sitzplatzNr != null && !sitzplatzNr.isBlank() && sitzplatzNr.length() == 3) {
            int i = Integer.parseInt(sitzplatzNr.substring(1, 2));
            int j = Integer.parseInt(sitzplatzNr.substring(2));

            if (checkSitz(i, j)) {
                return sitzplaetze[i][j];
            }
        }
        fehlermeldung("Sitzplatz Nr.");
        return null;
    }

    private int[] getIndizes(String sitzplatzNr) {
        int[] indizes = new int[2];
        if (sitzplatzNr != null && !sitzplatzNr.isBlank() && sitzplatzNr.length() == 3) {
            int i = Integer.parseInt(sitzplatzNr.substring(1, 2));
            int j = Integer.parseInt(sitzplatzNr.substring(2));

            if (checkSitz(i, j)) {
                indizes[0] = i;
                indizes[1] = j;
                return indizes;
            }
        }
        return null;
    }

    public void addSitzplatz(Sitzplatz s) {
        for (int i = 0; i < sitzplaetze.length; i++) {
            for (int j = 0; j < sitzplaetze[i].length; j++) {
                if (sitzplaetze[i][j] == null) {
                    sitzplaetze[i][j] = s;
                    s.setSitzplatzNr(raumNr.substring(0, 1) + i + j);
                    return;
                }
            }
        }
        System.out.println("Raum voll.");
    }

    private boolean checkSitz(int i, int j) {
        return i >= 0 && i < sitzplaetze.length && j >= 0 && j < sitzplaetze[i].length;
    }

    public Sitzplatz entferneSitzplatz(String sitzplatzNr) {
        //1. Möglichkeit
        //Zu entfernenden Sitzplatz merken
        Sitzplatz entfernen = sucheSitzplatzNr(sitzplatzNr);
        if(entfernen != null) {
            // Indizes einzeln auslesen
            int[] indizes = getIndizes(sitzplatzNr);
            //Sitzplatz entfernen
            sitzplaetze[indizes[0]][indizes[1]] = null;
            return entfernen;
        }
        return null;

        //2. Möglichkeit
//        for(int i = 0; i < sitzplaetze.length; i++) {
//            for(int j = 0; j < sitzplaetze[i].length; j++) {
//                if(sitzplaetze[i][j] != null && sitzplaetze[i][j].getSitzplatzNr().equals(sitzplatzNr)) {
//                    Sitzplatz entfernen = sitzplaetze[i][j];
//                    sitzplaetze[i][j] = null;
//                    return entfernen;
//                }
//            }
//        }
//        return null;
    }

    public Sitzplatz[] sucheTyp(String typ) {
        Sitzplatz[] typPlaetze = new Sitzplatz[sitzplaetze.length * sitzplaetze[0].length];
        int anzGefundenePlaetze = 0;

        for (Sitzplatz[] sitzplatzs : sitzplaetze) {
            for (Sitzplatz sitzplatz : sitzplatzs) {
                if (sitzplatz != null && sitzplatz.getSitzplatzTyp().equals(typ)) {
                    typPlaetze[anzGefundenePlaetze] = sitzplatz;
                    anzGefundenePlaetze++;
                }
            }
        }

        Sitzplatz[] result = new Sitzplatz[anzGefundenePlaetze];
        System.arraycopy(typPlaetze, 0, result, 0, anzGefundenePlaetze);
        return result;
    }

    public String getRaumNr() {
        return raumNr;
    }

    public void setRaumNr(String raumNr) {
        //1 Großbuchstabe als erstes Zeichen, danach eine Zahl.
        if (raumNr != null && raumNr.substring(0, 1).matches(".*[A-Z].*") && raumNr.substring(1).matches(".*\\d+.*")) {
            this.raumNr = raumNr;
        } else {
            fehlermeldung("Raum Nr.");
        }
    }

    public Sitzplatz[][] getSitzplaetze() {
        return sitzplaetze;
    }

    private void fehlermeldung(String beschreibung) {
        System.out.println(RED_BOLD + "Fehler: " + beschreibung + " ungültig." + RESET);
    }

    @Override
    public String toString() {
        return "Raum{" +
                "sitzplaetze=" + Arrays.deepToString(sitzplaetze) +
                ", raumNr='" + raumNr + '\'' +
                '}';
    }
}
