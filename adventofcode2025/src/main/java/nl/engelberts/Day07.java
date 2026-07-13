package nl.engelberts;

/** This class represents the solution for day 7 */

public class Day07 {
    int countA = 0;
    long countB = 0;
    public Day07(String filename) {
        // Parse input data
        Parser parser = new Parser(filename);
        String[][] matrix = parser.getDataLinesAs2DArray();
        int startRow = -1;
        int startCol = -1;

        // Part A: How many times will the beam be split?
        for (int i=1; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j].equals(".") && matrix[i-1][j].equals("S")) {
                    matrix[i][j] = "|";
                    // Store start position for part B
                    startRow = i-1;
                    startCol = j;
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
        }

        // Part B: In total, how many different timelines would a single tachyon particle end up on?
        // This is a depth-first search problem, where we need to explore all possible paths the tachyon particle can take through the matrix. We can use a recursive function to traverse the matrix and count the number of unique paths.
        // Solve this with a recursive function.

        long[] details = new long[2];
        // details[0] = number of unique paths
        // details[1] = number of time countPaths has been called
        details[0] = 0;
        details[1] = 0;
        countB = countPaths(matrix, startRow, startCol, details);
    }

    private long countPaths(String[][] matrix, int row, int col, long[] details) {
        details[1] ++;
        /* if (details[1] % 1000000 == 0) {
            System.out.println(details[1] + " calls to countPaths, found " + details[0] + " unique paths so far.");
        } */
        String current = matrix[row][col];
        if (current.equals("S")) {
            details[1] ++;
            if (row + 1 < matrix.length) {
                countPaths(matrix, row + 1, col, details);
            } else {
                details[0] ++;
            }
        } else if ((current.equals(".") || current.equals("|"))) {
            details[1] ++;
            if (row + 1 < matrix.length) {
                countPaths(matrix, row + 1, col, details);
            } else {
                details[0] ++;
            }
        } else if (current.equals("^")) {
            if (col > 0) {
                countPaths(matrix, row, col - 1, details);
            }
            if (col < matrix[row].length - 1) {
                countPaths(matrix, row, col + 1, details);
            }
        } else {
            // Found a number of unique paths
            System.out.println("Hello world!");
        }
        return details[0];
    }

    public int resultA() {
        return countA;
    }

    public long resultB() {
        return countB;
    }
}
