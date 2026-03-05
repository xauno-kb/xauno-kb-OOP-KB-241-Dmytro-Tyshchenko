import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int h = scanner.nextInt();

            if (a >= h) {
                System.out.println(1);
            } else if (a <= b) {
                System.out.println("Impossible");
            } else {
                int days = 1 + (int) Math.ceil((double) (h - a) / (a - b));
                System.out.println(days);
            }
        }

        scanner.close();
    }
}