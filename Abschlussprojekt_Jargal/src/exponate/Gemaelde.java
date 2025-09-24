package exponate;

public class Gemaelde {
    private String name;
    private int alter;
    private double wert;
    private String farbe;

    public Gemaelde() {
    }

    public Gemaelde(String name, int alter, double wert, String farbe) {
        this.name = name;
        this.setAlter(alter);
        this.setWert(wert);
        this.setFarbe(farbe);
    }

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        if (alter < 0) {
            throw new IllegalArgumentException("Alter darf nicht negativ sein");
        }
        this.alter = alter;
    }

    public double getWert() {
        return wert;
    }

    public void setWert(double wert) {
        if (wert < 0) {
            throw new IllegalArgumentException("Wert darf nicht negativ sein");
        }
        this.wert = wert;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        if (farbe.length() > 50) {
            throw new IllegalArgumentException("Farbe darf nicht länger als 50 Zeichen sein");
        }
        this.farbe = farbe;
    }

    public void print() {
        System.out.println("Gemälde: " + name + ", Alter: " + alter + ", Wert: " + wert + ", Farbe: " + farbe);
    }
}