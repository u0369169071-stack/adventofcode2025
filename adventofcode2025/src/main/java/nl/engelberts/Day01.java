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

class Dial {
    int value;
    int landedAtZeroCount;
    int passedZeroCount;

    public Dial() {
        this.value = 50;
        this.landedAtZeroCount = 0;
        this.passedZeroCount = 0;
    }

    public void turn(String rotation) {
        String direction = rotation.substring(0, 1);
        int amount = Integer.parseInt(rotation.substring(1));
        if (direction.equals("R")) {
            for (int i = 0; i < amount; i++) {
                value = (value + 1) % 100;
                if (value == 0) {
                    passedZeroCount++;
                }
            }
        } else if (direction.equals("L")) {
            for (int i = 0; i < amount; i++) {
                value = (value - 1 + 100) % 100;
                if (value == 0) {   
                    value = 100;
                    passedZeroCount++;
                }
            }
        }
        value = value % 100;
        if (value == 0) {
            landedAtZeroCount++;
        }
    }

    public int getLandedAtZeroCount() {
        return landedAtZeroCount;
    }

    public int getPassedZeroCount() {
        return passedZeroCount;
    }
}
