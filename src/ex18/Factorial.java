package ex18;

import java.util.Stack;

public class Factorial {
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(n);

        int result = 1;

        while (!stack.isEmpty()) {
            int num = stack.pop();
            result *= num;

            if (num > 1) {
                stack.push(num - 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));  // Вывод: 120
    }
}
