import java.util.NoSuchElementException;

public class Person {
//    Eigenschaften
    private String name;
    private int alt;
//  Standard Konstruktor
    public Person(){
        name = "Max";
        alt = 18;
    }
//  Konstruktor mit parameter
    public Person(String name, int alt) {
        setAlt(alt);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlt() {
        return alt;
    }

    public void setAlt(int alt) {
        if (alt >= 18 && alt <= 100){
            this.alt = alt;
        }
    }


}
