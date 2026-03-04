import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        System.out.println("\n--- Results ---");
        System.out.println("String: " + text);
        System.out.println("Number: " + number);

        scanner.close();
    }
}