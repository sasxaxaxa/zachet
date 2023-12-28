package sortirovki;

import java.util.Arrays;

public class Count {
    public static void countSort(int array[]) {
        int size = array.length;
        int[] output = new int[size + 1];


        // Find the maximum value in the array
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }


        // Create count array and fill it with zeros
        int[] count = new int[max + 1];
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }


        // Find and store the count of each element
        for (int i = 0; i < size; i++) {
            count[array[i]]++;
        }


        // Calculate and store cummulative sum of elements of count array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }


        // Traverse the initial array from the end and place the elements
        // in output array into their respective positions
        for (int i = size - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }


        // Copy the sorted elements into the initial array
        for (int i = 0; i < size; i++) {
            array[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 20);
        }
        System.out.println(Arrays.toString(array));

        countSort(array);
        System.out.println(Arrays.toString(array));
    }
}
