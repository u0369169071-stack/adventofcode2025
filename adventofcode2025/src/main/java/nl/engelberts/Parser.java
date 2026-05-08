package nl.engelberts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Parser {
    private final String filename;
    private final String dataString;
    private final String[] dataLines;
    private int currentIndex;

    public Parser(String filename) {
        this.currentIndex = 0;
        this.filename = filename;
        this.dataString = readFile(filename);
        this.dataLines = this.dataString.split("\n");
    }

    private static String readFile(String filename) {
        try {
            return Files.readString(Path.of(filename));
        } catch (IOException e) {
            throw new RuntimeException("Unable to read input file: " + filename, e);
        }
    }

    public String getDataString() {
        return dataString;
    }

    public String[] getDataLines() {
        return dataLines;
    }

    public String getDataLine(int index) {
        return dataLines[index];
    }

    public int getDataLineCount() {
        return dataLines.length;
    }

    public String getNextDataLine() {
        if (currentIndex < dataLines.length) {
            return dataLines[currentIndex++];
        } else {
            return "";
        }
    }

    String[][] getDataLinesAs2DArray() {
        String[][] result = new String[dataLines.length][];
        for (int i = 0; i < dataLines.length; i++) {
            result[i] = dataLines[i].split("");
        }
        return result;
    }

    public String getFilename() {
        return filename;
    }
}
