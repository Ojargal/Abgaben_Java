public class Sportwagen {
//    Eigenschaften
    private String marke;
    private int ps;
    private double verbrauch;
    private Person fahrer;
    private Person beifahrer;


    public Sportwagen(){

    }

    public Sportwagen(String marke, int ps, double verbrauch, Person fahrer, Person beifahrer) {
        setMarke(marke);
        setPs(ps);
        setVerbrauch(verbrauch);
        setFahrer(fahrer);
        setBeifahrer(beifahrer);
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        if (marke != null && !marke.isBlank()){
            this.marke = marke;
        }else {
            System.out.println("Fehler: Keine Marke (marke)");
        }
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        if (ps >= 100){
            this.ps = ps;
        }else {
            System.out.println("Fehler: Zu niedriger PS!");
        }
    }

    public double getVerbrauch() {
        return verbrauch;
    }

    public void setVerbrauch(double verbrauch) {
        if (verbrauch >= 8.0 && verbrauch <= 30){
            this.verbrauch = verbrauch;
        }else {
            System.out.println("Fehler: Verbrauch muss von 8 bis 30 sein! (verbrauch)");
        }
    }

    public Person getFahrer() {
        return fahrer;
    }

    public void setFahrer(Person fahrer) {
        if (fahrer != null && fahrer.isFuererschein() == true){
            this.fahrer = fahrer;
        }
        else {
            System.out.println("Fehler: Ungültige Wert (fahrer)");
        }
    }

    public Person getBeifahrer() {
        return beifahrer;
    }

    public void setBeifahrer(Person beifahrer) {

            this.beifahrer = beifahrer;

    }

    public void schnellfahren(int betrag){
        if (fahrer.getBargeld() < betrag){
            int restBetrag = (int) (betrag - fahrer.getBargeld());
            if (beifahrer != null && beifahrer.getBargeld() >= restBetrag) {

                System.out.println("Beifahrer wurde " + restBetrag + " Euro ausborgen.");

                beifahrer.zahlen(restBetrag);
                fahrer.setBargeld(0);
            } else {
                System.out.println("Zahlschein ausgestellt! Führerschein entzogen aus der Person: " + fahrer.getNachname());
                fahrer.setFuererschein(false);
            }
        }else {
            fahrer.zahlen(betrag);
            System.out.println("Fahrer: " + fahrer.getNachname() + " hat den Betrag " + betrag + " Euro bezahlt");
        }
    }


    @Override
    public String toString() {
        return "Sportwagen" +
                "\nMarke " + marke +
                "\nPs " + ps +
                "\nVerbrauch " + verbrauch;
    }

    public void printSportwagen(){
        System.out.println(this);
        System.out.println("Fahrer: " + fahrer);
        if (beifahrer != null) {
            System.out.println("Beifahrer: " + beifahrer);
        } else {
            System.out.println("    Keine Beifahrer   ");
        }
    }
}
