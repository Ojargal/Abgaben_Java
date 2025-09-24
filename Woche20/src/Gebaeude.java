import java.util.Arrays;

public class Gebaeude {
    private Raum[][] raeume;
    private int anzRaeume;

    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String RESET = "\033[0m";  // Text Reset

    public Gebaeude() {
        raeume = new Raum[3][5];
    }

    private boolean checkStellplatz(int geschoss, int stellplatz) {
        return geschoss >= 0 && geschoss < raeume.length && stellplatz >= 0 && stellplatz < raeume[geschoss].length;
    }

    public void addRaum(int geschoss, int stellplatz, String raumNr) {
        if(checkStellplatz(geschoss, stellplatz) && raeume[geschoss][stellplatz] == null) {
            raeume[geschoss][stellplatz] = new Raum(raumNr);
            anzRaeume++;
        } else {
            fehlermeldung("Geschoss, Stellplatz (addRaum - Gebäude)");
        }
    }

    public void addSitzplatz(Sitzplatz s, int geschoss, int stellplatz) {
        if(checkStellplatz(geschoss, stellplatz) && raeume[geschoss][stellplatz] != null) {
            raeume[geschoss][stellplatz].addSitzplatz(s);
        } else {
            fehlermeldung("Geschoss, Stellplatz (addSitzplatz - Gebäude)");
        }
    }

    public void moveRaum(int geschoss, int stellplatz, int zielGeschoss, int zielStellplatz) {
        if(checkStellplatz(geschoss, stellplatz) && checkStellplatz(zielGeschoss, zielStellplatz) &&
                raeume[geschoss][stellplatz] != null && raeume[zielGeschoss][zielStellplatz] == null) {
            raeume[zielGeschoss][zielStellplatz] = raeume[geschoss][stellplatz];
            raeume[geschoss][stellplatz] = null;
        } else {
            fehlermeldung("Geschoss, Stellplatz (moveRaum - Gebäude)");
        }
    }

    public Sitzplatz sucheSitzplatzNr(String sitzplatzNr) {
        for(Raum[] raums : raeume) {
            for(Raum r : raums) {
                if(r != null && r.sucheSitzplatzNr(sitzplatzNr) != null) {
                    return r.sucheSitzplatzNr(sitzplatzNr);
                }
            }
        }
        return null;
    }

    public Sitzplatz[] sucheTyp(String typ) {
        Sitzplatz[][] gefundePlaetze = new Sitzplatz[anzRaeume][];

        int n = 0;
        int anzGefundenePlaetze = 0;

        for(Raum[] raums : raeume) {
            for(Raum r : raums) {
                if(r != null) {
                    gefundePlaetze[n] = r.sucheTyp(typ);
                    anzGefundenePlaetze += r.sucheTyp(typ).length;
                    n++;
                }
            }
        }

        Sitzplatz[] result = new Sitzplatz[anzGefundenePlaetze];
        int i = 0;

        for(Sitzplatz[] plaetze : gefundePlaetze) {
            for(Sitzplatz s : plaetze) {
                result[i++] = s;
            }
        }
        return result;
    }

    private void fehlermeldung(String beschreibung) {
        System.out.println(RED_BOLD + "Fehler: " + beschreibung + " ungültig." + RESET);
    }

    @Override
    public String toString() {
        return "Gebaeude{" +
                "raeume=" + Arrays.deepToString(raeume) +
                ", anzRaeume=" + anzRaeume +
                '}';
    }
}
