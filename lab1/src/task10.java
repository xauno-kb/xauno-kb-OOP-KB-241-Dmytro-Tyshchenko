public class task10 {
    public static void main(String[] args) {
        int[] numbers = {12, 5, 27, 8, 33, 19};
        System.out.println("Maximum value: " + max(numbers));
    }

    public static int max(int[] array) {
        int maxVal = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }

        return maxVal;
    }
}