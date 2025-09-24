package exponate;

public class Skulptur {
    private String name;
    private int alter;
    private double wert;
    private String stein;

    public Skulptur() {
    }

    public Skulptur(String name, int alter, double wert, String stein) {
        this.name = name;
        this.setAlter(alter);
        this.setWert(wert);
        this.setStein(stein);
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

    public String getStein() {
        return stein;
    }

    public void setStein(String stein) {
        if (stein.length() > 50) {
            throw new IllegalArgumentException("Stein darf nicht länger als 50 Zeichen sein");
        }
        this.stein = stein;
    }

    public void print() {
        System.out.println("Skulptur: " + name + ", Alter: " + alter + ", Wert: " + wert + ", Stein: " + stein);
    }
}