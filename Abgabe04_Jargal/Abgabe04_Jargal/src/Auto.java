public class Auto {
    private String marke;
    private boolean automatik, elektrisch;
    private int bauJahr, sitzPlaetze, kilometerStand;
    private boolean baujahrGesetzt = false; //baujahr nur einmal gesetzt wird

    // Standardkonstruktor
    public Auto() {

    }

    // Konstruktor mit 6 Parametern
    public Auto(String marke, int bauJahr, boolean automatik, boolean elektrisch, int sitzPlaetze, int kilometerStand) {
        setMarke(marke);
        setBaujahr(bauJahr);
        setAutomatik(automatik);
        setElektrisch(elektrisch);
        setSitzplaetze(sitzPlaetze);
        setKilometerstand(kilometerStand);
    }

    // Getter-Methoden
    public String getMarke() {
        return marke;
    }

    public int getBauJahr() {
        return bauJahr;
    }

    public boolean getAutomatik() {
        return automatik;
    }

    public boolean getElektrisch() {
        return elektrisch;
    }

    public int getSitzPlaetze() {
        return sitzPlaetze;
    }

    public int getKilometerStand() {
        return kilometerStand;
    }

    // Setter-Methoden
    public void setMarke(String marke) {
        this.marke = marke;
    }

    public void setBaujahr(int bauJahr) {
        if (!baujahrGesetzt) {
            if (bauJahr > 1950) {
                this.bauJahr = bauJahr;
                this.baujahrGesetzt = true;
            } else {
                System.out.println("Fehler:Das Baujahr muss nach 1950 liegen. Es wurde der Default-Wert 2000 gesetzt.");
                this.bauJahr = 2000;
                this.baujahrGesetzt = true;
            }
        } else {
            System.out.println("Fehler: Das Baujahr kann nur einmal gesetzt werden.");
        }
    }

    public void setAutomatik(boolean automatik) {
        this.automatik = automatik;
    }

    public void setElektrisch(boolean elektrisch) {
        this.elektrisch = elektrisch;
        if (elektrisch) {
            this.automatik = true; // Elektroautos sind immer automatisch
        }
    }

    public void setSitzplaetze(int sitzPlaetze) {
        if (sitzPlaetze >= 2 && sitzPlaetze <= 9) {
            this.sitzPlaetze = sitzPlaetze;
        } else {
            System.out.println("Fehler: Es wurde der Default-Wert 5 gesetzt.");
            this.sitzPlaetze = 5;
        }
    }

    public void setKilometerstand(int kilometerStand) {
        if (kilometerStand >= 0) {
            this.kilometerStand = kilometerStand;
        } else {
            System.out.println("Fehler: Der Wert muss mindestens 0 sein. Er wurde auf 0 gesetzt.");
            this.kilometerStand = 0;
        }
    }

    // berechneAlter(): Alter im Jahr 2025
    public int berechneAlter() {
        int aktuellesJahr = 2025;
        if (bauJahr > aktuellesJahr) {
            System.out.println("Warnung: Es wird ein Alter von 0 Jahren angenommen.");
            return 0;
        }
        return aktuellesJahr - bauJahr;
    }

    // berechneAlter(jahr: int): Alter in einem gegebenen Jahr
    public int berechneAlter(int jahr) {
        if (bauJahr > jahr) {
            System.out.println("Warnung: Das Baujahr liegt nach dem angegebenen Jahr. Es wird ein Alter von 0 Jahren angenommen.");
            return 0;
        }
        return jahr - bauJahr;
    }

    // fahren(): Erhöht den Kilometerstand um 10 km
    public void fahren() {
        this.kilometerStand += 10;
    }

    // fahren(strecke: int): Erhöht den Kilometerstand um die gegebene Strecke
    public void fahren(int strecke) {
        if (strecke > 0) {
            this.kilometerStand += strecke;
        } else {
            System.out.println("Fehler: Ungültige Fahrtstrecke. Die Strecke muss positiv sein.");
        }
    }

    // printInfo()
    public void printInfo() {
        System.out.println("##########################");
        System.out.println("## Auto Marke: " + marke);
        System.out.println("## Baujahr: " + bauJahr);
        System.out.println("## Automatik: " + automatik);
        System.out.println("## Elektrisch: " + elektrisch);
        System.out.println("## Sitzplätze: " + sitzPlaetze);
        System.out.println("## Kilometerstand: " + kilometerStand + " km");
        System.out.println("##########################");
    }
}