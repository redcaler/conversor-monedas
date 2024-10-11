package utilidades;

public class MenuResult{
    private String monedaOrigen;
    private String monedaDestino;
    private Double cantidad;

    public MenuResult(String monedaOrigen, String monedaDestino, Double cantidad){
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.cantidad = cantidad;
    }
    public Double getCantidad() {
        return cantidad;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

}
