package ex1.circular;


public class CircularLinkedList<T> {
    private ListNode<T> tail;

    public CircularLinkedList() {
        tail = null;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public void insertAtBeginning(T value) {
        ListNode<T> newNode = new ListNode<>(value);

        if (isEmpty()) {
            newNode.setNext(newNode);
            tail = newNode;
        } else {
            newNode.setNext(tail.getNext());
            tail.setNext(newNode);
        }
    }

    public void insertAtEnd(T value) {
        insertAtBeginning(value);
        tail = tail.getNext();
    }

    public void delete(T value) {
        if (!isEmpty()) {
            ListNode<T> current = tail.getNext();

            if (current != tail && current.getValue().equals(value)) {
                tail.setNext(current.getNext());
            } else {
                while (current != tail && !current.getNext().getValue().equals(value)) {
                    current = current.getNext();
                }

                if (current != tail) {
                    current.setNext(current.getNext().getNext());
                    if (current.getNext() == tail) {
                        tail = current;
                    }
                }
            }
        }
    }

    public void display() {
        if (!isEmpty()) {
            ListNode<T> current = tail.getNext();

            while (current != tail) {
                System.out.print(current.getValue() + " ");
                current = current.getNext();
            }

            System.out.print(current.getValue());
        }
    }
}

