package co.com.automatizacion;

import co.com.automatizacion.task.AlmacenarValidaciones;
import co.com.automatizacion.utils.CopyCSVFile;
import co.com.automatizacion.utils.LeerCSV;
import co.com.automatizacion.utils.ProcesarDatos;

import java.io.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String archivoCSV = "C:\\CURSOS Y CERTIFICACIONES\\RetoPro\\RetoProteccion\\src\\main\\java\\co\\com\\automatizacion\\resources\\DatosCore.csv";
        String Validaciones = "C:\\CURSOS Y CERTIFICACIONES\\RetoPro\\RetoProteccion\\src\\main\\java\\co\\com\\automatizacion\\resources\\Validaciones.csv";
        LeerCSV lector = new LeerCSV(archivoCSV);
        List<String[]> datos = lector.leer();

        CopyCSVFile.copy(archivoCSV, Validaciones);

        ProcesarDatos.procesar();

        AlmacenarValidaciones.v1(Validaciones,datos);
    }

}
