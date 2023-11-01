public class ShellSort {
    public static void main(String[] args) {
        int[] array1 = Main.randomArray(10000);
        int[] array2 = Main.randomArray(100000);
        int[] array3 = Main.randomArray(1000000);

        int numberOfExecutions = 15;

        long totalTime1 = 0, totalTime2 = 0, totalTime3 = 0;

        for (int i = 0; i < numberOfExecutions; i++) {
            totalTime1 += Main.measureTime(() -> {
                shellSort(array1);
            }) ;
        }
        long averageTime1 = totalTime1 / numberOfExecutions;
        System.out.println("Tiempo promedio de ordenación para 10,000 elementos: " + averageTime1 + " milisegundos");

        for (int i = 0; i < numberOfExecutions; i++){
            totalTime2 += Main.measureTime(() -> shellSort(array2));
        }
        long averageTime2 = totalTime2 / numberOfExecutions;
        System.out.println("Tiempo promedio de ordenación para 100,000 elementos: " + averageTime2 + " milisegundos");

        for (int i = 0; i < numberOfExecutions; i++){
            totalTime3 += Main.measureTime(() -> shellSort(array3));
        }
        long averageTime3 = totalTime3 / numberOfExecutions;
        System.out.println("Tiempo promedio de ordenación para 1,000,000 elementos: " + averageTime3 + " milisegundos");
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
