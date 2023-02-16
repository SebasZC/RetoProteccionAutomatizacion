package co.com.automatizacion.task;

import co.com.automatizacion.questions.VerificarFechas;
import co.com.automatizacion.utils.AgregarInformacion;

import java.util.List;

public class AlmacenarValidaciones {
    static AgregarInformacion agregar = new AgregarInformacion();
    static double sumaValor = 0;

    static String[] validaciones = new String[4];
    public static void v1(String Validaciones, List<String[]> datos) {
        int i=0;
        int contador = 0;
        for (String[] filaValidacion : datos) {
            i++;
            try {
                String fechaIni = filaValidacion[3];
                String fechaFin = filaValidacion[4];
                Double valor = Double.parseDouble(filaValidacion[5].replaceAll("[^0-9]", ""));
                //System.out.println(valor);
                //System.out.println("ini: " + fechaIni + " --- fin: " + fechaFin);


                if (VerificarFechas.validarFechas(fechaIni, fechaFin) == 0) {
                    validaciones[0] = "NO CUMPLE la fecha esta al reves";
                } else {
                    validaciones[0] = "CUMPLE";
                }

                if (VerificarFechas.validarFechas(fechaIni, fechaFin) == 2) {
                    validaciones[1] = "CUMPLE";
                } else if ((VerificarFechas.validarFechas(fechaIni, fechaFin) == 1)) {
                    validaciones[1] = "NO CUMPLE,la txr supera el limite";
                }


                if (valor > 200000.0 || valor < 2500.0) {
                    validaciones[2] = "NO CUMPLE";
                } else {
                    validaciones[2] = "CUMPLE";
                    contador = contador + 1;
                    sumaValor = sumaValor + valor;
                }


                if (VerificarFechas.validarFechasDespuesAnio(2019, filaValidacion) != null) {
                    validaciones[3] = "CUMPLE";
                } else {
                    validaciones[3] = "NO CUMPLE";
                }

            } catch (Exception e) {
                System.out.println(e);
            }
            agregar.agregarValidaciones(Validaciones, i + 1, validaciones);
        }


    }


}
