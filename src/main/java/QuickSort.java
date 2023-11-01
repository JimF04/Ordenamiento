import java.util.Arrays;
import java.util.Stack;

public class QuickSort {
    public static void main(String[] args) {
        int[] sizes = {10000, 100000, 250000, 500000, 1000000};

        System.out.println("Quick Sort");

        for (int size : sizes) {
            int[] arr = Main.generateRandomArray(size);
            long totalTime = 0;

            for (int i = 0; i < 15; i++) {
                int[] arrCopy = Arrays.copyOf(arr, arr.length); // Copiar el arreglo original
                long startTime = System.currentTimeMillis();
                quickSort(arrCopy,0, size-1); // Ordenar el arreglo copiado
                long endTime = System.currentTimeMillis();
                long executionTime = endTime - startTime;
                totalTime += executionTime;
            }

            double averageTime = totalTime / 15.0; // Calcular el tiempo promedio
            System.out.println("Tamaño del arreglo: " + size + " Tiempo promedio (ms): " + averageTime);
        }
    }
    // method to find the partition position
    public static int partition(int array[], int low, int high) {

        // choose the rightmost element as pivot
        int pivot = array[high];

        // pointer for greater element
        int i = (low - 1);

        // traverse through all elements
        // compare each element with pivot
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {

                // if element smaller than pivot is found
                // swap it with the greatr element pointed by i
                i++;

                // swapping element at i with element at j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }

        // swapt the pivot element with the greater element specified by i
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // return the position from where partition is done
        return (i + 1);
    }

    public static void quickSort(int array[], int low, int high) {
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            if (low < high) {
                int pi = partition(array, low, high);

                if (pi - 1 > low) {
                    stack.push(low);
                    stack.push(pi - 1);
                }

                if (pi + 1 < high) {
                    stack.push(pi + 1);
                    stack.push(high);
                }
            }
        }
    }
    // https://www.programiz.com/dsa/quick-sort
}
