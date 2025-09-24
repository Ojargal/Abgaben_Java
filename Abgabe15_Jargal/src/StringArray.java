import java.util.Random;

public class StringArray {
    private String[] werte;

    public StringArray(String[] a){
        this.werte = a;
    }

    public void print(){
        for (int i = 0; i < werte.length; i++){
            System.out.print(" " + i + ":" + werte[i]);
        }
    }

    public void umdrehen(){
        for (int i = 0; i < werte.length /2 ; i++){
            String temp = werte[i];
            werte[i] = werte[werte.length-(i+1)];
            werte[werte.length-(i+1)] = temp;
        }
    }
    public void rechtsSchieben(){
        if (werte.length == 0) return;
        String last = werte[werte.length -1];
        for (int i = werte.length -1; i > 0; i--){
            werte[i] = werte[i - 1];
        }
        werte[0] = last;
    }

    public void linksschieben(int s){
        if (werte.length == 0) return;
        s = s % werte.length;
        for (int shift = 0; shift < s; shift++){
            String first = werte[0];
            for (int i = 0; i < werte.length - 1; i++){
                werte[i] = werte[i + 1];
            }
            werte[werte.length - 1] = first;
        }
    }

    public boolean suchen(String s){
        for (String element : werte){
            if (element.equals(s)){
                return true;
            }
        }
        return false;
    }

    public static String zufall(int l){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<l; i++){
            char c = (char) (random.nextInt(26) + 'A');
            sb.append(c);
        }
        return sb.toString();
    }



}
