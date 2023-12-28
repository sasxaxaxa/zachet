package ex3;

public class Stack {
    private int maxSize; // максимальный размер стека
    private int top; // указатель на верхний элемент стека
    private int[] stackArray; // массив для хранения элементов стека

    // конструктор для инициализации стека
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1; // инициализация указателя на -1 (стек пуст)
    }

    // добавление элемента в стек
    public void push(int value) {
        stackArray[++top] = value;
    }

    // удаление элемента из стека
    public int pop() {
        return stackArray[top--];
    }

    // просмотр верхнего элемента стека
    public int peek() {
        return stackArray[top];
    }

    // проверка, является ли стек пустым
    public boolean isEmpty() {
        return (top == -1);
    }

    // проверка, является ли стек полным
    public boolean isFull() {
        return (top == maxSize - 1);
    }
}