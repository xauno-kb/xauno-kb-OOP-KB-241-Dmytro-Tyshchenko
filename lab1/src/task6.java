import java.util.Scanner;

public class task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input data: ");

        if (scanner.hasNextDouble()) {
            double billAmount = scanner.nextDouble();

            if (scanner.hasNextInt()) {
                int numberOfFriends = scanner.nextInt();

                if (billAmount < 0 || numberOfFriends <= 0) {
                    System.out.println("Invalid input: Bill cannot be negative and friends must be more than zero.");
                } else {
                    double totalWithTip = billAmount * 1.10;
                    double share = totalWithTip / numberOfFriends;

                    System.out.println("Result: " + (int) share);
                }
            }
        }

        scanner.close();
    }
}