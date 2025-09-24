import java.util.Random;

public class Wettlauf {
    private int hasePosition = 0;
    private int schildPosition = 0;
    private final Random random = new Random();
    private int runde = 0;

    public void startRace() {
        while (hasePosition < 70 && schildPosition < 70) {
            runde++;
            System.out.println("\nRunde " + runde + ":");

            simulateHs();
            simulateTur();

            printPositions();
        }

        printWinner();
    }

    private void simulateHs() {
        int step = random.nextInt(100);

        if (step < 20) {
            // Schlaf (keine Bewegung)
        } else if (step < 40) {
            hasePosition += 9;
        } else if (step < 50) {
            hasePosition -= 12;
        } else if (step < 80) {
            hasePosition += 1;
        } else {
            hasePosition -= 2;
        }

        if (hasePosition < 0) hasePosition = 0;
    }

    private void simulateTur() {
        int step = random.nextInt(100);

        if (step < 50) {
            schildPosition += 3;
        } else if (step < 70) {
            schildPosition -= 6;
        } else {
            schildPosition += 1;
        }

        if (schildPosition < 0) schildPosition = 0;
    }

    private void printPositions() {
        System.out.print("Hase:");
        for (int i = 0; i < hasePosition; i++) {
            System.out.print("H");
        }
        System.out.println();

        System.out.print("Schildkröte:");
        for (int i = 0; i < schildPosition; i++) {
            System.out.print("s");
        }
        System.out.println();
    }

    private void printWinner() {
        System.out.println("\nErgebnis:");
        if (hasePosition >= 70 && schildPosition >= 70) {
            System.out.println("Unentschieden!");
        } else if (hasePosition >= 70) {
            System.out.println("Hase gewinnt!");
        } else {
            System.out.println("Schildkröte gewinnt!");
        }
    }

    public String getWinner() {
        if (hasePosition >= 70 && schildPosition >= 70) {
            return "Unentschieden";
        } else if (hasePosition >= 70) {
            return "Hase";
        } else {
            return "Schildkröte";
        }
    }
}