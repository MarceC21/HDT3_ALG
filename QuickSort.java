public class QuickSort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private <T extends Comparable<T>> void quickSort(T[] array, int bajo, int alto) {
        if (bajo < alto) {
            int pivotIndex = partition(array, bajo, alto);
            quickSort(array, bajo, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, alto);
        }
    }

    private <T extends Comparable<T>> int partition(T[] array, int bajo, int alto) {
        T pivot = array[alto]; 
        int i = bajo - 1; 

        for (int j = bajo; j < alto; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i + 1];
        array[i + 1] = array[alto];
        array[alto] = temp;
        return i + 1;
    }
}
