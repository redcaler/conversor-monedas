package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.ZonedDateTime;

public class ExchangerateApi {
    private ZonedDateTime time_last_updated;
//    private String base_code;
    private String simbolo;
    private String apikey = "fe229611d6107372e675a76c";
    private String monedaOrigen;
    private String monedaDestino;
    private Double conversion_rate;
    private Double conversion_result;
    private Double cantidad;
    private PairConversion pairConversion;

    private HttpClient client;
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public ExchangerateApi() {
        client = HttpClient.newHttpClient();
    }

    private HttpResponse<String> obtenerJsonApi (String url){
        HttpResponse<String> response = null;
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.body().contains("error") ){
                throw new RuntimeException("Moneda de origen o destino no encontrada");
            }
        }catch (Exception e){
            System.out.println("Error al conectar con la API de ExchangeRate");
        }
        return response;
    }

    public PairConversion conversion(String monedaOrigen, String monedaDestino, Double cantidad) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.cantidad = cantidad;
        String url = "https://v6.exchangerate-api.com/v6/" + apikey + "/pair/" + monedaOrigen + "/" + monedaDestino + "/" + cantidad;

        HttpResponse<String> response =  obtenerJsonApi(url);
//        System.out.println(response.body());

        PairConversionExchangeRateApi pairConvExchRApi = gson.fromJson(response.body(), PairConversionExchangeRateApi.class);
//        System.out.println(pairConvExchRApi);
        pairConversion = new PairConversion(pairConvExchRApi, cantidad);
//        System.out.println(pairConversion);

        return pairConversion;
    }

}
