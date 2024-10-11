import model.ExchangerateApi;
import model.PairConversion;
import utilidades.HistorialConversiones;
import utilidades.MenuResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        String monedaOrigen = "USD";
        String monedaDestino = "EUR";
        Double cantidad = 100.0;
        ExchangerateApi exchangerateApi = new ExchangerateApi();
        PairConversion pairConversion;

        MenuResult mr = menuPrincipal();
        pairConversion = exchangerateApi.conversion(
                mr.getMonedaOrigen(),
                mr.getMonedaDestino(),
                mr.getCantidad()
        );

        List<HistorialConversiones> history = new ArrayList<HistorialConversiones>();
        history.add(new HistorialConversiones(
                pairConversion.getBase_code(),
                pairConversion.getTarget_code(),
                pairConversion.getCantidad(),
                pairConversion.getConversion_result()
        ));

        System.out.println(pairConversion);
        System.out.println(history.get(0));


    }

    public static void MenuResultOpciones(){
        System.out.println("****************************************************");
        System.out.println("Bienvenido(a) al conversor de divisas EPM");
        System.out.println("1) Dolar => Peso Argentino");
        System.out.println("2) Peso Argentino => Dolar");
        System.out.println("3) Dolar => Real brasileño");
        System.out.println("4) Real brasileño => Dolar");
        System.out.println("5) Dolar => Sol Peruano");
        System.out.println("6) Sol Peruano => Dolar");
        System.out.println("7) Conversion personalizada");
        System.out.println("8) Salir");
        System.out.println("****************************************************");
        System.out.print("Elija una opcion valida: ");
    }

    public static MenuResult menuPrincipal(){
        MenuResultOpciones();
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        System.out.println("Ingrese la cantidad a convertir: ");
        Double cantidad = scanner.nextDouble();

        switch (opcion){
            case 1:
                return new MenuResult("USD", "ARS", cantidad);
            case 2:
                return new MenuResult("ARS", "USD", cantidad);
            case 3:
                return new MenuResult("USD", "BRL", cantidad);
            case 4:
                return new MenuResult("BRL", "USD", cantidad);
            case 5:
                return new MenuResult("USD", "PEN", cantidad);
            case 6:
                return new MenuResult("PEN", "USD", cantidad);
            case 7:
                return menuConversionPersonalizada();
            case 8:
                System.out.println("Gracias por usar el conversor de divisas EPM");
                System.exit(0);
            default:
                System.out.println("Opción no valida");
        }

        return null;
    }

    public static MenuResult menuConversionPersonalizada(){
        System.out.println("****************************************************");
        System.out.println("Ingrese la moneda de origen (USD, EUR, BRL, etc): ");
        System.out.println("Ingrese la moneda de destino (USD, EUR, BRL, etc): ");
        System.out.println("****************************************************");
        return null;
    }
}