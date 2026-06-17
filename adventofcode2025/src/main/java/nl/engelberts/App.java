package nl.engelberts;

/**
 * This is the main entry point of the application. It creates an instance of the Day01 class, passing the filename of the input data, and then prints the result of part A to the console. 
 */
public class App {
    public static void main(String[] args) {
        Day06 current_day = new Day06("data/real06.txt");
        System.out.println("Part A: " + current_day.resultA());
        System.out.println("Part B: " + current_day.resultB());
    }
}
