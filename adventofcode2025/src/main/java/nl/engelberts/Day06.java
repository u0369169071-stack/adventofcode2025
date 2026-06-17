package nl.engelberts;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents the solution for Day 06 of the Advent of Code.
 */

public class Day06 {
    ArrayList<int[]> numbersA;
    ArrayList<String> operators;
    ArrayList<int[]> numbersB;
    String[] lines;

    public Day06(String filename) {
        final String[] possibleOperators = {"*", "+", "*", "+"};
    
        // Parse input data
        Parser parser = new Parser(filename);
        lines = parser.getDataLines();
        numbersA = new ArrayList<int[]>();
        operators = new ArrayList<String>(); 
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
        // Remove the last (empty) line
        numbersA.remove(numbersA.size() - 1);
    }

    // Part A: Calculate the product and sum of numbers based on the operators
    public long resultA() {
        long totalSum = 0;
        for (int i = 0; i < operators.size(); i++) {
            long localProduct = 1;
            long localSum = 0;

            for (int j = 0; j < numbersA.size(); j++) {
                int number = numbersA.get(j)[i];
                String operator = operators.get(i);
                if (operator.equals("*")) {
                    localProduct *= number;
                } else if (operator.equals("+")) {
                    localSum += number;
                }
            }

            if (localProduct > 1) {
                totalSum += localProduct;
            } else {
                totalSum += localSum;
            }
        }
        return totalSum;
    }

    public long resultB() {
        String operator = "";
        long totalSum = 0;
        long total = 0;
        for (int i = 0; i < lines[0].length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < lines.length; j++) {
                char c = lines[j].charAt(i);
                if (c == ' ') {
                    continue;
                } else if (c == '*') {
                    operator = "*";
                    totalSum += total;
                    total = 1;
                } else if (c == '+') {
                    operator = "+";
                    totalSum += total;
                    total = 0;
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) {
                if (operator.equals("*")) {
                    total *= Long.parseLong(sb.toString());
                } else if (operator.equals("+")) {
                    total += Long.parseLong(sb.toString());
                }
            }
        }
        totalSum += total;
        return totalSum;
    }
}
