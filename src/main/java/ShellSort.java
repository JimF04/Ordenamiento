public class ShellSort {
    public static void main(String[] args) {
        int[] sizes = {10000, 100000, 200000, 300000, 400000, 500000, 600000, 700000, 800000, 1000000};

        System.out.println("Shell Sort");

        for (int size : sizes) {
            long totalTime = 0;

            for (int i = 0; i < 15; i++) {
                int[] arr = Main.generateRandomArray(size);
                long startTime = System.currentTimeMillis();
                shellSort(arr); // Ordenar el arreglo copiado
                long endTime = System.currentTimeMillis();
                long executionTime = endTime - startTime;
                totalTime += executionTime;
            }

            double averageTime = totalTime / 15.0; // Calcular el tiempo promedio
            System.out.println("Tamaño del arreglo: " + size + " Tiempo promedio (ms): " + averageTime);
        }
    }
    public static int shellSort(int arr[])
    {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = arr[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
            }
        }
        return 0;
    }
    // https://www.geeksforgeeks.org/shellsort/
}
