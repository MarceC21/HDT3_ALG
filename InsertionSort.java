public class InsertionSort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            T temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(temp) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        // Prueba del algoritmo con números aleatorios
        Integer[] data = {5, 3, 8, 1, 2, 7, 4};
        InsertionSort sorter = new InsertionSort();
        sorter.sort(data);

        // Mostrar resultado
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}
