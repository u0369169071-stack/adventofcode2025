package nl.engelberts;

/**
 * This is the main entry point of the application. It creates an instance of the Day01 class, passing the filename of the input data, and then prints the result of part A to the console. 
 */
public class App {
    public static void main(String[] args) {
        Day03 current_day = new Day03("data/real03.txt");
        System.out.println(current_day.resultA());
        System.out.println(current_day.resultB());
    }
}
