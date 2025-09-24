public class USBStick {
    private String kennzeichen;
    private int groesseInMB;
    private int verkaufsPreisUSB;

    public USBStick(String kennzeichen, int groesseInMB, int verkaufsPreisUSB) {
        setKennzeichen(kennzeichen);
        setGroesseInMB(groesseInMB);
        setVerkaufsPreisUSB(verkaufsPreisUSB);
    }

    // Setter-Methoden mit Fehlerausgaben
    public void setKennzeichen(String kennzeichen) {
        if (kennzeichen == null || kennzeichen.trim().isEmpty()) {
            System.out.println("Fehler: Kennzeichen darf nicht leer sein!");
            this.kennzeichen = "Default";
        } else {
            this.kennzeichen = kennzeichen;
        }
    }

    public void setGroesseInMB(int groesseInMB) {
        if (groesseInMB < 512) {
            System.out.println("Fehler: Größe muss mindestens 512 MB sein!");
            this.groesseInMB = 512;
        } else {
            this.groesseInMB = groesseInMB;
        }
    }

    public void setVerkaufsPreisUSB(int verkaufsPreisUSB) {
        if (verkaufsPreisUSB < 5 || verkaufsPreisUSB > 100) {
            System.out.println("Fehler: Verkaufspreis muss zwischen 5 und 100 liegen!");
            this.verkaufsPreisUSB = 5;
        } else {
            this.verkaufsPreisUSB = verkaufsPreisUSB;
        }
    }

    // Getter-Methoden
    public String getKennzeichen() { return kennzeichen; }
    public int getGroesseInMB() { return groesseInMB; }
    public int getVerkaufsPreisUSB() { return verkaufsPreisUSB; }

    public void printUSBStick() {
        System.out.println("USB-Stick:");
        System.out.println("  Kennzeichen: " + kennzeichen);
        System.out.println("  Größe: " + groesseInMB + " MB");
        System.out.println("  Verkaufspreis: " + verkaufsPreisUSB + "€");
    }
}