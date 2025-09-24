import com.sun.jdi.event.MethodEntryEvent;

/**
 * Represents a coffee machine with the ability to brew different types of coffee.
 * the machine can be turned on/off, filled with water and coffee beans,
 * and can prepate espesso, latte, or cappuccino.
 */
public class Kaffeemaschine {
    //    Eigenschaften
    private boolean eingeschaltet;
    private double wasserfuellstand;
    private double wasserKapazitaet;
    private int bohnenFuellstand;
    private int bohnenKapazitaet;

    /**
     * Default contructor initializes a coffee machine with:
     * -power off state
     * - Water capacity: 2000.0 ml
     * - Bean capacity: 1000 g
     */
// Standard Konstruktor
    public Kaffeemaschine() {
        eingeschaltet = false;
        wasserKapazitaet = 2000.0d;
        wasserfuellstand = 0.0d;
        bohnenKapazitaet = 1000;
        bohnenFuellstand = 0;
    }
//    Getter-Methoden

    /**
     * Checks if the machine is powered on.
     * @return true if powered on, false otherwise
     */
    public boolean isEingeschaltet() {
        return eingeschaltet;
    }

    /**
     * Gets the current water level.
     * @return current water level
     */
    public double getWasserfuellstand() {
        return wasserfuellstand;
    }

    /**
     * Gets the water tank capacity.
     * @return maximum water capacity
     */
    public double getWasserKapazitaet() {
        return wasserKapazitaet;
    }

    /**
     * Gets the current bean amount.
     * @return current bean amount
     */
    public int getBohnenFuellstand() {
        return bohnenFuellstand;
    }

    /**
     * Gets the bean container capacity.
     * @return maximum bean capacity
     */
    public int getBohnenKapazitaet() {
        return bohnenKapazitaet;
    }

    // Setter-Methoden
    /**
     * Sets the power state of the machine.
     * @param eingeschaltet true to turn on, false to turn off
     */
    public void setEingeschaltet(boolean eingeschaltet) {
        this.eingeschaltet = eingeschaltet;
    }

    /**
     * Sets the water level in the tank.
     * @param wasserfuellstand new water level in milliliters
     * @throws IllegalArgumentException if value is outside valid range (0 - wasserKapazitaet)
     */
    public void setWasserfuellstand(double wasserfuellstand) {

        if (wasserfuellstand >= 0 && wasserfuellstand <= wasserKapazitaet) {
            this.wasserfuellstand = wasserfuellstand;
        } else System.out.println("[FEHLER] Wasserfüllstand: Ungültiger Wert (" + wasserfuellstand + " ml). " +
                "Muss zwischen 0 und " + wasserKapazitaet + " ml liegen.");
    }

    /**
     * Sets the water tank capacity.
     * @param wasserKapazitaet new water capacity in milliliters
     * @throws IllegalArgumentException if value is outside valid range (500 - 2000 ml)
     */
    public void setWasserKapazitaet(double wasserKapazitaet) {
        if (wasserKapazitaet >= 500 && wasserKapazitaet <= 2000) {
            this.wasserKapazitaet = wasserKapazitaet;
        } else System.out.println("[FEHLER] Wasserkapazität: Ungültiger Wert (" + wasserKapazitaet + " ml). " +
                "Muss zwischen 500 und 2000 ml liegen.");
    }
    /**
     * Sets the current bean amount.
     * @param bohnenFuellstand new bean amount in grams
     * @throws IllegalArgumentException if value is outside valid range (0 - bohnenKapazitaet)
     */
    public void setBohnenFuellstand(int bohnenFuellstand) {
        if (bohnenFuellstand >= 0 && bohnenFuellstand <= bohnenKapazitaet) {
            this.bohnenFuellstand = bohnenFuellstand;
        } else System.out.println("[FEHLER] Bohnenfüllstand: Ungültiger Wert (" + bohnenFuellstand + " g). " +
                "Muss zwischen 0 und " + bohnenKapazitaet + " g liegen.");
    }
    /**
     * Sets the bean container capacity.
     * @param bohnenKapazitaet new bean capacity in grams
     * @throws IllegalArgumentException if value is outside valid range (100 - 1000 g)
     */
    public void setBohnenKapazitaet(int bohnenKapazitaet) {
        if (bohnenKapazitaet >= 100 && bohnenKapazitaet <= 1000) {
            this.bohnenKapazitaet = bohnenKapazitaet;
        } else System.out.println("[FEHLER] Bohnenkapazität: Ungültiger Wert (" + bohnenKapazitaet + " g). " +
                "Muss zwischen 100 und 1000 g liegen.");
    }


