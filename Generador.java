import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Generador {
    private static final String archivo = "numeros.txt";
    private static final int num = 3000; // Cantidad de números a generar
    private static final int max = 10000; // Valor máximo que puede tener un número
    public static void generateNumbers() {
        Random random = new Random();

        try (FileWriter writer = new FileWriter(archivo)) {
            for (int i = 0; i < num; i++) {
                int num = random.nextInt(max);
                writer.write(num + "\n");
            }
            System.out.println("Archivo generado: " + archivo);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

}