package museum;

import exponate.*;

public class Museum {
    private Gemaelde gemaelde;
    private Skulptur skulptur;
    private Fossilien fossil;

    public Museum() {
    }

    // Getter & Setter
    public Gemaelde getGemaelde() {
        return gemaelde;
    }

    public void setGemaelde(Gemaelde gemaelde) {
        this.gemaelde = gemaelde;
    }

    public Skulptur getSkulptur() {
        return skulptur;
    }

    public void setSkulptur(Skulptur skulptur) {
        this.skulptur = skulptur;
    }

    public Fossilien getFossil() {
        return fossil;
    }

    public void setFossil(Fossilien fossil) {
        this.fossil = fossil;
    }

    public double getWertForExpo(String expoName) {
        if (expoName.equalsIgnoreCase(gemaelde.getName())) {
            return gemaelde.getWert();
        } else if (expoName.equalsIgnoreCase(skulptur.getName())) {
            return skulptur.getWert();
        } else if (expoName.equalsIgnoreCase(fossil.getName())) {
            return fossil.getWert();
        } else {
            throw new IllegalArgumentException("Exponat nicht gefunden");
        }
    }
}