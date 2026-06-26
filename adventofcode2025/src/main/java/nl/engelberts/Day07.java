package nl.engelberts;

/** This class represents the solution for day 7 */

public class Day07 {
    int countA = 0;
    public Day07(String filename) {
        // Parse input data
        Parser parser = new Parser(filename);
        String[][] matrix = parser.getDataLinesAs2DArray();
        for (int i=1; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j].equals(".") && matrix[i-1][j].equals("S")) {
                    matrix[i][j] = "|";
                } else if (matrix[i][j].equals("^") && matrix[i-1][j].equals("|")) {
                    countA ++;
                    if (j > 0) {
                        matrix[i][j - 1] = "|";
                    }
                    if (j < matrix[i].length) {
                        matrix[i][j + 1] = "|";
                    }
                } else if (matrix[i][j].equals(".") && matrix[i-1][j].equals("|")) {
                    matrix[i][j] = "|";
                }
            }
            for (int j=0; j<matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public int resultA() {
        return countA;
    }
}
