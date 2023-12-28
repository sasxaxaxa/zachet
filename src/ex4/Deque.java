package ex4;

import java.util.NoSuchElementException;

public class Deque<T> {
    private Node front;
    private Node rear;
    private int size;

    private class Node {
        T data;
        Node next;
        Node prev;

        public Node(T item) {
            this.data = item;
            this.next = null;
            this.prev = null;
        }
    }

    public Deque() {
        front = null;
        rear = null;
        size = 0;
    }

    public void pushFront(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }

    public void pushBack(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        size++;
    }

    public T popFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        T item = front.data;
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        size--;
        return item;
    }

    public T popBack() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        T item = rear.data;
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }
        size--;
        return item;
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return front.data;
    }

    public T peekBack() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return rear.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}