package nl.engelberts;

/**
 * This class represents the solution for Day 01 of the Advent of Code.
 */

public class Day01 {
    private Dial dial = new Dial();

    public Day01(String filename) {
        Parser parser = new Parser(filename);
        
        String rotation = "initial";
        while (!rotation.isEmpty()) {
            rotation = parser.getNextDataLine();
            if (!rotation.isEmpty()) {
                dial.turn(rotation);
            }
        }
    }

    public int resultA() {
        return dial.getLandedAtZeroCount();
    }

    public int resultB() {
        return dial.getPassedZeroCount();
    }
}
