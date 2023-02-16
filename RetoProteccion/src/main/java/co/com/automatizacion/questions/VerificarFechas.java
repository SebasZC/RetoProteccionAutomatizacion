package co.com.automatizacion.questions;

import co.com.automatizacion.utils.AgregarInformacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class VerificarFechas { ;

    static SimpleDateFormat formatoFecha = new SimpleDateFormat("d/M/yyyy");
    public static int validarFechas(String fechaInicial, String fechaFinal) throws ParseException {

        Calendar calFechaInicial = Calendar.getInstance();
        Calendar calFechaFinal = Calendar.getInstance();

        try {
            Date dateFechaInicial = formatoFecha.parse(fechaInicial);
            calFechaInicial.setTime(dateFechaInicial);
            Date dateFechaFinal = formatoFecha.parse(fechaFinal);
            calFechaFinal.setTime(dateFechaFinal);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar limiteFechaFinal = (Calendar) calFechaInicial.clone();
        limiteFechaFinal.add(Calendar.MONTH,2);
        limiteFechaFinal.add(Calendar.DAY_OF_MONTH,-1);
        

        // Verificar que la fecha final esté después de la fecha inicial
        if (calFechaFinal.before(calFechaInicial)) {
            return 0;
        }

        // Verificar que ambas fechas terminen antes del último día del segundo mes a la fecha inicial
        if (calFechaFinal.after(limiteFechaFinal)) {
            return 1;
        }else {
            return 2;
        }


    }

    public static String validarFechasDespuesAnio(int anio, String[] filaValidacion) throws ParseException {

        Calendar calFecha = Calendar.getInstance();
        calFecha.setTime(formatoFecha.parse(filaValidacion[3]));
        if (calFecha.get(Calendar.YEAR) == anio) {
            return filaValidacion[3];
        }else {
            return null;
        }
    }

}
