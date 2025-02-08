import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int maxSize = 3000;  // Máximo de números a generar
        String inputFile = "numeros.txt";  // Asegurar que coincida con Generador
        String outputFile = "sorted_numbers.txt"; // Archivo de salida

        // 1. Generar y guardar los números aleatorios
        Generador.generateNumbers();
        
        // 2. Probar con diferentes tamaños
        int[] sizes = {10, 50, 100, 500, 1000, 3000};

        for (int size : sizes) {
            System.out.println("\nOrdenando " + size + " números:");

            // 3. Leer los números desde el archivo
            Integer[] nums = Reader.readNumbers(size);
            
            // 4. Aplicar el algoritmo de ordenamiento (ejemplo con InsertionSort)

            // 5. Guardar los números ordenados en un archivo
            saveSortedNumbers(outputFile, nums);

            // 6. Mostrar los primeros valores ordenados (opcional)
            System.out.print("Primeros 10 números ordenados: ");
            for (int i = 0; i < Math.min(10, nums.length); i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        }
    }

    // Método para guardar los números ordenados en un archivo
    private static void saveSortedNumbers(String fileName, Integer[] numbers) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int num : numbers) {
                writer.write(num + "\n");
            }
            System.out.println("Números ordenados guardados en: " + fileName);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}

