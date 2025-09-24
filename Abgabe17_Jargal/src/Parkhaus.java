import java.util.Arrays;
import java.util.jar.JarOutputStream;

public class Parkhaus {
    //    Eigenschaften
    private final Auto[][] parkplaetze;
    private int zeilen;
    private int spalten;

    // Konstruktor
    public Parkhaus(int zeilen, int spalten) {
        setZeilen(zeilen);
        setSpalten(spalten);
        this.parkplaetze = new Auto[zeilen][spalten];
    }

    // Setter
    public void setZeilen(int zeilen) {
        if (zeilen <= 0) {
            throw new IllegalArgumentException("Spalten muss größer als 0 sein!");
        }
        this.zeilen = zeilen;
    }

    public void setSpalten(int spalten) {
        if (spalten <= 0) {
            throw new IllegalArgumentException("Zeilen muss größer als 0 sein!");
        }
        this.spalten = spalten;
    }

    // Getter
    public Auto[][] getParkplaetze() {
        return parkplaetze;
    }

    public int getZeilen() {
        return zeilen;
    }

    public int getSpalten() {
        return spalten;
    }

    //    Methode zum Parken eines Autos an einer bestimmten Position
    public boolean parkAuto(Auto auto, int zeile, int spalte) {
        if (!isParkplatzValid(zeile, spalte)) {
            throw new IllegalArgumentException("Ungültige Parkposition: " + zeile + ", " + spalte);
        }
        if (auto == null) {
            throw new IllegalArgumentException("Auto darf nicht null sein!");
        }
        if (isParkplatzFrei(zeile, spalte)) {
            parkplaetze[zeile][spalte] = auto;
            return true;
        }
        System.out.println("Fehler: Parkplatz ist bereits besetzt");
        return false;
    }

    public Auto removeAuto(int zeile, int spalte) {
        if (!isParkplatzValid(zeile, spalte)) {
            throw new IllegalArgumentException("Ungültige Parkposition: " + zeile + ", " + spalte);
        }
        if (!isParkplatzFrei(zeile, spalte)) {
            Auto entferntesAuto = parkplaetze[zeile][spalte];
            parkplaetze[zeile][spalte] = null;
            return entferntesAuto;
        }
        return null;
    }

    public Auto getAuto(int zeile, int spalte) {
        if (!isParkplatzValid(zeile, spalte)) {
            throw new IllegalArgumentException("Ungültige Parkposition: " + zeile + ", " + spalte);
        }

        if (!isParkplatzFrei(zeile, spalte)) {
            return parkplaetze[zeile][spalte];
        } else {
            System.out.print("Fehler: Kien Auto auf diesem Parkplatz.");
        }
        return null;
    }

    public boolean isParkplatzFrei(int zeile, int spalte) {
        if (!isParkplatzValid(zeile, spalte)) {
            throw new IllegalArgumentException("Ungültige Parkposition: " + zeile + ", " + spalte);
        }
        return parkplaetze[zeile][spalte] == null;
    }

    public int[] findFreeParkplaetze() {
        for (int i = 0; i < parkplaetze.length; i++) {
            for (int j = 0; j < parkplaetze[i].length; j++) {
                if (parkplaetze[i][j] == null) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1};
    }

    public int countFreeParkplaetze() {
        int count = 0;
        for (int i = 0; i < parkplaetze.length; i++) {
            for (int j = 0; j < parkplaetze[i].length; j++) {
                if (parkplaetze[i][j] == null) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countBesetzteParkplaetze() {
        int gesamtParkplaetze = parkplaetze.length * parkplaetze[0].length;
        return gesamtParkplaetze - countFreeParkplaetze();
    }

    public Auto[] listParkedAutos() {
        Auto[] autos = new Auto[countBesetzteParkplaetze()];
        int idx = 0;
        for (int i = 0; i < parkplaetze.length; i++) {
            for (int j = 0; j < parkplaetze[i].length; j++) {
                Auto a = parkplaetze[i][j];
                if (a!= null) {
                    autos[idx++] = a;
                }
            }
        }
        return autos;
    }

    public boolean isParkplatzValid(int zeile, int spalte) {
        if (zeile < 0 || zeile >= zeilen || spalte < 0 || spalte >= spalten) {
            return false;
        }
        return true;
    }

    public boolean moveAuto(int aktZeile, int aktSpalte, int neuZeile, int neuSpalte){
        Auto auto = removeAuto(aktZeile, aktSpalte);
        if (auto == null) return false;
        return parkAuto(auto, neuZeile, neuSpalte);
    }

    public int[] findAuto(String kennzeichen){
        for (int i = 0; i < parkplaetze.length; i++){
            for (int j = 0; j < parkplaetze[i].length; j++){
                if (parkplaetze[i][j].getKennzeichen().equals(kennzeichen)){
                    return new int[]{i, j};
                }
            }
        }
        System.out.printf("Error: Didn't find the 'Kennzeichen'!");
        return new int[]{-1};
    }

    public Auto[] clearParkhaus(){
        Auto[] autos = new Auto[countBesetzteParkplaetze()];
        int idx = 0;
        for (int i = 0; i < parkplaetze.length; i++){
            for (int j = 0; j < parkplaetze[i].length; j++){
                Auto a = parkplaetze[i][j];
                if ( a != null){
                    autos[idx++] = a;
                    parkplaetze[i][j] = null;
                }
            }
        }
        return autos;
    }

    public void printStatus() {
        System.out.println("Parkhaus Status:");
        for (int i = 0; i < parkplaetze.length; i++) {
            for (int j = 0; j < parkplaetze[i].length; j++) {
                String status = isParkplatzFrei(i, j) ? "[FREI]" : "[BESETZT] " + parkplaetze[i][j].getKennzeichen();
                System.out.print("(" + i + "," + j + "): " + status + "\t");
            }
            System.out.println();
        }
    }


}
