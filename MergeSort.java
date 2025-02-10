import java.util.Arrays;

public class MergeSort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        if (array.length < 2) return;
        mergeSort(array, 0, array.length - 1);
    }

    private <T extends Comparable<T>> void mergeSort(T[] array, int izquierda, int derecha) {
        if (izquierda >= derecha) return;
        int medio = izquierda + (derecha - izquierda) / 2;  
        mergeSort(array, izquierda, medio);
        mergeSort(array, medio + 1, derecha);
        merge(array, izquierda, medio, derecha);
    }

    private <T extends Comparable<T>> void merge(T[] array, int izquierda, int medio, int derecha) {
        T[] izquierdaArray = Arrays.copyOfRange(array, izquierda, medio + 1);
        T[] derechaArray = Arrays.copyOfRange(array, medio + 1, derecha + 1);
        
        int i = 0, j = 0, k = izquierda;
        while (i < izquierdaArray.length && j < derechaArray.length) {
            if (izquierdaArray[i].compareTo(derechaArray[j]) <= 0) {
                array[k++] = izquierdaArray[i++];
            } 
            else {
                array[k++] = derechaArray[j++];
            }
        }
        
        while (i < izquierdaArray.length) array[k++] = izquierdaArray[i++];
        while (j < derechaArray.length) array[k++] = derechaArray[j++];
    }
}
