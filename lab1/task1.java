import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println("Hello, " + input);
        }
        
        scanner.close();
    }
}