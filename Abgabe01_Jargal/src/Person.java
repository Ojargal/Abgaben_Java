//Aufgabe 1
public class Person {
    //Eigenschaften der Klasse bzw. globale Variablen
    private String name;
    private int alter;

    //Konstruktor mit Parametern
    public Person(int alter, String name){
        setName(name);
        setAlter(alter);
    }

    //Standardkonstruktor
    public Person(){
        name = "Max Muster";
        alter = 20;
    }

    public void printPerson(){
        System.out.println("======== PERSON ========");
        System.out.println("Name: " + name);
        System.out.println("Alter: " + alter);
        System.out.println();
    }
//Aufgabe 2
    public void setName(String name) { this.name = name;}

    public void setAlter(int alter){ this.alter = alter;}

    public String getName(){ return name;}
    public int getAlter() {return alter;}

}
