import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] sizes = {20000, 40000, 80000, 160000, 320000};

        System.out.println("Bubble Sort");

        for (int size : sizes) {
            int[] arr = Main.generateRandomArray(size);
            long totalTime = 0;

            for (int i = 0; i < 15; i++) {
                int[] arrCopy = Arrays.copyOf(arr, arr.length); // Copiar el arreglo original
                long startTime = System.currentTimeMillis();
                bubbleSort(arrCopy,size); // Ordenar el arreglo copiado
                long endTime = System.currentTimeMillis();
                long executionTime = endTime - startTime;
                totalTime += executionTime;
            }

            double averageTime = totalTime / 15.0; // Calcular el tiempo promedio
            System.out.println("Tamaño del arreglo: " + size + " Tiempo promedio (ms): " + averageTime);
        }
    }

    static void bubbleSort(int arr[], int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }
    // https://www.geeksforgeeks.org/bubble-sort/
}
