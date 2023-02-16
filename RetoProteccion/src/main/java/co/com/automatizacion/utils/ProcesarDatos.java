package co.com.automatizacion.utils;

import java.util.List;

public class ProcesarDatos {

    static String archivoCSV = "C:\\CURSOS Y CERTIFICACIONES\\RetoPro\\RetoProteccion\\src\\main\\java\\co\\com\\automatizacion\\resources\\DatosCore.csv";
    static String DatosExtra = "C:\\CURSOS Y CERTIFICACIONES\\RetoPro\\RetoProteccion\\src\\main\\java\\co\\com\\automatizacion\\resources\\DatosExtra.txt";
    String Validaciones = "C:\\CURSOS Y CERTIFICACIONES\\RetoPro\\RetoProteccion\\src\\main\\java\\co\\com\\automatizacion\\resources\\Validaciones.csv";
    static LeerCSV lector = new LeerCSV(archivoCSV);
    static LeerCSV lector2 = new LeerCSV(DatosExtra);
    static List<String[]> datos = lector.leer();
    static List<String[]> datos2 = lector2.leer();
    static int i = 1;
    static int j = 1;
    static int k = 1;
    static AgregarInformacion agregar = new AgregarInformacion();

    public static void procesar(){
        // Aquí puedes procesar los datos como desees, por ejemplo, imprimirlos
        for (String[] fila : datos2) {
            j = 1;
            for (String[] fila2 : datos) {
                try {
                    Long num1 = Long.parseLong(fila2[1].replaceAll("^0+", ""));
                    Long num2 = Long.parseLong(fila[1].replaceAll("^0+", ""));
                    if (String.valueOf(num1).equals(String.valueOf(num2))) {
                        k = k + 1;
                        if (i == k) {
                            agregar.agregarDataBasica(archivoCSV, i + 1, fila);
                        } else {
                            k = i;
                        }

                    }
                } catch (Exception e) {
                    System.out.println("fallo: " + e);
                }
                j = j + 1;
            }
            i = i + 1;
        }
    }
}
