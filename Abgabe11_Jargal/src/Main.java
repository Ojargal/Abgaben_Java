
public class Main {
    public static void main(String[] args) {

        Zeichnen z = new Zeichnen();
        PrimUndEcke pu = new PrimUndEcke();
       pu.printPrim(2, 120);
       pu.printEcke1(5);
       pu.printEcke2(4);
       pu.printEcke3(5, '+', '-');
       pu.printEcke4(5, '+', '-');



        z.drawRechtangle('-', 10, 5, 1);
        z.drawFilledRechtangle('#', '~',10, 10, 20);
        z.drawTree(3, '~', 10, 3);
        z.drawChristmasTree('>', 'µ');
//        z.drawZigZag(7, 'o', true);

    }
}