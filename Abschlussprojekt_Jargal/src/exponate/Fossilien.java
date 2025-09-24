package exponate;

public class Fossilien {
    private String name;
    private int alter;
    private double wert;
    private String mineralstoff;

    public Fossilien() {
    }

    public Fossilien(String name, int alter, double wert, String mineralstoff) {
        this.name = name;
        this.setAlter(alter);
        this.setWert(wert);
        this.setMineralstoff(mineralstoff);
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

    public String getMineralstoff() {
        return mineralstoff;
    }

    public void setMineralstoff(String mineralstoff) {
        if (mineralstoff.length() > 50) {
            throw new IllegalArgumentException("Mineralstoff darf nicht länger als 50 Zeichen sein");
        }
        this.mineralstoff = mineralstoff;
    }

    public void print() {
        System.out.println("Fossil: " + name + ", Alter: " + alter + ", Wert: " + wert + ", Mineralstoff: " + mineralstoff);
    }
}