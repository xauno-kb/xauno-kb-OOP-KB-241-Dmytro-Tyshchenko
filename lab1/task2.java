import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter data: ");

        if (scanner.hasNextInt()) {
            int totalSeconds = scanner.nextInt();

            int hours = (totalSeconds / 3600) % 24;
            int minutes = (totalSeconds % 3600) / 60;
            int seconds = totalSeconds % 60;

            System.out.print("Result: ");
            System.out.printf("%d:%02d:%02d\n", hours, minutes, seconds);
        }

        scanner.close();
    }
}