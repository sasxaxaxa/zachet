package ex5;

import java.util.NoSuchElementException;

public class Queue<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        E firstElement = head.element;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return firstElement;
    }

    public E front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return head.element;
    }
}