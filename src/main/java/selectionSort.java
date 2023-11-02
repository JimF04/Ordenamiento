public class selectionSort {
    public static void main(String[] args) {
        int[] sizes = {20000, 40000, 80000, 160000, 320000};

        System.out.println("Selection Sort");

        for (int size : sizes) {
            long totalTime = 0;

            for (int i = 0; i < 15; i++) {
                int[] arr = Main.generateRandomArray(size);
                long startTime = System.currentTimeMillis();
                SelectionSort(arr); // Ordenar el arreglo copiado
                long endTime = System.currentTimeMillis();
                long executionTime = endTime - startTime;
                totalTime += executionTime;
            }

            double averageTime = totalTime / 15.0; // Calcular el tiempo promedio
            System.out.println("Tamaño del arreglo: " + size + " Tiempo promedio (ms): " + averageTime);
        }
    }
    public static void SelectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[index]){
                    index = j;//searching for lowest index
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }
    // https://www.javatpoint.com/selection-sort-in-java
}
