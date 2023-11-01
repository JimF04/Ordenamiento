import java.util.Stack;

public class QuickSort {
    public static void main(String[] args) {
        int[] array1 = Main.randomArray(10000);
        int[] array2 = Main.randomArray(100000);
        int[] array3 = Main.randomArray(1000000);

        int numberOfExecutions = 15;

        long totalTime1 = 0, totalTime2 = 0, totalTime3 = 0;

        for (int i = 0; i < numberOfExecutions; i++) {
            totalTime1 += Main.measureTime(() -> quickSort(array1, 0, array1.length - 1));
        }
        long averageTime1 = totalTime1 / numberOfExecutions;
        System.out.println("Tiempo promedio de ordenación para 10,000 elementos: " + averageTime1 + " milisegundos");

        for (int i = 0; i < numberOfExecutions; i++){
            totalTime2 += Main.measureTime(() -> quickSort(array2, 0, array2.length - 1));
        }
        long averageTime2 = totalTime2 / numberOfExecutions;
        System.out.println("Tiempo promedio de ordenación para 100,000 elementos: " + averageTime2 + " milisegundos");

        for (int i = 0; i < numberOfExecutions; i++){
            totalTime3 += Main.measureTime(() -> quickSort(array3, 0, array3.length - 1));
        }
        long averageTime3 = totalTime3 / numberOfExecutions;
        System.out.println("Tiempo promedio de ordenación para 1,000,000 elementos: " + averageTime3 + " milisegundos");
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
