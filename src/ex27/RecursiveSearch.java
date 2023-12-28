package ex27;

public class RecursiveSearch {
    public static int recursiveBinarySearch(int arr[], int firstElement, int lastElement, int elementToSearch) {

        // termination condition
        if (lastElement >= firstElement) {
            int mid = firstElement + (lastElement - firstElement) / 2;

            // if the middle element is our goal element, return its index
            if (arr[mid] == elementToSearch)
                return mid;

            // if the middle element is bigger than the goal element
            // recursively call the method with narrowed data
            if (arr[mid] > elementToSearch)
                return recursiveBinarySearch(arr, firstElement, mid - 1, elementToSearch);

            // else, recursively call the method with narrowed data
            return recursiveBinarySearch(arr, mid + 1, lastElement, elementToSearch);
        }

        return -1;
    }
    public static void print(int elementToSearch, int index) {
        if (index == -1){
            System.out.println(elementToSearch + " not found.");
        }
        else {
            System.out.println(elementToSearch + " found at index: " + index);
        }
    }

    public static void main(String[] args) {
        int index = recursiveBinarySearch(new int[]{3, 22, 27, 47, 57, 67, 89, 91, 95, 99}, 0, 10, 95);
        print(95, index);
    }
}
