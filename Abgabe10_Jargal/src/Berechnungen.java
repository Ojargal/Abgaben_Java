public class Berechnungen {

    public void hochzahl(int expo) {
        double x = 2.0;  // Base value (can be made configurable)
        double ergebnis;

        if (expo == 0) {
            ergebnis = 1.0;
        }
        else if (expo < 0) {
            ergebnis = 1.0;
            for (int i = 0; i < -expo; i++) {
                ergebnis /= x;
            }
        }  // This closing brace was missing
        else {
            ergebnis = 1.0;
            for (int i = 0; i < expo; i++) {
                ergebnis *= x;
            }
        }
        System.out.println(x + "^" + expo + " = " + ergebnis);
    }


    public void folge(int zaehler, int nenner, int grenze){
        if (nenner == 0){
            System.out.println("Error: divisor cannot be 0!");
            return;
        }
        int ergebnis;
        for (int i = 0; i <= grenze; i++ ){
            System.out.println(zaehler + " / " + nenner );
            zaehler *= 3;
            nenner -= 2;
        }
    }

    public void gewinn(int prozent, int jahre){
        double kapital = 1000;
        System.out.println("Startkapital: " + kapital);
        for (int i = 1; i <= jahre; i++){
            kapital *= (1 + prozent /100.0);
            System.out.printf("Jahr %d: %2f%n", i, kapital);
        }
    }

    public void falling(int startHoehe, int zeit){
        final double G = 9.80665;

        System.out.println("Sekunden\tEntfernung");

            for (int sekunde = 0; sekunde <= zeit; sekunde++) {
                double fallstrecke = 0.5 * G * Math.pow(sekunde, 2);
                if (fallstrecke < startHoehe) {
                    System.out.println(sekunde + "\t\t" + fallstrecke);
                } else {
                    double resthoehe = startHoehe - 0.5 * G * Math.pow(sekunde-1, 2);
                    System.out.println(sekunde + "\tGegenstand kaputt");
                    System.out.println("Versuchsabbruch; verbleibende Resthöhe: " + resthoehe);
                    break;
                }

                if (sekunde == zeit && fallstrecke < startHoehe){
                    double resthoehe = startHoehe - fallstrecke;
                    System.out.println("Versuchsabbruch; verbleibende Resthöhe: " + resthoehe);
                }
            }

    }



}
