import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
    aufgabe1();
    aufgabe2();
    }

    private static void aufgabe2() {
        // Parkhaus mit 3 Zeilen und 4 Spalten erstellen
        Parkhaus parkhaus = new Parkhaus(3, 4);

        System.out.println("=== Parkhaus Management System ===");
        System.out.println("Größe: " + parkhaus.getZeilen() + " x " + parkhaus.getSpalten());
        System.out.println("Freie Parkplätze: " + parkhaus.countFreeParkplaetze());
        System.out.println("Belegte Parkplätze: " + parkhaus.countBesetzteParkplaetze());
        System.out.println();

        // Autos erstellen
        Auto auto1 = new Auto("M-AB-123", "BMW", "X5", "Rot");
        Auto auto2 = new Auto("B-CD-456", "Mercedes", "C-Klasse", "Weiß");
        Auto auto3 = new Auto("HH-EF-789", "Audi", "A4", "Schwarz");
        Auto auto4 = new Auto("S-GH-012", "VW", "Golf", "Gelb");

        // Autos parken
        System.out.println("=== Autos parken ===");
        parkhaus.parkAuto(auto1, 0, 0);
        parkhaus.parkAuto(auto2, 0, 1);
        parkhaus.parkAuto(auto3, 1, 2);
        parkhaus.parkAuto(auto4, 2, 3);

        // Status anzeigen
        parkhaus.printStatus();
        System.out.println("Freie Parkplätze: " + parkhaus.countFreeParkplaetze());
        System.out.println("Belegte Parkplätze: " + parkhaus.countBesetzteParkplaetze());
        System.out.println();

        // Auto von bestimmter Position abfragen
        System.out.println("=== Auto abfragen ===");
        Auto abgefragtesAuto = parkhaus.getAuto(0, 1);
        System.out.println("Auto auf Position (0,1): " + abgefragtesAuto);
        System.out.println();

        // Auto entfernen
        System.out.println("=== Auto entfernen ===");
        Auto entferntesAuto = parkhaus.removeAuto(1, 2);
        System.out.println("Entferntes Auto: " + entferntesAuto);
        System.out.println("Freie Parkplätze danach: " + parkhaus.countFreeParkplaetze());
        System.out.println();

        // Status nach Entfernung
        parkhaus.printStatus();
        System.out.println();

        // Auto verschieben
        System.out.println("=== Auto verschieben ===");
        boolean verschoben = parkhaus.moveAuto(2, 3, 1, 2);
        System.out.println("Auto verschoben: " + verschoben);
        parkhaus.printStatus();
        System.out.println();

        // Auto anhand Kennzeichen suchen - KORRIGIERT
        System.out.println("=== Auto suchen ===");
        int[] position = parkhaus.findAuto("M-AB-123");
        System.out.println("Auto M-AB-123 gefunden an Position: " + Arrays.toString(position));
        System.out.println();

        // Liste aller geparkten Autos
        System.out.println("=== Alle geparkten Autos ===");
        Auto[] alleAutos = parkhaus.listParkedAutos();
        for (Auto auto : alleAutos) {
            System.out.println(auto);
        }
        System.out.println();

        // Freien Parkplatz finden
        System.out.println("=== Freien Parkplatz finden ===");
        int[] freierPlatz = parkhaus.findFreeParkplaetze();
        System.out.println("Erster freier Parkplatz: " + Arrays.toString(freierPlatz));
        System.out.println();

        // Parkhaus leeren
        System.out.println("=== Parkhaus leeren ===");
        Auto[] entfernteAutos = parkhaus.clearParkhaus();
        System.out.println("Entfernte Autos:");
        for (Auto auto : entfernteAutos) {
            System.out.println(auto);
        }
        System.out.println();

        // Finaler Status
        System.out.println("=== Finaler Status ===");
        parkhaus.printStatus();
        System.out.println("Freie Parkplätze: " + parkhaus.countFreeParkplaetze());
        System.out.println("Belegte Parkplätze: " + parkhaus.countBesetzteParkplaetze());


    }


    private static void aufgabe1() {
        MatrixOperations ops = new MatrixOperations();

        System.out.println("=== Testsuite für Matrixoperationen");

        // Testdaten
        int[][] matrix2x2 = {{1, 2}, {3, 4}};
        int[][] matrix2x2b = {{5, 6}, {7, 8}};
        int[][] matrix3x3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix3x3b = {{2, 0, 1}, {1, 3, 2}, {0, 1, 2}};
        int[][] matrix4x4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] nonSquare = {{1, 2}, {3, 4}, {5, 6}};
        int[][] symmetric = {{1, 2, 3}, {2, 4, 5}, {3, 5, 6}};

        // 1. Test: Matrizenaddition
        System.out.println("1. TEST: MATRIZENADDITION");
        try {
            int[][] sum = ops.addMatrices(matrix2x2, matrix2x2b);
            printMatrix("Matrix A:", matrix2x2);
            printMatrix("Matrix B:", matrix2x2b);
            printMatrix("Ergebnis A + B:", sum);
        } catch (Exception e){
            System.out.println("Fehler: bei Addition: " + e.getMessage());
        }
        System.out.println();

        // 2. Test: Matrizensubtraktion
        System.out.println("2. TEST: MATRIZENSUBTRAKTION");
        try {
            int[][] diff = ops.addMatrices(matrix2x2, matrix2x2b);
            printMatrix("Matrix A:", matrix2x2);
            printMatrix("Matrix B:", matrix2x2b);
            printMatrix("Ergebnis A + B:", diff);
        } catch (Exception e){
            System.out.println("Fehler: bei Subtraktion: " + e.getMessage());
        }
        System.out.println();

        // 3.Test: Matrizenmultiplikation
        System.out.println("3. TEST: MATRIZENMULTIPLIKATION");
        try {
            int[][] product = ops.multiplyMatrices(matrix2x2, matrix2x2b);
            printMatrix("Matrix A:", matrix2x2);
            printMatrix("Matrix B:", matrix2x2b);
            printMatrix("Ergebnis A * B:", product);
        } catch (Exception e) {
            System.out.println("Fehler bei Multiplikation: " + e.getMessage());
        }
        System.out.println();

        // 4. Test: Transponierte Matrix
        System.out.println("4. TEST: TRANSPONIERTE MATRIX");
        try {
            int[][] original = {{1, 2, 3}, {4, 5, 6}};
            int[][] transposed = ops.transposeMatrix(original);
            printMatrix("Original:", original);
            printMatrix("Transponiert:", transposed);
        } catch (Exception e) {
            System.out.println("Fehler bei Transposition: " + e.getMessage());
        }
        System.out.println();

        // 5. Test: Skalarmultiplikation
        System.out.println("5. TEST: SKALARMULTIPLIKATION");
        try {
            int scalar = 3;
            int[][] scaled = ops.scalarMultiplication(matrix2x2.clone(), scalar);
            printMatrix("Original:", matrix2x2);
            System.out.println("Skalar: " + scalar);
            printMatrix("Ergebnis:", scaled);
        } catch (Exception e) {
            System.out.println("Fehler bei Skalarmultiplikation: " + e.getMessage());
        }
        System.out.println();

        // 6. Test: Quadratische Matrix prüfen
        System.out.println("6. TEST: QUADRATISCHE MATRIX PRÜFEN");
        System.out.println("2x2 Matrix ist quadratisch: " + ops.isSquareMatrix(matrix2x2));
        System.out.println("3x2 Matrix ist quadratisch: " + ops.isSquareMatrix(nonSquare));
        System.out.println();

        // 7. Test: Einheitsmatrix
        System.out.println("7. TEST: EINHEITSMATRIX");
        try {
            int[][] identity = ops.identityMatrix(4);
            printMatrix("Einheitsmatrix 4x4:", identity);
        } catch (Exception e) {
            System.out.println("Fehler bei Einheitsmatrix: " + e.getMessage());
        }
        System.out.println();

        // 8. Test: Symmetrische Matrix prüfen
        System.out.println("8. TEST: SYMMETRISCHE MATRIX PRÜFEN");
        System.out.println("Matrix ist symmetrisch: " + ops.isSymmertricMatrix(symmetric));
        System.out.println("2x2 Matrix ist symmetrisch: " + ops.isSymmertricMatrix(matrix2x2));
        System.out.println();


        // 9. Test: Determinantenberechnung
        System.out.println("9. TEST: DETERMINANTENBERECHNUNG");

        // 1x1 Matrix
        int[][] matrix1x1 = {{5}};
        System.out.println("Determinante 1x1 [5]: " + ops.determinant(matrix1x1));

        // 2x2 Matrix
        System.out.println("Determinante 2x2 [[1,2],[3,4]]: " + ops.determinant(matrix2x2));

        // 3x3 Matrix
        System.out.println("Determinante 3x3 [[1,2,3],[4,5,6],[7,8,9]]: " + ops.determinant(matrix3x3));
        System.out.println("Determinante 3x3 [[2,0,1],[1,3,2],[0,1,2]]: " + ops.determinant(matrix3x3b));

        // 4x4 Matrix (rekursive Berechnung)
        try {
            System.out.println("Determinante 4x4: " + ops.determinant(matrix4x4));
        } catch (Exception e) {
            System.out.println("Fehler bei 4x4 Determinante: " + e.getMessage());
        }
        System.out.println();

        // 10. Test: Fehlerfälle
        System.out.println("10. TEST: FEHLERFÄLLE");

        // Unterschiedliche Dimensionen bei Addition
        try {
            ops.addMatrices(matrix2x2, matrix3x3);
        } catch (Exception e) {
            System.out.println("Erwarteter Fehler bei Addition unterschiedlicher Dimensionen: " + e.getMessage());
        }

        // Nicht-quadratische Matrix bei Determinante
        try {
            ops.determinant(nonSquare);
        } catch (Exception e) {
            System.out.println("Erwarteter Fehler bei nicht-quadratischer Matrix: " + e.getMessage());
        }
    }
    /**
     * Hilfsmethode zum Ausgeben einer Matrix
     */
    private static void printMatrix(String title, int[][] matrix){
        System.out.println(title);
        if (matrix == null) {
            System.out.println("null");
            return;
        }

        for (int i = 0; i < matrix.length; i++){
            System.out.print("[");
            for (int j = 0; j < matrix[i].length; j++){
                System.out.printf("%4d", matrix[i][j]);
                if (j < matrix[i].length - 1){
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
    /**
     * Zusätzliche Testmethode für die Minor-Berechnung (da private)
     */
    public static void testMinor(MatrixOperations ops) {
        System.out.println("=== ZUSÄTZLICHER TEST: MINOR-BERECHNUNG ===");

        int[][] testMatrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        // Test: Ersten Minor berechnen (Zeile 0, Spalte 0 entfernen)
        try {
            java.lang.reflect.Method minorMethod = ops.getClass().getDeclaredMethod("minor", int[][].class, int.class, int.class);
            minorMethod.setAccessible(true);

            int[][] minor = (int[][]) minorMethod.invoke(ops, testMatrix, 0, 0);
            printMatrix("Original 4x4:", testMatrix);
            printMatrix("Minor ohne Zeile 0, Spalte 0:", minor);

        } catch (Exception e) {
            System.out.println("Minor-Test konnte nicht durchgeführt werden: " + e.getMessage());
        }
    }
}