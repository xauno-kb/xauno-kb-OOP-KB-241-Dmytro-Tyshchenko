import java.util.Scanner;

public class task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;

        while (scanner.hasNextInt()) {
            int current = scanner.nextInt();
            
            if (current == 0) {
                break;
            }

            if (current > max) {
                max = current;
            }
        }

        if (max != Integer.MIN_VALUE) {
            System.out.println("Result: " + max);
        }

        scanner.close();
    }
}