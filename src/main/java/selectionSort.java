public class selectionSort {
    public static void main(String[] args) {
        int[] array1 = Main.randomArray(10000);
        int[] array2 = Main.randomArray(100000);
        int[] array3 = Main.randomArray(1000000);

        int numberOfExecutions = 15;

        long totalTime1 = 0, totalTime2 = 0, totalTime3 = 0;

        for (int i = 0; i < numberOfExecutions; i++) {
            totalTime1 += Main.measureTime(() -> SelectionSort(array1));
        }
        long averageTime1 = totalTime1 / numberOfExecutions;
        System.out.println("Tiempo promedio de ordenación para 10,000 elementos: " + averageTime1 + " milisegundos");

        for (int i = 0; i < numberOfExecutions; i++){
            totalTime2 += Main.measureTime(() -> SelectionSort(array2));
        }
        long averageTime2 = totalTime2 / numberOfExecutions;
        System.out.println("Tiempo promedio de ordenación para 100,000 elementos: " + averageTime2 + " milisegundos");

        for (int i = 0; i < numberOfExecutions; i++){
            totalTime3 += Main.measureTime(() -> SelectionSort(array3));
        }
        long averageTime3 = totalTime3 / numberOfExecutions;
        System.out.println("Tiempo promedio de ordenación para 1,000,000 elementos: " + averageTime3 + " milisegundos");


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
