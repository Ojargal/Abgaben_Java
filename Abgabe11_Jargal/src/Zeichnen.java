public class Zeichnen {

    public void drawChars(char ch, int number){
        for (int i = 0; i < number; i++){

                System.out.print(ch);

        }
    }

    public void drawRechtangle(char ch, int width, int height, int pos){
        for (int row = 0; row < height; row++) {
                    drawChars(' ', pos);
                if (row == 0 || row == height -1) {
                    drawChars(ch, width);
                }else {
                    drawChars(ch, 1);
                    drawChars(' ', width-2);
                    drawChars(ch, 1);
            }
            drawChars('\n', 1);
        }
    }


    public void drawFilledRechtangle(char ch, char fillchar, int width, int height, int pos){
        for (int row = 0; row < height; row++) {
            drawChars(' ', pos);
            if (row == 0 || row == height -1) {
                drawChars(ch, width);
            }else {
                System.out.print(ch);
                drawChars(fillchar, width-2);
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    public void drawTree(int pos, char ch, int height, int charFirstLine){

        pos = height + pos-1;
        for (int i = 0; i < height; i++) {

            drawChars(' ', pos);
                pos--;
            drawChars(ch, charFirstLine);
            charFirstLine += 2;
            System.out.println();
        }
    }



    public void drawChristmasTree(char chCrown, char chTrunk){
            int p = 8;
            drawTree(p, chCrown, 3, 1);
            drawTree((p-5), chCrown, 7, 3);
            drawTree((p-p), chCrown, 7, 9);

            drawFilledRechtangle(chTrunk, chTrunk, 5, 4, p);
    }

    public void drawZigZag(int height, char ch, boolean endless) {
        do {
            for (int i = 0; i < height; i++) {
                drawChars(' ', i);
                drawChars(ch, 1);
                drawChars('\n', 1);
            }
            try {
                Thread.sleep(1000);
            } catch(Exception ignored) {}
            for (int j = height - 2; j > 0; j--) {
                drawChars(' ', j);
                drawChars(ch, 1);
                drawChars('\n', 1);
            }
            try {
                Thread.sleep(100);
            } catch(Exception ignored) {}

        }while (endless);
    }


}











