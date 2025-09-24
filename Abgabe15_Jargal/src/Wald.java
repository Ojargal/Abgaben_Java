

public class Wald {
    private String name;
    private Baum[] baeume;

    public Wald(String name) {
        setName(name);
        this.baeume = new Baum[100];
    }



    public void setName(String name) {
        if (name != null && !name.isBlank()){
            this.name = name;
        }else {
            System.out.println("Fehler: Name darf nicht leer sein!");
        }
    }



    public void printMiniWald(){
        System.out.println("Name des Walds: " + name);
    }

    public Baum faellen(){

        for (int i = 0; i < baeume.length; i++){
            if (baeume [i] != null && baeume[i].zuFaellen()){
                Baum gefaellt = baeume[i];
                baeume[i] = null;
                return gefaellt;
            }
        }
        return null;
    }

    public void pflanzen(Baum b){
       for (int i = 0; i < baeume.length; i++){
           if (baeume[i] == null){
               baeume[i] = b;
               System.out.println("Baum " + b + " wurde erfolgreich auf Index " + i + " gepflanzt.");
               return;
           }
       }
        System.out.println("Fehler: Wald ist voll, kein Platz mehr!");
    }

    public int anzahlKrank(){
        int count = 0;
        for (Baum baum : baeume) {
            if (baum != null && baum.isKrank()) count++;
        }
        return  count;
    }

    public double volumen(){
        double vol = 0;
        for (Baum baum : baeume){
            if (baum != null) vol += baum.volumen();
        }
        return vol;
    }

    public double wert(double preisProKubikmeter){
        return volumen() * preisProKubikmeter;
    }



    public void print(){
        System.out.println("Wald: " + name);
        for (int i = 0; i < baeume.length; i++){
            if (baeume[i] != null){
                System.out.println("Baum Index " + i + ":");
                baeume[i].print();
            } else {
                System.out.println(" Kein Baum");
            }
        }
        System.out.println("Kranke Bäume: " + anzahlKrank());
        System.out.println("Gesamtvolumen: " + String.format("%.2f", volumen()) + " m³");

    }


}
