import java.util.*;

public class RadixSort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        if (array.length == 0) return;

        // Verificar si los elementos son Integer
        if (!(array[0] instanceof Integer)) {
            throw new IllegalArgumentException("Radix solo sirve con los numeros enteros.");
        }

        Integer[] intArray = Arrays.copyOf(array, array.length, Integer[].class);
        radixSort(intArray);
        System.arraycopy(intArray, 0, array, 0, array.length);
    }

    private void radixSort(Integer[] array) {
        int max = Arrays.stream(array).max(Integer::compareTo).orElse(0);
        int valor = 1;

        while (max / valor > 0) {
            ContaryOrdenar(array, valor);
            valor *= 10;
        }
    }

    private void ContaryOrdenar(Integer[] array, int valor) {
        Integer[] salida = new Integer[array.length];  // Cambiado a Integer[] en lugar de int[]
        int[] contar = new int[10];

        for (int num : array) {
            contar[(num / valor) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            contar[i] += contar[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            salida[contar[(array[i] / valor) % 10] - 1] = array[i];
            contar[(array[i] / valor) % 10]--;
        }

        System.arraycopy(salida, 0, array, 0, array.length);
    }
}

