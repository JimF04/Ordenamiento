public class InsertionSort {
    public static void main(String[] args) {
        int[] sizes = {20000, 40000, 80000, 160000, 320000};

        System.out.println("Insertion Sort");

        for (int size : sizes) {
            long totalTime = 0;

            for (int i = 0; i < 15; i++) {
                int[] arr = Main.generateRandomArray(size);
                long startTime = System.currentTimeMillis();
                insertionSort(arr); // Ordenar el arreglo copiado
                long endTime = System.currentTimeMillis();
                long executionTime = endTime - startTime;
                totalTime += executionTime;
            }

            double averageTime = totalTime / 15.0; // Calcular el tiempo promedio
            System.out.println("Tamaño del arreglo: " + size + " Tiempo promedio (ms): " + averageTime);
        }
    }
    public static void insertionSort(int array[]) {
        int size = array.length;

        for (int step = 1; step < size; step++) {
            int key = array[step];
            int j = step - 1;

            // Compare key with each element on the left of it until an element smaller than
            // it is found.
            // For descending order, change key<array[j] to key>array[j].
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }

            // Place key at after the element just smaller than it.
            array[j + 1] = key;
        }
    }
    // https://www.programiz.com/dsa/insertion-sort
}
