public class Sortiert3 {
//    Eigenschaften
    private int a = 1;
    private int b = 1;
    private int c = 1;


    public Sortiert3(int a1, int b1, int c1) {
            int tempA = a1;
            int tempB = b1;
            int tempC = c1;

            if (tempA < tempB){
                int temp = tempA;
                tempA = tempB;
                tempB = temp;
            }
            if (tempA < tempC){
                int temp = tempA;
                tempA = tempC;
                tempC = temp;
            }
            if (tempB < tempC){
                int temp = tempB;
                tempB = tempC;
                tempC = temp;
            }
            this.a = tempA;
            this.b = tempB;
            this.c = tempC;
    }

    public void print(){
        System.out.println("Die Zahlen in Sortierter Reihenfolge (absteigend):");
        System.out.println("a (größte Zahl): " + a);
        System.out.println("b (zweitgrößte Zahl): " + b);
        System.out.println("c (kleinste Zahl): " + c);

    }


}
