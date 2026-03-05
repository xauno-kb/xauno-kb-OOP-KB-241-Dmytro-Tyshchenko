import java.util.Scanner;

public class task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextDouble()) {
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();

            double discriminant = b * b - 4 * a * c;

            if (discriminant < 0) {
                System.out.println("no roots");
            } else if (discriminant == 0) {
                double x = -b / (2 * a);
                System.out.println(x);
            } else {
                double x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
                System.out.println(x1 + " " + x2);
            }
        }

        scanner.close();
    }
}