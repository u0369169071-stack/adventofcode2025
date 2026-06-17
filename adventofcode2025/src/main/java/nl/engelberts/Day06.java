package nl.engelberts;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents the solution for Day 06 of the Advent of Code.
 */

public class Day06 {

    public Day06(String filename) {
        final String[] possibleOperators = {"*", "+", "*", "+"};

        // Parse input data
        Parser parser = new Parser(filename);
        String[] lines = parser.getDataLines();
        ArrayList<int[]> numbersA = new ArrayList<int[]>();
        ArrayList<String> operators = new ArrayList<String>(); 
        for (String line : lines) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (String word : line.split("\s+")) {
                try {
                    int number = Integer.valueOf(word);
                    if (number > 0) {
                        row.add(number);
                    }
                } catch (Exception e) {
                    if (Arrays.asList(possibleOperators).contains(word)) {
                        operators.add(word);
                    }
                }
            }
            numbersA.add(row.stream().mapToInt(i -> i).toArray());
        }

        // Calculate the result
        for (int[] row : numbersA) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
