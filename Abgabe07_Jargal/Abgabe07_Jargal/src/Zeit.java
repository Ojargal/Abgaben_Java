public class Zeit {
    private int stunde;
    private int minute;
    private int sekunde;

//    Standard Konstruktor
    public Zeit(){
        stunde = 0;
        minute = 0;
        sekunde = 0;
    }

    public Zeit(int stunde, int minute, int sekunde) {
        setStunde(stunde);
        setMinute(minute);
        setSekunde(sekunde);
    }
// Getter-Methode
    public int getStunde() {
        return stunde;
    }

    public int getMinute() {
        return minute;
    }

    public int getSekunde() {
        return sekunde;
    }
// Setter-Methode


    public void setStunde(int stunde) {
        if (stunde >= 0 && stunde <= 23) {
            this.stunde = stunde;
        }else {
            System.out.println("Fehler: Ungültige Wert. Zeit wurde 0 ersetzt.");
            this.stunde = 0;
        }
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute <= 59) {
            this.minute = minute;
        }else {
            System.out.println("Fehler: Ungültige Wert. Minute wurde 0 ersetzt.");
            this.minute = 0;
        }
    }

    public void setSekunde(int sekunde) {
        if (sekunde >= 0 && sekunde <= 59) {
            this.sekunde = sekunde;
        }else {
            System.out.println("Fehler: Ungültige Wert. Sekunde wurde 0 ersetzt.");
            this.sekunde = 0;
        }
    }
//    Print-Methode

    public void printZeit(){
        System.out.println(stunde + ":" + minute + ":" + sekunde);
    }

//    addieren-Methoden

    public void addiereMinuten(int anzahl){
        if (minute + anzahl > 59){
            int newMinute = minute + anzahl;
            stunde = stunde + newMinute / 60;
            minute = newMinute % 60;
        }else {
            minute = minute + anzahl;
        }

    }

    public void addiereStuden(int anzahl){
        if (stunde + anzahl > 23){
            int newStu = stunde + anzahl;
//            int tag = (stunde + anzahl) / 24;
            int restStu = newStu % 24;
            stunde = restStu;


        }else {
            stunde = stunde + anzahl;
        }

    }

    public void addiereSekunden(int anzahl){
        if (sekunde + anzahl > 59){
            int newSekunde = sekunde + anzahl;
            if (newSekunde < 3600){
                minute = minute + newSekunde/60;
                sekunde = newSekunde % 60;
            }else {
                stunde = newSekunde / 3600;
                minute = (newSekunde % 3600) / 60;
                sekunde = (newSekunde % 3600) % 60;
            }

        }else {
            sekunde = sekunde + anzahl;
        }

    }

}
