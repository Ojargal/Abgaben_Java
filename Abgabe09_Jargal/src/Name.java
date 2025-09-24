public class Name {
    //    Eigenschaften
    private String vorname;
    private String nachname;

    //    Standard Konstruktor
    public Name() {
    }

    //    Constructor with parameter
    public Name(String nachname, String vorname) {
        setNachname(nachname);
        setVorname(vorname);
    }

//    Gitter-Methoden

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }
/**   */

    public void setVorname(String vorname) {
        if (!vorname.isEmpty()) {
            this.vorname = vorname;
        } else {
            System.out.println("Fehler: Geben Sie Bitte Vorname ein.");
        }
    }

    public void setNachname(String nachname) {
        if (!nachname.isEmpty()) {
            this.nachname = nachname;
        } else {
            System.out.println("Fehler: Geben Sie Bitte Nacname ein.");
        }
    }

    //    getInitialen-Methode
    public String getInitialen() {

        char erstBuchsNach  = nachname.charAt(0);
        char erstBuchsVor  = vorname.charAt(0);

        return "" + erstBuchsNach + erstBuchsVor;

    }

    //    getAccount-Methode
    public String getAccount() {
        String erstfunfBuchstabenNach;
        String erstFourBuchstabenVorname;
        if (nachname.length() >= 5) {
            erstfunfBuchstabenNach = nachname.substring(0, 6);
        }else {erstfunfBuchstabenNach = nachname; }

        if (vorname.length() >=4){
            erstFourBuchstabenVorname = vorname.substring(0, 5);
        }else {erstFourBuchstabenVorname = vorname;}
            return erstfunfBuchstabenNach + erstFourBuchstabenVorname;

    }
//    gleich - Methode
    public boolean gleich(){
        if (vorname.equals(nachname)){
            return true;
        }else {return false;}
    }
}
