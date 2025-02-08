import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int maxSize = 3000;  // Máximo de números a generar
        String outputFile = "sorted_numbers.txt"; // Archivo de salida donde se mostrarán los números ordenados
        int size = 10; //Cantidad de números que va a ordenar, esto se puede modificar 

        // 1. Generar y guardar los números aleatorios
        Generador.generateNumbers();
        
        // 2. Leer los números desde el archivo (leer todos pero usar el tamaño solicitado)
        Integer[] nums = Reader.readNumbers(maxSize);  // Leer los 3000 números
        Integer[] numsToSort = new Integer[size];  // Crear un array para los números a ordenar

        // 3. Copiar los primeros 'size' números al nuevo array
        System.arraycopy(nums, 0, numsToSort, 0, size);
        
        // 4. Aplicar el algoritmo de ordenamiento (ejemplo con InsertionSort)
        InsertionSort sorter = new InsertionSort();
        sorter.sort(numsToSort);

        // 5. Guardar los números ordenados en un archivo
        saveSortedNumbers(outputFile, numsToSort);  // Ahora pasamos numsToSort

        // 6. Mostrar los primeros valores ordenados (solo para confirmar)
        System.out.print("Primeros 10 números ordenados: ");
        for (int i = 0; i < Math.min(10, numsToSort.length); i++) {
            System.out.print(numsToSort[i] + " ");
        }
        System.out.println();
    }

    // Método para guardar los números ordenados en un archivo
    private static void saveSortedNumbers(String fileName, Integer[] numbers) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int num : numbers) {
                writer.write(num + "\n");  // Escribir solo los números ordenados
            }
            System.out.println("Números ordenados guardados en: " + fileName);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}

