import java.util.Arrays;

public class task13 {
    public static void main(String[] args) {
        int[] input = {18, 1, 3, 6, 7, -5};
        int[] result = removeLocalMaxima(input);
        System.out.println(Arrays.toString(result));
    }

    public static int[] removeLocalMaxima(int[] array) {
        boolean[] isMax = new boolean[array.length];
        int countMax = 0;

        for (int i = 0; i < array.length; i++) {
            boolean leftOk = (i == 0) || (array[i] <= array[i - 1]);
            boolean rightOk = (i == array.length - 1) || (array[i] <= array[i + 1]);

            if (!leftOk && !rightOk) {
                isMax[i] = true;
                countMax++;
            }
        }

        int[] result = new int[array.length - countMax];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (!isMax[i]) {
                result[index++] = array[i];
            }
        }

        return result;
    }
}