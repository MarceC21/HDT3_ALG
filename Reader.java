import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private static final String FILE_NAME = "numeros.txt";

    public static Integer[] readNumbers(int count) {
        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null && numbers.size() < count) {
                numbers.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return numbers.toArray(new Integer[0]); // Convertimos a array de Integer
    }

}
