package co.com.automatizacion.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCSVFile {
    public static void copy(String original, String copia) {
        String csvFile = original; // ruta del archivo CSV original
        String newCsvFile = copia; // ruta del nuevo archivo CSV
        String line = "";
        String cvsSplitBy = ";"; // el separador de campos en el archivo CSV

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             FileWriter fw = new FileWriter(newCsvFile)) {

            // Lee l�nea por l�nea del archivo CSV original
            while ((line = br.readLine()) != null) {

                // Divide la l�nea en campos utilizando el separador especificado
                String[] fields = line.split(cvsSplitBy);

                // Escribe el segundo campo en el nuevo archivo CSV
                try {
                    fw.append(fields[1]);
                } catch (Exception e) {
                    //e.printStackTrace();
                }

                fw.append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
