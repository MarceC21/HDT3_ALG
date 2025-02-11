public class SelectionSort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        int n = array.length; // Longitud del array
        int numUnsorted = n;  // Cantidad de elementos no ordenados
        int max;              // Índice del mayor valor encontrado

        while (numUnsorted > 0) {
            max = 0; // el indice del mayor valor sera 0

            // Encontrar el mayor valor en la parte no ordenada
            for (int index = 1; index < numUnsorted; index++) {
                if (array[index].compareTo(array[max]) > 0) { 
                    max = index;
                }
            }

            // Intercambiar el mayor valor encontrado con el último de la parte no ordenada
            swap(array, max, numUnsorted - 1);
            numUnsorted--; // Reducir la parte no ordenada
        }
    }

    // Método para intercambiar dos elementos en el array
    private <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
