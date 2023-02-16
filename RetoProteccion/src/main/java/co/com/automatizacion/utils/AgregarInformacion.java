package co.com.automatizacion.utils;

import java.io.*;
import java.util.Scanner;

public class AgregarInformacion {


    public void agregarDataBasica(String archivoCSV, int posicion, String[] fila){


        try {
            // Abre el archivo en modo de lectura
            File file = new File(archivoCSV);
            BufferedReader br = new BufferedReader(new FileReader(file));

            // Crea un archivo temporal para escribir los cambios
            File tempFile = new File("temp.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

            // Busca la línea específica y agrega la información adicional
            String line;
            int lineNumber = posicion; // Número de línea a la que se le desea agregar información adicional
            int currentLine = 1;
            while ((line = br.readLine()) != null) {
                if (currentLine == lineNumber) {
                    line += "                       "+fila[2]+ ";"+ fila[3]+";"+fila[4]+";"+fila[5]+";"+fila[6];
                }
                bw.write(line + System.lineSeparator());
                currentLine++;
            }

            // Cierra los archivos
            br.close();
            bw.close();

            // Sobreescribe el archivo original con el archivo temporal
            if (!file.delete()) {
                throw new IOException("No se pudo eliminar el archivo original");
            }
            if (!tempFile.renameTo(file)) {
                throw new IOException("No se pudo renombrar el archivo temporal");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int auxContador=1;
    public void agregarValidaciones(String archivoCSV, int posicion, String[] validaciones){


        try {
            // Abre el archivo en modo de lectura
            File file = new File(archivoCSV);
            BufferedReader br = new BufferedReader(new FileReader(file));

            // Crea un archivo temporal para escribir los cambios
            File tempFile = new File("temp.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

            // Busca la línea específica y agrega la información adicional
            String line;
            int lineNumber = posicion; // Número de línea a la que se le desea agregar información adicional
            int currentLine = 1;
            while ((line = br.readLine()) != null) {
                if(auxContador==1){
                    line+=";Fecha inicial antes que final;duracion transaccion;valor transaccion;anio 2019";
                    auxContador++;
                }
                if (currentLine == lineNumber) {
                    //System.out.println( "         "+ validaciones[0]+";"+ validaciones[1]+";"+ validaciones[2]+";"+ validaciones[3]);
                    line += ";" + validaciones[0]+";"+ validaciones[1]+";"+ validaciones[2]+";"+ validaciones[3];
                }
                bw.write(line + System.lineSeparator());
                currentLine++;
            }

            // Cierra los archivos
            br.close();
            bw.close();

            // Sobreescribe el archivo original con el archivo temporal
            if (!file.delete()) {
                throw new IOException("No se pudo eliminar el archivo original");
            }
            if (!tempFile.renameTo(file)) {
                throw new IOException("No se pudo renombrar el archivo temporal");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
