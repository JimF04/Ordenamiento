public class mergeSort {

    public static void main(String[] args) {
        int[] sizes = {10000, 100000, 200000, 300000, 400000, 500000, 600000, 700000, 800000, 1000000};

        System.out.println("Merge Sort");

        for (int size : sizes) {
            long totalTime = 0;

            for (int i = 0; i < 15; i++) {
                int[] arr = Main.generateRandomArray(size);
                long startTime = System.currentTimeMillis();
                MergeSort(arr,0, size-1); // Ordenar el arreglo copiado
                long endTime = System.currentTimeMillis();
                long executionTime = endTime - startTime;
                totalTime += executionTime;
            }

            double averageTime = totalTime / 15.0; // Calcular el tiempo promedio
            System.out.println("Tamaño del arreglo: " + size + " Tiempo promedio (ms): " + averageTime);
        }
    }

    // Merge two subarrays L and M into arr
    public static void merge(int arr[], int p, int q, int r) {

        // Create L ← A[p..q] and M ← A[q+1..r]
        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = arr[q + 1 + j];

        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
            k++;
        }

        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }
    }

    // Divide the array into two subarrays, sort them and merge them
    public static void MergeSort(int arr[], int l, int r) {
        if (l < r) {

            // m is the point where the array is divided into two subarrays
            int m = (l + r) / 2;

            MergeSort(arr, l, m);
            MergeSort(arr, m + 1, r);

            // Merge the sorted subarrays
            merge(arr, l, m, r);
        }
    }

    // https://www.programiz.com/dsa/merge-sort
}
