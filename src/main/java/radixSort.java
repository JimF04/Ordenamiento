import java.util.Arrays;

public class radixSort {
    public static void main(String[] args) {
        int[] sizes = {10000, 100000, 200000, 300000, 400000, 500000, 600000, 700000, 800000, 1000000};

        System.out.println("Radix Sort");

        for (int size : sizes) {
            long totalTime = 0;

            for (int i = 0; i < 15; i++) {
                int[] arr = Main.generateRandomArray(size);
                long startTime = System.currentTimeMillis();
                radixsort(arr, size); // Ordenar el arreglo copiado
                long endTime = System.currentTimeMillis();
                long executionTime = endTime - startTime;
                totalTime += executionTime;
            }

            double averageTime = totalTime / 15.0; // Calcular el tiempo promedio
            System.out.println("Tamaño del arreglo: " + size + " Tiempo promedio (ms): " + averageTime);
        }
    }
    // A utility function to get maximum value in arr[]
    static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // the actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to the current
        // digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to sort arr[] of
    // size n using Radix Sort
    static void radixsort(int arr[], int n) {
        // Find the maximum number to know the number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing the digit number, exp is passed.
        // exp is 10^i where i is the current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
}
