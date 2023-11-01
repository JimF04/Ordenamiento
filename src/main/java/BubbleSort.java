public class BubbleSort {

    public static void main(String[] args) {
        int[] array1 = Main.randomArray(10000);
        int[] array2 = Main.randomArray(100000);
        int[] array3 = Main.randomArray(1000000);

        int numberOfExecutions = 15;

        long totalTime1 = 0, totalTime2 = 0, totalTime3 = 0;

        for (int i = 0; i < numberOfExecutions; i++) {
            totalTime1 += Main.measureTime(() -> bubbleSort(array1, array1.length));
        }
        long averageTime1 = totalTime1 / numberOfExecutions;
        System.out.println("Tiempo promedio de ordenación para 10,000 elementos: " + averageTime1 + " milisegundos");

        for (int i = 0; i < numberOfExecutions; i++){
            totalTime2 += Main.measureTime(() -> bubbleSort(array2, array2.length));
        }
        long averageTime2 = totalTime2 / numberOfExecutions;
        System.out.println("Tiempo promedio de ordenación para 100,000 elementos: " + averageTime2 + " milisegundos");

        for (int i = 0; i < numberOfExecutions; i++){
            totalTime3 += Main.measureTime(() -> bubbleSort(array3, array3.length));
        }
        long averageTime3 = totalTime3 / numberOfExecutions;
        System.out.println("Tiempo promedio de ordenación para 1,000,000 elementos: " + averageTime3 + " milisegundos");

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
