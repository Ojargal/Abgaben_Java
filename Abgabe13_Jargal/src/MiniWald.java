import javax.sound.midi.Soundbank;

public class MiniWald {
    private String name;
    private Baum b0;
    private Baum b1;
    private Baum b2;

    public MiniWald(String name) {
        this.name = name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()){
            this.name = name;
        }else {
            System.out.println("Fehler: Name darf nicht leer sein!");
        }
    }

    public void setB0(Baum b0) {
        this.b0 = b0;
    }

    public void setB1(Baum b1) {
        this.b1 = b1;
    }

    public void setB2(Baum b2) {
        this.b2 = b2;
    }

    public String getName() {
        return name;
    }

    public Baum getB0() {
        return b0;
    }

    public Baum getB1() {
        return b1;
    }

    public Baum getB2() {
        return b2;
    }

    public void printMiniWald(){
        System.out.println("Name des Walds: " + name);
    }

    public Baum faellen(){
        Baum[] baeume = {b0, b1, b2};
        for (int i = 0; i < baeume.length; i++){
            if (baeume [i] != null && baeume[i].zuFaellen()){
                Baum gefaellt = baeume[i];
                switch (i){
                    case 0 -> b0 = null;
                    case 1 -> b1 = null;
                    case 2 -> b2 = null;
                }
                return gefaellt;
            }
        }
        return null;
    }

    public void pflanzen(Baum b){
        if (b0 == null){
            b0 = b;
        } else if (b1 == null) {
            b1 = b;
        } else if (b2 == null) {
            b2 = b;
        } else {
            System.out.println("Fehler: Miniwald ist voll, kein Platz mehr!");
        }
    }

    public int anzahlKrank(){
        int count = 0;
        if (b0 != null && b0.isKrank()) count++;
        if (b1 != null && b1.isKrank()) count++;
        if (b2 != null && b2.isKrank()) count++;
        return  count;
    }

    public double volumen(){
        double vol = 0;
        if (b0 != null) vol += b0.volumen();
        if (b1 != null) vol += b1.volumen();
        if (b2 != null) vol += b2.volumen();
        return vol;
    }

    public void print(){
        Baum[] baeume = {b0, b1, b2};
        System.out.println("Mini Wald: " + name);
        for (int i = 0; i < baeume.length; i++){
            if (baeume [i] != null){
                System.out.println("Baum " + i + ":");
                baeume[i].print();
            } else {
                System.out.println(" Kein Baum");
            }
        }
        System.out.println("Kranke Bäume: " + anzahlKrank());
        System.out.println("Gesamtvolumen: " + String.format("%.2f", volumen()) + " m³");

    }


}
