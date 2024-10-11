package utilidades;

public class HistorialConversiones {

    private String base_code;
    private String target_code;
    private Double cantidad;
    private Double conversion_result;

    public HistorialConversiones(String base_code, String target_code, Double cantidad, Double conversion_result){
        this.base_code = base_code;
        this.target_code = target_code;
        this.cantidad = cantidad;
        this.conversion_result = conversion_result;
    }

    @Override
    public String toString(){
        return "De " + cantidad + " [" + base_code + "] a " + conversion_result + " [" + target_code + "]";
    }
}
