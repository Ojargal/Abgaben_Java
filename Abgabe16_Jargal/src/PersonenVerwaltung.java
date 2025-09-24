public class PersonenVerwaltung {

//    Eigenschaften
    private Person[] personen;
    private int last;

//    Konstruktor
    public PersonenVerwaltung(int n){
        if (n <= 1){
            System.out.println("Fehler: n muss größer als 1 sein. Setzt n = 2 ein.");
            n = 2;
        }

        personen = new Person[n];
        last = -1;  // Array ist zunächst leer
    }

//  Gibt alle gültigen Personen aus (nur bis 'last')
    public void printPersonen(){
        if (last == -1){
            System.out.println("Array ist leer");
            return;
        }
        for (int i = 0; i <= last; i++){

            System.out.println((i + 1) + ". " + personen[i].getName());

        }
    }

//  Fügt Personen an bestimmter Position ein
    public void einfuegenPosition(Person p, int pos){
        // Prüfe auf volle Array
        if (last == personen.length - 1){
            System.out.println("Array ist voll! Erweitere Array... ");
            erweitereArray();
        }

        // Korrigiere ungültige Positionen
        if (pos < 0){
            pos = 0;
        } else if (pos > last + 1){
            pos = last + 1;
        }

        // Verschiebe Elemente nach rechts
        for (int i = last; i >= pos; i--){
            personen[i + 1] = personen[i];
        }

        // Füge neue Person ein
        personen[pos] = p;
        last++;
        System.out.println(p.getName() + " an Position " + (pos + 1) + " eingefügt.");
    }


    //    Fügt Personen am Anfang ein
    public void einfuegenAnfang(Person p){
        einfuegenPosition(p, 0);
    }


//    Fügt Personen am Ende ein
    public void einfuegenEnde(Person p){
        einfuegenPosition(p, last + 1);
    }

//    Löscht Personen an bestimmter Position
    public void loeschenPosition(int pos){
        if (pos < 0 || pos > last){
            System.out.println("Ungültige Position: " + (pos + 1));
            return;
        }

        Person geloescht = personen[pos];

        // Verschiebe Elemente nach links
        for (int i = pos; i < last; i++){
            personen[i] = personen[i + 1];
        }

        personen[last] = null; // Letztes Element Löschen
        last--;
        System.out.println(geloescht.getName() + " an Position " + (pos + 1) + " gelöscht.");
    }

//    Löscht bestimmte Person
    public void loeschenPersonen(Person p){
        int index = suchen(p.getName());
        if (index != -1){
            loeschenPosition(index);
        } else {
            System.out.println("Person " + p + " nicht gefunden.");
        }
    }

//    Sucht nach Person mit bestimmten Namen
    public int suchen(String name) {
        for (int i = 0; i <= last; i++){
            if (personen[i].getName().equals(name)){
                return i; // Gefunden an Index i
            }
        }
        return -1;
    }

//    Zählt Personen mit bestimmten Namen
    public int anzahl(String name){
        int count = 0;
        for (int i = 0; i <= last; i++){
            if (personen[i].getName().equals(name)){
                count++;
            }
        }
        return count;
    }

//    Hilfsmethode Array auf 1 vergrößern
    private void erweitereArray(){
        Person[] neuesArray = new Person[personen.length + 1];
        System.arraycopy(personen, 0, neuesArray, 0, personen.length);
        personen = neuesArray;
        System.out.println("Array erweitert auf " + personen.length + " Elemente");
    }

//    Getter für Testzwecke
    public int getLast(){
        return last;
    }

    public int getArraySize(){
        return personen.length;
    }






}
