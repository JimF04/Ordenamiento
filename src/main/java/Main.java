import java.util.Random;

public class Main {

    static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000000); // Números aleatorios en un rango
        }
        return arr;
    }
    public static void print_array(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

}
