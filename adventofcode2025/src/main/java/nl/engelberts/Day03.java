package nl.engelberts;

public class Day03 {
    long sumA = 0;
    long sumB = 0;

    public Day03(String filename) {
        Parser parser = new Parser(filename);
        for (String line : parser.getDataLines()) {
            sumA += maxJoltage(line, 2);
            sumB += maxJoltage(line, 12);
        }
    }

    long maxJoltage(String input_line, int numberOfBatteries) {
        String line = input_line;
        if (line.length() < numberOfBatteries) {
            System.out.println("Line is too short for this number of batteries: " + line);
            return 0L;
        }
        StringBuilder sb = new StringBuilder();
        int maxIndex = 0;
        for (int i = 1; i <= numberOfBatteries; i++) {
            int currentMax = 0;
            for (int pos = 0; pos < line.length() - (numberOfBatteries - i); pos++) {
                if (Integer.parseInt(String.valueOf(line.charAt(pos))) > currentMax) {
                    currentMax = Integer.parseInt(String.valueOf(line.charAt(pos)));
                    maxIndex = pos;
                }
            }
            sb.append(line.charAt(maxIndex));
            line = line.substring(maxIndex + 1);
        }
        return Long.parseLong(sb.toString());
    }

    public long resultA() {
        return sumA;
    }

    public long resultB() {  
        return sumB;
    }
}
