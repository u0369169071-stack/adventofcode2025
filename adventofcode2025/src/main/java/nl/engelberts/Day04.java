package nl.engelberts;

public class Day04 {
    int turns = 0;
    int totalA = 0;
    int totalB = 0;
    int lastRound = 0;

    public Day04(String filename) {
        Parser parser = new Parser(filename);
        String[][] data = parser.getDataLinesAs2DArray();
        do {
            turns++;
            lastRound = totalB;
            for (int y=0; y < data.length; y++) {
                for (int x=0; x < data[y].length; x++) {
                    int counter = 0;
                    if (data[y][x].equals("@")) {
                        for (int y2=-1; y2 <= 1; y2++) {
                            for (int x2=-1; x2 <= 1; x2++) {
                                if (y+y2 >= 0 && y+y2 < data.length && x+x2 >= 0 && x+x2 < data[y].length) {
                                    if ((data[y+y2][x+x2].equals("@")) || (data[y+y2][x+x2].equals("*"))) {
                                        counter++;
                                    }
                                }
                            }
                        }   
                        if (counter < 5) {
                            if (turns == 1) {
                                totalA++;
                            }
                            totalB++;
                            data[y][x] = "*";
                        }
                    }
                }
            }
            for (int y=0; y < data.length; y++) {
                for (int x=0; x < data[y].length; x++) {
                    if (data[y][x].equals("*")) {
                        data[y][x] = ".";
                    }
                }
            }
        } while (totalB > lastRound);
    }

    public int resultA() {
        return totalA;
    }

    public int resultB() {
        return totalB;
    }
}
