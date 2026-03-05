import java.util.Scanner;

public class task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;

        while (scanner.hasNextInt()) {
            int current = scanner.nextInt();

            if (current == 0) {
                break;
            }

            sum += current;
            count++;
        }

        if (count > 0) {
            int average = sum / count;
            System.out.println("Result: " + average);
        }

        scanner.close();
    }
}