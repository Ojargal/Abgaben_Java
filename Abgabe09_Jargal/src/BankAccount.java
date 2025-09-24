public class BankAccount{
//    Eigenschaften
    public String vorname;
    public String nachname;
    public double guthaben;
    public String accounttyp;

//    Standard constructor
    public BankAccount(){

    }

//    getter-Methoden

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public double getGuthaben() {
        return guthaben;
    }

    public String getAccounttyp() {
        return accounttyp;
    }

//    Setter-Methoden

    public void setVorname(String vorname) {
        if (vorname != null && !vorname.isEmpty()){

            this.vorname = vorname.substring(0, 1).toUpperCase() + vorname.substring(1).toLowerCase();
        }else {
            System.out.println("Fehler: Geben Sie bitte Ihre Vorname!");
        }
    }

    public void setNachname(String nachname) {
        if (nachname != null && !nachname.isEmpty()){
            this.nachname = nachname.substring(0, 1).toUpperCase() + nachname.substring(1).toLowerCase();


        }else {
            System.out.println("Fehler: Geben Sie bitte Ihre Nachname!");
        }
    }

    public void setGuthaben(double guthaben) {
            this.guthaben = guthaben;
    }

    public void setAccounttyp(String accounttyp) {

        if (accounttyp.trim().equalsIgnoreCase("Girokonto")){
            this.accounttyp = "Girokonto";
        }
        if (accounttyp.trim().equalsIgnoreCase("Sparbuch")){
            this.accounttyp = "Sparbuch";
        }else {
            System.out.println("Fehler: Schreiben Sie bitte Girokonto oder Sparbuch! ");
        }

    }

//    Constructor with parameter

    public BankAccount(String vorname, String nachname, double guthaben, String accounttyp) {
        setVorname(vorname);
        setNachname(nachname);
        setAccounttyp(accounttyp);
        setGuthaben(guthaben);
    }
    public void print() {
//        System.out.println("Vorname: " + vorname);
//        System.out.println("Nachname: " + nachname);
        System.out.println("Benutzername: " + vorname.charAt(0) + "." + nachname);
        System.out.println("Guthaben: " + guthaben + " EUR");
        System.out.println("Accounttyp: " + accounttyp);
    }

//    Einzahlen Methode
    public void einzahle(int betrag){
        if (betrag > 0){
            guthaben += betrag;
            System.out.println("Einzahlung ist erfolgreich durchgefuhrt und Sie haben " + guthaben + " Euro.");
        }else {
            System.out.println("Fehler: Ungültiger Betrag oder nicht genug Guthaben!");
        }
    }

//    Abheben-Meethod
    public void abheben(int betrag){
        if (betrag > 0 && betrag <= guthaben){
            guthaben -= betrag;
            System.out.println("Abhebung ist erfolgreich durchgefuhrt und Sie haben " + guthaben + " Euro.");
        }else {
            System.out.println("Fehler: Ungültige Wert!!!");
        }
    }
//    Zinsen rechnen-Methode
    public void berechneZinsen(double rate){
        if (rate >= 0){
            double zinsen = guthaben * rate/100;
            guthaben += zinsen;
            System.out.println("Zinsen: " + zinsen + " €. Neues Guthaben: " + guthaben + " €");
        }else {
            System.out.println("Fehler: Ungültiger Zinssatz!");
        }

    }


}
