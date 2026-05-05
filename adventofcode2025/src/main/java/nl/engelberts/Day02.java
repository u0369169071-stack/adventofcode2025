package nl.engelberts;

import java.util.regex.Pattern;
/** Nice one for regular expressions */
public class Day02 {
    private long sumA;
    private long sumB;

    public Day02(String filename) {
        Parser parser = new Parser(filename);
        String[] data = parser.getDataLine(0).split(",");
        for (String line : data) {
            long start = Long.parseLong(line.split("-")[0]);
            long end = Long.parseLong(line.split("-")[1]);
            for (long i = start; i <= end; i++) {
                if (Pattern.matches("^(.+)\\1+$", String.valueOf(i))){
                    sumB += i;
                }
                if (Pattern.matches("^(.+)\\1$", String.valueOf(i))) {
                    sumA += i;
                }
            }
        }
    }

    public long resultA() {
        return sumA;
    }

    public long resultB() {
        return sumB;
    }
}
