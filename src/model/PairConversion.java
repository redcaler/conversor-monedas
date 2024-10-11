package model;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class PairConversion {
    private ZonedDateTime localTime;
    private String base_code;
    private String target_code;
    private Double conversion_rate;
    private Double conversion_result;

    private Double cantidad;

    public PairConversion(PairConversionExchangeRateApi data, Double cantidad) {
        convertirFecha(data.time_last_update_utc());
        this.base_code = data.base_code();
        this.target_code = data.target_code();
        this.conversion_rate = data.conversion_rate();
        this.conversion_result = data.conversion_result();
        this.cantidad = cantidad;
    }

    private void convertirFecha(String fecha){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
        try {
            ZonedDateTime time_last_update_utc;
            time_last_update_utc = ZonedDateTime.parse(fecha, formatter);
            this.localTime = time_last_update_utc.withZoneSameInstant(ZoneId.systemDefault());
        } catch (DateTimeParseException e) {
            // Manejar el error de parseo de la fecha
            System.err.println("Error al parsear la fecha: " + e.getMessage());
        }
    }

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public Double getConversion_result() {
        return conversion_result;
    }

    @Override
    public String toString(){
        //El valor 25.e [USD] corresponde al valor final de =>>> 20293.75 [ARS]
        return "El valor " + cantidad +
                " [" + base_code + "] corresponde al valor final de =>>> " +
                conversion_result + " [" + target_code + "] | Fecha consulta: " +
                localTime.getDayOfMonth() + "/" +
                localTime.getMonthValue() + "/" +
                localTime.getYear() + ", " +
                localTime.getHour() + ":" +
                localTime.getMinute() + ".";
    }
//    @Override
//    public String toString() {
//        return "PairConversion{" +
//                "localTime=[" +
//                    localTime.getDayOfMonth() + " de " +
//                    localTime.getMonth() + " de " +
//                    localTime.getYear() + ", " +
//                    localTime.getHour() + ":" +
//                    localTime.getMinute() + ":" +
//                    localTime.getSecond() + " " +
//                    localTime.getZone() +
//                "]" +
//                ", base_code='" + base_code + '\'' +
//                ", target_code='" + target_code + '\'' +
//                ", conversion_rate=" + conversion_rate +
//                ", conversion_result=" + conversion_result +
//                '}';
//    }

}
