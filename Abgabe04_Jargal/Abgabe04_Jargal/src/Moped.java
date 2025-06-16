public class Moped {
    private boolean aufbohren;
    private int kubik;
    private String besitzer;
    private int maxGeschwindigkeit;
    private double kmStad;

//Standard Konstruktor
    public Moped(){
        aufbohren = true;
        kubik = 80;
        besitzer = "Max Mustar";
        maxGeschwindigkeit = 40;
        kmStad = 150.0;
    }
//Konstruktor mit 5 Parametern
    public Moped(boolean aufbohren, int kubik, String besitzer, int maxGeschwindigkeit, double kmStad){
        setAufbohren(aufbohren);
        setKubik(kubik);
        setBesitzer(besitzer);
        setMaxGeschwindigkeit(maxGeschwindigkeit);
        setKmStand(kmStad);
    }
//Getter-Methoden
    public boolean getAufbohren(){return aufbohren;}
    public int getKubik(){return kubik;}
    public String getBesitzer(){return besitzer;}
    public int getMaxGeschwindigkeit(){return maxGeschwindigkeit;}
    public double getKmStand(){ return kmStad;}

//    Setter-Methoden
   private void setAufbohren(boolean aufbohren){
        this.aufbohren = aufbohren;
   }
   private void setKubik(int kubik){
        this.kubik = kubik;
    }
    private void setBesitzer(String besitzer){
        this.besitzer = besitzer;
    }
    private void setMaxGeschwindigkeit(int maxGeschwindigkeit){
        this.maxGeschwindigkeit = maxGeschwindigkeit;
    }
    private void setKmStand(double kmStad){
        this.kmStad = kmStad;
    }


    public void print(){
        System.out.println("##########################");
        System.out.println("## Aufbohren: " + aufbohren);
        System.out.println("## Besitzer: " + besitzer);
        System.out.println("## Kubikzentimeter: " + kubik);
        System.out.println("## Kilometerstand " + kmStad);
        System.out.println("## Höchstgeschwindigkeit " + maxGeschwindigkeit);
    }
// fahren (int m) Methoden
    public double fahren(int m) {
       if (m>=1&&m<=1000){
           double geFahrenKilometer = (double) m / 1000;
           this.kmStad += geFahrenKilometer;
           return geFahrenKilometer;
       }
       else {
           System.out.println("Fehler: Ungültiger Wert");
           return 0;}
    }
//    service() Methode
    public double service() {
        double kosten = this.kmStad * 2;
        if (this.aufbohren){kosten += 100;}
    this.aufbohren = false; // nach dem Service ist das Moped nicht mehr aufgebohrt
    return kosten;}

    public void aufbohren() {
        this.aufbohren = true;
        this.kubik *= 2;
        this.maxGeschwindigkeit *= 2;
    }
}
