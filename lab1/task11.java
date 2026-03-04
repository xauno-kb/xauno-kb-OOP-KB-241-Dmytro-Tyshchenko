public class task11 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        System.out.println("Sum of even numbers: " + sum(numbers));
    }

    public static int sum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int total = 0;
        for (int num : array) {
            if (num % 2 == 0) {
                total += num;
            }
        }
        return total;
    }
}