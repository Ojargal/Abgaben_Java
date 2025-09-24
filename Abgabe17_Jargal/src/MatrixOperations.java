public class MatrixOperations {

    public int[][] addMatrices(int[][] matrixA, int[][] matrixB){
        if (haveSameDimesions(matrixA, matrixB)) {
            int rows = matrixA.length;
            int cols = matrixA[0].length;

            int[][] sum = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    sum[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }
            return sum;
        } else {
            throw new IllegalArgumentException("Matrizen haben unterschiedliche Dimensionen.");
        }
    }

    public int[][] subMatrices(int[][] matrixA, int[][] matrixB){
        if (haveSameDimesions(matrixA, matrixB)) {
            int rows = matrixA.length;
            int cols = matrixA[0].length;

            int[][] sub = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    sub[i][j] = matrixA[i][j] - matrixB[i][j];
                }
            }
            return sub;
        } else {
            throw new IllegalArgumentException("Matrizen haben unterschiedliche Dimensionen.");
        }
    }

    public int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB){
        if (matrixA[0].length != matrixB.length) {
            throw new IllegalArgumentException("Fehler: Matrizen haben unterschiedliche Dimensionen.");
        }

        int[][] produkt = new int[matrixA.length][matrixB[0].length];

        for (int i = 0; i < matrixA.length; i++){
            for (int j = 0; j < matrixB[0].length; j++){
                for (int k = 0; k < matrixB.length; k++){
                    produkt[i][j] += matrixA[j][k] * matrixB[k][j];
                }
            }
        }
        return produkt;
    }

    public int[][] transposeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++){
                matrix[j][i] = matrix[i][j];
            }
        }
        return matrix;
    }

    public int[][] scalarMultiplication(int[][] matrix, int scalar) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++){
                matrix[i][j] *= scalar;
            }
        }
        return matrix;
    }

    public boolean isSquareMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i].length != matrix.length){
                return false;
            }
        }
        return true;
    }

    public int[][] identityMatrix(int size){
        if (size < 0){
            throw new IllegalArgumentException("Fehler: Size darf nicht negativ sein!");
        }

        int[][] matrix = new int[size][size];
        for (int i = 0; i < matrix.length; i++){
            matrix[i][i] = 1;
        }
        return matrix;

    }

    public boolean isSymmertricMatrix(int [][] matrix) {
        if (matrix == null){
            return false;
        }
        if (!isSquareMatrix(matrix)) return false;
        int[][] matrixTranspose = transposeMatrix(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrixTranspose[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Berechnet die Determinante einer quatraticshen Matrix.
     * Die Methode funktioniert für Matrizen beliebiger Größe durch rekursive
     * Anwendung der Laplace-Entwicklung
     *
     * @param matrix Die quadratische Matrix, deren Determinante berechnet werden soll
     * @return Die Determinante der Matrix
     * @throws IllegalAccessException Wenn die Matrix nicht quadratisch ist
     */
    public int determinant(int[][] matrix){
        // Überprüfung ob die Matrix quadratisch ist
        if (!isSquareMatrix(matrix)){
            throw new IllegalArgumentException("Matrix muss quadratisch sein (Anzahl Zeilen == Anzahl Spalten).");
        }
        // Größe der Matrix (n * n)
        int n = matrix.length;

        // Basisfall 1: 1x1 Matrix
        // Die Determinante einer 1x1 Matrix [a] ist einfach das Element a
        if (n == 1){
            return matrix[0][0];
        }
        // Basisfall 2: 2x2 Matrix
        // Formel: | a b | = a*d - b*c
        //         | c d |
        if (n == 2){
            return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
        }
        // Basisfall 3: 3x3 Matrix
        // Berechnung nach der Regel von Sarrus (effizienter als Laplace für 3x3)
        // Formel: Formel: a(ei - fh) - b(di - fg) + c(dh - eg)
        if (n == 3){
            return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                    - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                    + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        }

        // RekursionsfallL: Laplace-Entwicklung für Matrizen größer als 3x3
        // Entwickelt nach der ersten Zeile (Zeile 0)
        int det = 0;

        // Gehe jede Spalte der ersten Zeile durch
        for (int col = 0; col < n; col++) {
            // Berechne den Beitrag des aktuellen Elements zur Determinante:
            // (-1)^(col) * Element * Determinante der Untermatrix (Minor)
            det += Math.pow(-1, col) * matrix[0][col] * determinant(minor(matrix, 0, col));
        }
        return det;
    }

    /**
     * Erstellt eine Untermatrix (Minor) durch Entfernen einer bestimmten Zeile und Spalte.
     *
     * @param matrix Die Originalmatrix
     * @param rowToRemove Die zu entfernende Zeile (0-basiert)
     * @param colToRemove Die zu entfernende Spalte (0-basiert)
     * @return Die reduzierte Untermatrix ohne die angegebene Zeile und Spalte
     */
    private int[][] minor(int[][] matrix, int rowToRemove, int colToRemove) {
        int n = matrix.length;

        // Erstelle eine neue Matrix der Größe (n-1) x (n-1)
        int[][] result = new int[n - 1][n - 1];

        int r = 0; // Zähler für die Zeilen der neuen Matrix

        // Gehe alle Zeilen der Originalmatrix durch
        for (int i = 0; i < n; i++) {
            // Überspringe die zu entfernende Zeile
            if (i == rowToRemove) continue;
            int c = 0; // Zähler für die Spalten der neuen Matrix

            // Gehe alle Spalten der aktuellen Zeile durch
            for (int j = 0; j < n; j++) {
                // Überspringe die zu entfernende Spalte
                if (j == colToRemove) continue;
                // Kopiere das Element in die neue Matrix
                result[r][c++] = matrix[i][j];
            }
            r++; // Gehe zur nähcsten Zeile inde neuen Matrix
        }
        return result;
    }



//  Hilfsmethod
    private boolean haveSameDimesions(int[][] matrixA, int[][] matrixB) {
        if (matrixA.length != matrixB.length) return false;

        for (int i = 0; i < matrixA.length; i++){
            if (matrixA[i].length != matrixB[i].length) return false;
        }
        return true;
    }




}
