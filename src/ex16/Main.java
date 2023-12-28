package ex16;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        // тест сортировок есть в папке sortirovki

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  // Время выполнения в наносекундах
        System.out.println("Время выполнения: " + duration + " нс");
    }
}
