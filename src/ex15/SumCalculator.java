package ex15;

import java.util.Stack;

public class SumCalculator {

    // Рекурсивный подход для вычисления суммы элементов массива
    public static int recursiveSum(int[] arr) {
        // Базовый случай: если массив пуст, возвращаем 0
        if (arr.length == 0) {
            return 0;
        }
        // Рекурсивный случай: возвращаем первый элемент + сумму оставшихся элементов
        return arr[0] + recursiveSum(java.util.Arrays.copyOfRange(arr, 1, arr.length));
    }

    // Имитация рекурсии с помощью стека
    public static int stackSum(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int value : arr) {
            stack.push(value);
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        // Рекурсивное вычисление суммы
        System.out.println("Сумма (рекурсия): " + recursiveSum(array));

        // Имитация рекурсии с помощью стека
        System.out.println("Сумма (стек): " + stackSum(array));
    }
}