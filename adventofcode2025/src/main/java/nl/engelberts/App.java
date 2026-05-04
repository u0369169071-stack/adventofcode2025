package nl.engelberts;

/**
 * This is the main entry point of the application. It creates an instance of the Day01 class, passing the filename of the input data, and then prints the result of part A to the console. 
 */
public class App {
    public static void main(String[] args) {
        Day01 day01 = new Day01("data/real01.txt");
        System.out.println(day01.resultA());
        System.out.println(day01.resultB());
    }
}
