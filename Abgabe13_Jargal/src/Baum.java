public class Baum {

    private String name;
    private short alter;
    private double hoehe;
    private boolean krank;
    private double durchmesser;


    public Baum(String name, short alter, double hoehe, boolean krank, double durchmesser) {
        setName(name);
        setAlter(alter);
        setHoehe(hoehe);
        setDurchmesser(durchmesser);
        setKrank(krank);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()){
            this.name = name;
        }
        else {
            System.out.println("Fehler: Name darf nicht leer sein!");
            this.name = "Unbekannt";
        }

    }

    public short getAlter() {
        return alter;
    }

    public void setAlter(short alter) {
        if (alter >= 0){
            this.alter = alter;
        }else {
            System.out.println("Alter muss positiv sein! (alter)");
            this.alter = 0;
        }
    }

    public double getHoehe() {
        return hoehe;
    }

    public void setHoehe(double hoehe) {
        if (hoehe > 0 && hoehe < 150){
            this.hoehe = hoehe;
        }else {
            System.out.println("Fehler: Höhe muss zwieschen 0 bis 150 sein");
            this.hoehe = 1.0d;
        }
    }

    public boolean isKrank() {
        return krank;
    }

    public void setKrank(boolean krank) {
        this.krank = krank;
    }

    public double getDurchmesser() {
        return durchmesser;
    }

    public void setDurchmesser(double durchmesser) {
        if (durchmesser > 0 && durchmesser < hoehe/10){
            this.durchmesser = durchmesser;
        }else {
            System.out.println("Fehler: Ungültige Wert");
            this.durchmesser = hoehe/20;
        }
    }

    public void print(){
        System.out.println("Name: "+ name);
        System.out.println("Alter: "+ alter + " Jahre");
        System.out.println("Höhe: "+ hoehe + " m");
        System.out.println("Durchmesser: "+ durchmesser + " m");
        System.out.println("Krank: "+ (krank ? "ja" : "nein"));
        System.out.println("Muss gefällt werden: "+ (zuFaellen() ? "ja" : "nein"));
        System.out.println(" Volumen: " + String.format("%.2f", volumen()) + " m³");
    }

    public boolean zuFaellen(){
       return (alter > 40 || hoehe > 50 || krank );
    }

    public double volumen(){
        double radius = durchmesser / 2.0;
        return Math.pow(radius, 2) * Math.PI * hoehe;
    }
}
