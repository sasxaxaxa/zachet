package ex1.circular;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.insertAtBeginning(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.display(); // Output: 1 2 3
        list.delete(2);
        list.display(); // Output: 1 3
    }
}