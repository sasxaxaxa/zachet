package sortirovki;

public class TimeTest {
    public static void main(String[] args) {

        long startTime = System.nanoTime();
//
//        Bubble bubble = new Bubble();
//        Count count = new Count();
//        Merge merge = new Merge();
//        Pyramid pyramid = new Pyramid();
        Quick quick = new Quick();
//        Selection selection = new Selection();
//        Shell shell = new Shell();


        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  // Время выполнения в наносекундах
        System.out.println("Время выполнения: " + duration + " нс");
    }
}
