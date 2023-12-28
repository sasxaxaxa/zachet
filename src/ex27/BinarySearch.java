package ex27;


public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int target = 18;
        int result = binarySearch(arr, target);

        if (result == -1) {
            System.out.println("Элемент " + target + " не найден в массиве.");
        } else {
            System.out.println("Элемент " + target + " найден в позиции " + result + ".");
        }
    }
}
