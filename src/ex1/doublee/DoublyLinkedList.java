package ex1.doublee;

class DoublyLinkedList {
    Node head;

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    public void pop() {
        if (head == null) {
            return;
        }
        head = head.next;
        head.prev = null;
    }

    public void insert(int data, Node prevNode) {
        if (prevNode == null) {
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        if (prevNode.next != null) {
            prevNode.next.prev = newNode;
        }
        prevNode.next = newNode;
    }

    public void remove(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            head.prev = null;
            return;
        }
        Node temp = head;
        while (temp != null && temp.data != data) {
            temp = temp.next;
        }
        if (temp == null) {
            return;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        temp.prev.next = temp.next;
    }
}