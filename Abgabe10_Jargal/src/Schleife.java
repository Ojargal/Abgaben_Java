public class Schleife {
//    Eigenschaften
    /**
     *
     */
    private int grenze;

//    Standard Methode

    /**
     *
     */
    public Schleife(){
        grenze = 10;
    }

//    Konstruktor mir Parametern

    /**
     *
     * @param grenze
     */
    public Schleife(int grenze){
        setGrenze(grenze);
    }

//    Set-Methode

    /**
     *
     * @param grenze
     */
    public void setGrenze(int grenze) {
        if (grenze >= 0 && grenze <= 200){
            this.grenze = grenze;
        }else {
            System.out.println("Fehler: grenze muss zwischen 0 und 200 liegen!");
        }
    }

//    Getter-Methode

    /**
     *
     * @return
     */
    public int getGrenze() {
        return grenze;
    }

    public void while1(){
            int i = 0;
            while (i <= 10) {
                System.out.println(i);
                i++;
            }System.out.println("ENDE while1");

    }

    public void while2(){
            int i = 10;
        while (i <= 20) {
            System.out.println(i);
            i += 2;

        }
        System.out.println("ENDE while2");
    }

    public void while3(){
        int i = 10;
        while (i >= -10) {
            System.out.println(i);
            i --;
        }
        System.out.println("ENDE while3");
    }
    public void while4(int anzahl){
        int i = 0;
        while (i < anzahl * 5){
            System.out.println(i);
            i += 5;
        }
    }
    public void while5(){
        int i = 0;
        while(i <= grenze){
            System.out.println("-" + i);
            i++;
        }
    }
    public void while6(int start){
        if (start < grenze){
            while(start <= grenze){
                System.out.println(start);
                start++;
            }
        }else {
            while (start >= grenze){
                System.out.println(start);
                start--;
            }
        }
    }
    public void while7(int gr1, int gr2){
//        int start = Math.min(gr1, gr2);
//        int end = Math.max(gr1, gr2);
        int start, end;

        if (gr1 > gr2){
            start = gr2;
            end = gr1;
        }else {
            start = gr1;
            end = gr2;
        }
        while (start <= end){
            System.out.println(start);
            start++;
        }
    }

    public void while8(int start){
        if (start % 2 != 0){
            start--;
        }
        while (start <= grenze){
            System.out.println(start);
            start += 2;

        }
    }
    public void while9(){
        int zaehler = 1;
        while (zaehler <= grenze){
            System.out.println(zaehler + "/" + (zaehler + 4));
            zaehler++;
        }
    }


}
