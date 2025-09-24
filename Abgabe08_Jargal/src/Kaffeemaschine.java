import com.sun.jdi.event.MethodEntryEvent;

public class Kaffeemaschine {
    //    Eigenschaften
    private boolean eingeschaltet;
    private double wasserfuellstand;
    private double wasserKapazitaet;
    private int bohnenFuellstand;
    private int bohnenKapazitaet;

    public Kaffeemaschine() {
        eingeschaltet = false;
        wasserKapazitaet = 2000.0d;
        wasserfuellstand = 0.0d;
        bohnenKapazitaet = 1000;
        bohnenFuellstand = 0;
    }
//    Getter-Methoden


    public boolean isEingeschaltet() {
        return eingeschaltet;
    }

    public double getWasserfuellstand() {
        return wasserfuellstand;
    }

    public double getWasserKapazitaet() {
        return wasserKapazitaet;
    }

    public int getBohnenFuellstand() {
        return bohnenFuellstand;
    }

    public int getBohnenKapazitaet() {
        return bohnenKapazitaet;
    }

    // Setter-Methoden
    public void setEingeschaltet(boolean eingeschaltet) {
        this.eingeschaltet = eingeschaltet;
    }

    public void setWasserfuellstand(double wasserfuellstand) {

        if (wasserfuellstand >= 0 && wasserfuellstand <= wasserKapazitaet) {
            this.wasserfuellstand = wasserfuellstand;
        } else System.out.println("[FEHLER] Wasserfüllstand: Ungültiger Wert (" + wasserfuellstand + " ml). " +
                "Muss zwischen 0 und " + wasserKapazitaet + " ml liegen.");
    }

    public void setWasserKapazitaet(double wasserKapazitaet) {
        if (wasserKapazitaet >= 500 && wasserKapazitaet <= 2000) {
            this.wasserKapazitaet = wasserKapazitaet;
        } else System.out.println("[FEHLER] Wasserkapazität: Ungültiger Wert (" + wasserKapazitaet + " ml). " +
                "Muss zwischen 500 und 2000 ml liegen.");
    }

    public void setBohnenFuellstand(int bohnenFuellstand) {
        if (bohnenFuellstand >= 0 && bohnenFuellstand <= bohnenKapazitaet) {
            this.bohnenFuellstand = bohnenFuellstand;
        } else System.out.println("[FEHLER] Bohnenfüllstand: Ungültiger Wert (" + bohnenFuellstand + " g). " +
                "Muss zwischen 0 und " + bohnenKapazitaet + " g liegen.");
    }

    public void setBohnenKapazitaet(int bohnenKapazitaet) {
        if (bohnenKapazitaet >= 100 && bohnenKapazitaet <= 1000) {
            this.bohnenKapazitaet = bohnenKapazitaet;
        } else System.out.println("[FEHLER] Bohnenkapazität: Ungültiger Wert (" + bohnenKapazitaet + " g). " +
                "Muss zwischen 100 und 1000 g liegen.");
    }


    //    Konstruktor mit Parametern

    public Kaffeemaschine(boolean eingeschaltet, double wasserfuellstand, double wasserKapazitaet, int bohnenFuellstand, int bohnenKapazitaet) {
        setEingeschaltet(eingeschaltet);
        setBohnenKapazitaet(bohnenKapazitaet);
        setBohnenFuellstand(bohnenFuellstand);
        setWasserfuellstand(wasserfuellstand);
        setWasserKapazitaet(wasserKapazitaet);

    }

    //  Einschalten-Methode
    public void einschalten() {
        if (!eingeschaltet) {
            eingeschaltet = true;
            System.out.println("Kaffeemaschine wurde eingeschaltet.");
        } else System.out.println("[HINWEIS] Kaffeemaschine ist bereits eingeschaltet.");
    }

    public void ausschalten() {
        if (eingeschaltet) {
            eingeschaltet = false;
            System.out.println("Kaffeemaschine wurde ausgeschaltet.");
        } else System.out.println("[HINWEIS] Kaffeemaschine ist bereits ausgeschaltet.");
    }

    //WasserAuffuellung - Methode
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
    public void kochen(int art) {
        switch (art) {
            case 1:
                if (wasserfuellstand >= 30) {

                    if (bohnenFuellstand >= 10) {
                        wasserfuellstand -= 30;
                        bohnenFuellstand -= 10;
                        System.out.println("Espresso");
                    } else {
                        System.out.println("Fehler: BITTE BOHNENTANK AUFFÜLLEN");
                    }

                } else {
                    System.out.println("FEHLER: KEINE BENOTIGTE WASSER IM TANK!!!");
                }
                break;
            case 2:
                if (wasserfuellstand >= 100) {

                    if (bohnenFuellstand >= 20) {
                        wasserfuellstand -= 100;
                        bohnenFuellstand -= 20;
                        System.out.println("Latte");
                    } else {
                        System.out.println("Fehler: BITTE BOHNENTANK AUFFÜLLEN");
                    }

                } else {
                    System.out.println("FEHLER: KEINE BENOTIGTE WASSER IM TANK!!!");
                }
                break;
            case 3:
                if (wasserfuellstand >= 120) {

                    if (bohnenFuellstand >= 25) {
                        wasserfuellstand -= 120;
                        bohnenFuellstand -= 25;
                        System.out.println("Capuccino");
                    } else {
                        System.out.println("Fehler: BITTE BOHNENTANK AUFFÜLLEN");
                    }

                } else {
                    System.out.println("FEHLER: KEINE BENOTIGTE WASSER IM TANK!!!");
                }
                break;


        }
    }
}


