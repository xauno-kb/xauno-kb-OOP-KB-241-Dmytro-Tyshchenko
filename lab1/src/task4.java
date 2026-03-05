import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of strangers: ");

        if (scanner.hasNextInt()) {
            int count = scanner.nextInt();
            scanner.nextLine(); 

            if (count < 0) {
                System.out.println("The number cannot be negative.");
            } else if (count == 0) {
                System.out.println("No strangers to meet today.");
            } else {
                for (int i = 0; i < count; i++) {
                    System.out.print("Enter name: ");
                    if (scanner.hasNextLine()) {
                        String name = scanner.nextLine();
                        System.out.println("Hello, " + name);
                    }
                }
            }
        }

        scanner.close();
    }
}