    //    Konstruktor mit Parametern

    /**
     * Parameterized constructor for creating a customized coffee machine.
     * @param eingeschaltet initial power state
     * @param wasserfuellstand initial water level
     * @param wasserKapazitaet water tank capacity
     * @param bohnenFuellstand initial bean amount
     * @param bohnenKapazitaet bean container capacity
     */
    public Kaffeemaschine(boolean eingeschaltet, double wasserfuellstand, double wasserKapazitaet, int bohnenFuellstand, int bohnenKapazitaet) {
        setEingeschaltet(eingeschaltet);
        setBohnenKapazitaet(bohnenKapazitaet);
        setBohnenFuellstand(bohnenFuellstand);
        setWasserKapazitaet(wasserKapazitaet);
        setWasserfuellstand(wasserfuellstand);

    }

    //  Einschalten-Methode
    /**
     * Turns the coffee machine on.
     * Prints status message if already powered on.
     */
    public void einschalten() {
        if (!eingeschaltet) {
            eingeschaltet = true;
            System.out.println("Kaffeemaschine wurde eingeschaltet.");
        } else System.out.println("[HINWEIS] Kaffeemaschine ist bereits eingeschaltet.");
    }

    /**
     * Turns the coffee machine off.
     * Prints status message if already powered off.
     */
    public void ausschalten() {
        if (eingeschaltet) {
            eingeschaltet = false;
            System.out.println("Kaffeemaschine wurde ausgeschaltet.");
        } else System.out.println("[HINWEIS] Kaffeemaschine ist bereits ausgeschaltet.");
    }

    //WasserAuffuellung - Methode
    /**
     * Fills water into the machine's tank.
     * @param menge amount of water to add in milliliters
     */
    public void wasserAuffuellen(double menge) {

        double wasserNewFuellStand = menge + wasserfuellstand;
        if (wasserNewFuellStand > wasserKapazitaet) {
            double notigeWassermenge = wasserKapazitaet - wasserfuellstand;
            System.out.println("[FEHLER] Wasserauffüllung: Zu viel Wasser (" + menge + " ml). " +
                    "Es werden nur " + notigeWassermenge + " ml benötigt.");
        } else {
            if (wasserNewFuellStand == wasserKapazitaet) {
                System.out.println("[INFO] Wassertank ist jetzt voll (" + wasserKapazitaet + " ml).");
            } else {
                this.wasserfuellstand = wasserNewFuellStand;
                System.out.println("[ERFOLG] Wasser wurde aufgefüllt. Aktueller Stand: " +
                        wasserfuellstand + " ml / " + wasserKapazitaet + " ml.");
            }
        }
    }


    //    bohnenAuffuellen-Methode
    /**
     * Fills coffee beans into the machine's container.
     * @param menge amount of beans to add in grams
     */
    public void bohnenAuffuellen(int menge) {
        int bohnenNewFuellStand = bohnenFuellstand + menge;
        if (bohnenNewFuellStand > bohnenKapazitaet) {
            int notwendigeBohnenMenge = bohnenKapazitaet - bohnenFuellstand;
            System.out.println("[FEHLER] Bohnenauffüllung: Zu viele Bohnen (" + menge + " g). " +
                    "Es werden nur " + notwendigeBohnenMenge + " g benötigt.");
        } else {
            if (bohnenNewFuellStand == bohnenKapazitaet) {
                System.out.println("[INFO] Bohnentank ist jetzt voll (" + bohnenKapazitaet + " g).");
            } else {
                this.bohnenFuellstand = bohnenNewFuellStand;
                System.out.println("[ERFOLG] Bohnen wurden aufgefüllt. Aktueller Stand: " +
                        bohnenFuellstand + " g / " + bohnenKapazitaet + " g.");

            }
        }
    }

