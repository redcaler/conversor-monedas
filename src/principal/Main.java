package principal;

import model.ExchangerateApi;
import model.PairConversion;
import utilidades.HistorialConversiones;
import utilidades.MenuResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Creamos conexion
        ExchangerateApi exchangerateApi = new ExchangerateApi();
        PairConversion pairConversion;
        List<HistorialConversiones> history = new ArrayList<HistorialConversiones>();

        while (true){
            // Llamamos al menos principal
            MenuResult mr = menuPrincipal();
            // Condicional para salir del bucle | Show Historial
            if(mr.getMonedaOrigen().equals("EXIT")){
                System.out.println("\nGracias por usar el conversor de divisas EPM");
                if(!history.isEmpty()){
                    System.out.println("****************************************************");
                    System.out.println("Historial de conversiones");
                    for (HistorialConversiones hc: history){
                        System.out.println("> " + hc);
                    }
                }
                System.exit(0);
            }

            // Realizamos la conversion
            pairConversion = exchangerateApi.conversion(
                    mr.getMonedaOrigen(),
                    mr.getMonedaDestino(),
                    mr.getCantidad()
            );
            System.out.println(pairConversion);
            // Simulamos una pausa de programa
            System.out.println("\nPresiona Enter para continuar...");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();

            // Agregamos al historial
            history.add(new HistorialConversiones(
                    pairConversion.getBase_code(),
                    pairConversion.getTarget_code(),
                    pairConversion.getCantidad(),
                    pairConversion.getConversion_result()
            ));
          
        }
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
        // Validacion de opciones
        while (opcion < 1 || opcion > 8){
            System.out.println("!---> Opción no valida !");
            MenuResultOpciones();
            opcion = scanner.nextInt();
        }
        if(opcion == 8){
            return new MenuResult("EXIT", "EXIT", 0.0);
        }

        if(opcion == 7){
            return menuConversionPersonalizada();
        }else{
            System.out.println("Ingrese la cantidad a convertir: ");
            while(!scanner.hasNextDouble()){
                System.out.println("!--Entrada no valida, ingrese un número");
                scanner.next();
            }
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
                default:
                    System.out.println("Opción no valida");
            }
        }


        return null;
    }

    public static MenuResult menuConversionPersonalizada(){
        System.out.println("****************************************************");
        System.out.print("Ingrese la moneda de origen (USD, EUR, BRL, etc): ");
        Scanner scanner = new Scanner(System.in);
        String monedaOrigen = scanner.nextLine();
        System.out.print("Ingrese la moneda de destino (USD, EUR, BRL, etc): ");
        String monedaDestino = scanner.nextLine();
        System.out.println("****************************************************");
        System.out.println("Ingrese la cantidad a convertir: ");
        Double cantidad = scanner.nextDouble();
        return new MenuResult(monedaOrigen, monedaDestino, cantidad);
    }
}