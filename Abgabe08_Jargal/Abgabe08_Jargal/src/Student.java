public class Student {
//    Eigenschaften
    private String name;
    private int alter;
    private String fach;
//    Standart Konstruktor
    public Student(){
        name = "Max Muster";
        alter = 25;
        fach = "BWL";
    }
//    Konstrunktor mit Parametern


    public Student(String name, int alter, String fach) {
        setName(name);
        setAlter(alter);
        setFach(fach);
    }
//    Setter-Methode

    public void setName(String name) {
        this.name = name;
    }

    public void setAlter(int alter) {
        if (alter >= 18){
            this.alter = alter;
        }else {
            System.out.println("Fehler: Zu jung");
        }
    }

    public void setFach(String fach) {
        this.fach = fach;
    }
//    Getter-Methode

    public String getName() {
        return name;
    }

    public int getAlter() {
        return alter;
    }

    public String getFach() {
        return fach;
    }
//    print - Methode
    public void print(){
        System.out.println("-----------------------");
        System.out.println("Name: " + name);
        System.out.println("Alter: " + alter);
        System.out.println("Fach: " + fach);
        System.out.println("-----------------------");
    }
}
