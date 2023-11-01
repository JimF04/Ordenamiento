import java.util.Random;

public class Main {
    public static int[] randomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(); // Generar números aleatorios
        }
        return array;
    }
    public static long measureTime(Runnable function) {
        long startTime = System.currentTimeMillis();
        function.run();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void print_array(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

}
