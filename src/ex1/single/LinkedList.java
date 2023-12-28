package ex1.single;


class LinkedList {
    Node head;

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void pop() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    public void insert(int data, Node prevNode) {
        if (prevNode == null) {
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    public void remove(int data) {
        Node temp = head;
        Node prev = null;

        if (temp != null && temp.data == data) {
            head = temp.next;
            return;
        }

        while (temp != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        prev.next = temp.next;
    }
}