    //    kochen-Methode
    /**
     * Brews the selected coffee type if sufficient resources are available.
     * Requires machine to be powered on and minimum 200ml water available.
     * @param art coffee type ("Espresso", "Latte", or "Cappuccino", case-insensitive)
     */
    public void kochen(String art) {
        // Minsestwassermenge für den Betrieb
        final int MIN_BETRIEBS_WASSER = 200;
        if (wasserfuellstand < MIN_BETRIEBS_WASSER){
            System.out.println("FEHLER: Minsestens " + MIN_BETRIEBS_WASSER + "ml Wasser benötigt!");
            return;
        }
        // Konstanten für die benötigten Mengen
        final int ESPRESSO_WASSER = 30, ESPRESSO_BOHNEN = 10;
        final int LATTE_WASSER = 100, LATTE_BOHNEN = 20;
        final int CAPPUCCINO_WASSER = 120, CAPPUCCINO_BOHNEN = 25;

        // Getränkekonfiguration festlegen
        int benoetigtesWasser = 0;
        int benoetigteBohnen = 0;
        String getraenkName = "";

        //Case-insensitive Vergleich mit equalIgnoreCase()
        if (art.equalsIgnoreCase("Espresso")){
            benoetigtesWasser = ESPRESSO_WASSER;
            benoetigteBohnen = ESPRESSO_BOHNEN;
            getraenkName = "Espresso";
        } else if (art.equalsIgnoreCase("Latte")){
            benoetigtesWasser = LATTE_WASSER;
            benoetigteBohnen = LATTE_BOHNEN;
            getraenkName = "Latte";
        } else if (art.equalsIgnoreCase("Cappuccino")){
            benoetigtesWasser = CAPPUCCINO_WASSER;
            benoetigteBohnen = CAPPUCCINO_BOHNEN;
            getraenkName = "Cappuccino";
        }else {
            System.out.println("Ungültige Auswahl! Gültige Optionen: Espresso, Latte, Cappuccino");
            return;
        }

        // Prüfen, ob genug Ressourcen vorhanden sind
        if (!hatGenugRessourcen(benoetigtesWasser, benoetigteBohnen)) {
            return; // Abbruch, falls nicht genug da ist
        }

        // Kaffee zubereiten
        verbraucheRessourcen(benoetigtesWasser, benoetigteBohnen);
        System.out.println(getraenkName + " wird zubereitet. Guten Appetit!");

    }

    // **Hilfsmethode 1:** Prüft, ob genug Wasser & Bohnen vorhanden sind
    /**
     * Checks if sufficient water and beans are available.
     * @param wasser required water amount in ml
     * @param bohnen required bean amount in grams
     * @return true if resources are sufficient, false otherwise
     */
    private boolean hatGenugRessourcen(int wasser, int bohnen) {
        if (wasserfuellstand < wasser) {
            System.out.println("FEHLER: NICHT GENUG WASSER IM TANK!");
            return false;
        }
        if (bohnenFuellstand < bohnen) {
            System.out.println("FEHLER: BITTE BOHNENTANK AUFFÜLLEN!");
            return false;
        }
        return true;
    }

    // **Hilfsmethode 2:** Verbraucht Wasser & Bohnen
    /**
     * Consumes the specified amounts of water and beans.
     * @param wasser water amount to consume in ml
     * @param bohnen bean amount to consume in grams
     */
    private void verbraucheRessourcen(int wasser, int bohnen) {
        wasserfuellstand -= wasser;
        bohnenFuellstand -= bohnen;
    }
}


