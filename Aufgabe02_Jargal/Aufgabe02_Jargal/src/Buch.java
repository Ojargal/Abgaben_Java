import org.w3c.dom.ls.LSOutput;
//Aufgabe 1
public class Buch {
    //Eigenschaften der Klasse bzw. globale Variablen
    private boolean taschenbuch;
    private int seiten;
    private String titel;
    private String autor;

//    Standardkonstruktor
    public Buch(){
        taschenbuch = true;
        seiten = 712;
        titel = "Schrödlinger programmiert Java";
        autor = "Philip Ackermann";
    }
// Konstruktor mit Parametern
    public Buch(boolean taschenbuch, int seiten, String titel, String autor){
        setTaschenbuch(taschenbuch);
        setSeiten(seiten);
        setTitel(titel);
        setAutor(autor);
    }

    public void setTaschenbuch(boolean taschenbuch){this.taschenbuch = taschenbuch;}
    public void setSeiten(int seiten){this.seiten = seiten;}
    public void setTitel(String titel){this.titel = titel;}
    public void setAutor(String autor){this.autor = autor;}

    public boolean getTaschenbuch(){return taschenbuch;}
    public int getSeiten() {return seiten;}
    public String getTitel() {
        return titel;
    }
    public String getAutor() {
        return autor;
    }

    public void print(){
    System.out.println("========== BUCH ==========");
    System.out.println("Taschenbuch: " + taschenbuch);
    System.out.println("Seiten: " + seiten);
    System.out.println("Titel: " + titel);
    System.out.println("Autor: " + autor);
    }
}