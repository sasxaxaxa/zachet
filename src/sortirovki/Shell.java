package sortirovki;

import java.util.Arrays;

public class Shell {
    public static void shellSort(int array[])
    {
        int n = array.length;


        // Start with a maximum gap, then reduce it
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Apply insertion sort to the current gap size.
            for (int i = gap; i < n; i += 1)
            {
                int temp = array[i];


                // shift earlier sorted elements until
                // the correct position for a[i] is found
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap)
                {
                    array[j] = array[j - gap];
                }


                // put the original a[i] stored in temp in its correct position
                array[j] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 20);
        }
        System.out.println(Arrays.toString(array));
        shellSort(array);

        System.out.println(Arrays.toString(array));
    }
}
