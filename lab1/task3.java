import java.util.Scanner;

public class task3 {
    final static int password = 1234;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input data: ");

        if (scanner.hasNextInt()) {
            int input = scanner.nextInt();

            if (input == password) {
                System.out.println("Hello, Agent");
            } else {
                System.out.println("Access denied");
            }
        }

        scanner.close();
    }
}