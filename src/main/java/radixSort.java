import java.util.Arrays;

public class radixSort {
    public static void main(String[] args) {
        int[] array1 = Main.randomArray(10000);
        int[] array2 = Main.randomArray(100000);
        int[] array3 = Main.randomArray(1000000);

        int numberOfExecutions = 15;

        long totalTime1 = 0, totalTime2 = 0, totalTime3 = 0;

        for (int i = 0; i < numberOfExecutions; i++) {
            totalTime1 += Main.measureTime(() -> RadixSort(array1));
        }
        long averageTime1 = totalTime1 / numberOfExecutions;
        System.out.println("Tiempo promedio de ordenación para 10,000 elementos: " + averageTime1 + " milisegundos");

        for (int i = 0; i < numberOfExecutions; i++){
            totalTime2 += Main.measureTime(() -> RadixSort(array2));
        }
        long averageTime2 = totalTime2 / numberOfExecutions;
        System.out.println("Tiempo promedio de ordenación para 100,000 elementos: " + averageTime2 + " milisegundos");

        for (int i = 0; i < numberOfExecutions; i++){
            totalTime3 += Main.measureTime(() -> RadixSort(array3));
        }
        long averageTime3 = totalTime3 / numberOfExecutions;
        System.out.println("Tiempo promedio de ordenación para 1,000,000 elementos: " + averageTime3 + " milisegundos");

    }
    // Método para obtener el máximo valor en un array
    public static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
    public static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // Array de salida
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Almacena el recuento de ocurrencias en count[]
        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Ajusta el conteo para obtener las posiciones correctas en el array de salida
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Construye el array de salida
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copia el array de salida a arr[], para que arr[] contenga los números ordenados según el dígito actual
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Método principal para realizar el radix sort
    public static void RadixSort(int arr[]) {
        int n = arr.length;
        int m = getMax(arr, n);

        // Realiza counting sort para cada dígito. En lugar de pasar el número exacto, se pasa el lugar del dígito.
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
}
