package ex10;

import java.util.Arrays;

public class PriorityQueue {
    private int[] heap;
    private int size;

    public PriorityQueue() {
        heap = new int[10];
        size = 0;
    }

    private void resizeHeap() {
        heap = Arrays.copyOf(heap, heap.length * 2);
    }

    private void percolateUp(int index) {
        int parent = (index - 1) / 2;
        int value = heap[index];
        while (index > 0 && value > heap[parent]) {
            heap[index] = heap[parent];
            index = parent;
            parent = (index - 1) / 2;
        }
        heap[index] = value;
    }

    private void percolateDown(int index) {
        int child;
        int value = heap[index];
        while (index * 2 + 1 < size) {
            child = index * 2 + 1;
            if (child < size - 1 && heap[child] < heap[child + 1]) {
                child++;
            }
            if (value >= heap[child]) {
                break;
            }
            heap[index] = heap[child];
            index = child;
        }
        heap[index] = value;
    }

    public void insert(int value) {
        if (size == heap.length) {
            resizeHeap();
        }
        heap[size] = value;
        percolateUp(size);
        size++;
    }

    public int deleteMax() {
        if (size == 0) {
            throw new IllegalStateException("Priority queue is empty.");
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        percolateDown(0);
        return max;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Priority queue is empty.");
        }
        return heap[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}