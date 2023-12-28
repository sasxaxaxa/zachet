package ex4;

public class Tester {
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();

        deque.pushFront(1);
        deque.pushFront(2);
        deque.pushBack(3);
        deque.pushBack(4);

        System.out.println(deque.peekFront()); // Вывод: 2
        System.out.println(deque.peekBack()); // Вывод: 4

        System.out.println(deque.popFront()); // Вывод: 2
        System.out.println(deque.popBack()); // Вывод: 4

        System.out.println(deque.size()); // Вывод: 2
        System.out.println(deque.isEmpty()); // Вывод: false
    }

}

