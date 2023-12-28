package ex17;

public class LineralSearch {

    public static int linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;  // Наилучший случай: O(1)
            }
        }
        return -1;  // Худший случай: O(n), где n - длина массива.
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int target = 3;
        int result = linearSearch(array, target);
        if (result != -1) {
            System.out.println("Элемент найден на позиции " + result);
        } else {
            System.out.println("Элемент не найден");
        }
    }
}

