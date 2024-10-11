package modelApi;

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
        // Definir un formato para imprimir la fecha y hora
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss z");

        String fechaLocalFormateada = (localTime != null) ? localTime.format(outputFormatter) : "N/A";

        return "El valor " + cantidad +
                " [" + base_code + "] corresponde al valor final de =>>> " +
                conversion_result + " [" + target_code +
                "]\n\t| Última actualización de tasa: " + fechaLocalFormateada +
                ", Próxima actualización: " + localTime.plusDays(1).format(outputFormatter);
    }
}
