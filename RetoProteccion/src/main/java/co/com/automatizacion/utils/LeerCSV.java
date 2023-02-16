package co.com.automatizacion.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeerCSV {
    private String archivo;

    public LeerCSV(String archivo) {
        this.archivo = archivo;
    }

    public List<String[]> leer() {
        List<String[]> datos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] fila = linea.split(";");
                try {
                    Pattern pattern = Pattern.compile("^[0-9]+$");
                    Matcher matcher = pattern.matcher(fila[1]);
                    if(matcher.matches()){
                        datos.add(fila);
                    }
                }catch (Exception e){}


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Datos desde clase");
        System.out.println(datos);
        return datos;

    }
}
