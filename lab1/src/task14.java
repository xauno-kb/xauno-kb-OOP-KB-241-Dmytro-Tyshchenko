import java.util.Arrays;

public class task14 {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 2, 7, 4};
        Swapcycle(array1);
        System.out.println(Arrays.toString(array1));

        int[] array2 = {1, 3, 2, 7, 4};
        Swapcycle(array2, 3);
        System.out.println(Arrays.toString(array2));
    }

    public static void Swapcycle(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int lastElement = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = lastElement;
    }

    public static void Swapcycle(int[] array, int shift) {
        if (array == null || array.length <= 1 || shift <= 0 || shift == array.length) {
            return;
        }

        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            temp[(i + shift) % array.length] = array[i];
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = temp[i];
        }
    }
}