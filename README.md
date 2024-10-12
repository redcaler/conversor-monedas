# Conversor de Monedas EPM

&#x20;

Bienvenido al repositorio del **Conversor de Monedas EPM**, una aplicación simple de conversión de divisas desarrollada en Java. Esta herramienta permite realizar conversiones entre diferentes monedas utilizando tasas de cambio actualizadas. La aplicación se ejecuta en la terminal y es perfecta para quienes buscan una manera rápida y efectiva de convertir divisas.

## Características

- Interfaz basada en terminal, sencilla y directa.
- Conversión entre monedas populares como **USD, ARS, BRL, PEN** y más.
- Opción de conversión personalizada para cualquier moneda, revisar las monedas soportadas en [https://www.exchangerate-api.com/docs/supported-currencies ](https://www.exchangerate-api.com/docs/supported-currencies )
- Historial de conversiones al finalizar la sesión.

## Tabla de Contenidos

- [Características](#características)
- [Ejecución del Programa](#ejecución-del-programa)
- [Ejemplo de Uso](#ejemplo-de-uso)
- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Historial de Conversiones](#historial-de-conversiones)
- [API Utilizada](#api-utilizada)
- [Licencia](#licencia)

## Ejecución del Programa

Para ejecutar el programa desde un entorno de desarrollo integrado (IDE) como **IntelliJ IDEA**, sigue los siguientes pasos:

1. Abre **IntelliJ IDEA** y selecciona **Open** para abrir el proyecto. Navega al directorio donde está ubicado el proyecto `conversor-moneda` y selecciónalo.

2. Asegúrate de que la biblioteca **Gson** esté agregada al proyecto. Puedes hacerlo haciendo clic derecho en el proyecto, seleccionando **Open Module Settings**, y luego añadiendo `gson-2.11.0.jar` en la sección **Libraries**.

3. En el explorador de proyectos de IntelliJ, navega al archivo `Main.java`, ubicado en el directorio `src/principal`.

4. Haz clic derecho en `Main.java` y selecciona **Run 'Main'** para ejecutar el programa.

## Ejemplo de Uso

Una vez ejecutado, la aplicación mostrará un menú con las siguientes opciones:

```
****************************************************
Bienvenido(a) al conversor de divisas EPM
1) Dolar => Peso Argentino
2) Peso Argentino => Dolar
3) Dolar => Real brasileño
4) Real brasileño => Dolar
5) Dolar => Sol Peruano
6) Sol Peruano => Dolar
7) Conversion personalizada
8) Salir
****************************************************
Elija una opcion valida:
```

Luego de seleccionar una opción válida, deberás ingresar la cantidad a convertir. La aplicación te mostrará el resultado de la conversión con la última tasa de cambio disponible. Si eliges la opción **7**, podrás ingresar manualmente los códigos de las monedas de origen y destino.

### Ejemplo:

```
Elija una opcion valida: 1
Ingrese la cantidad a convertir:
120
El valor 120.0 [USD] corresponde al valor final de =>>> 117530.4 [ARS]
| Última actualización de tasa: 11/10/2024 20:00:01 BOT, Próxima actualización: 12/10/2024 20:00:01 BOT

Presiona Enter para continuar...
```

## Requisitos

- **Java 17** o superior.
- Biblioteca **Gson** para el manejo de datos en formato JSON (para tasas de cambio actualizadas).

## Instalación

1. Clona el repositorio:
   ```sh
   git clone https://github.com/redcaler/conversor-monedas.git
   ```
2. Navega al directorio del proyecto:
   ```sh
   cd conversor-monedas
   ```
3. Compila el código fuente:
   ```sh
   javac -cp gson-2.11.0.jar src/principal/Main.java
   ```
4. Ejecuta el programa:
   ```sh
   java -cp .;gson-2.11.0.jar principal.Main
   ```

## Historial de Conversiones

Al finalizar la sesión, se muestra un resumen de todas las conversiones realizadas durante la ejecución del programa. Esto permite al usuario tener un registro claro de las conversiones realizadas.

## API Utilizada

El programa utiliza la **API de ExchangeRate** ([https://v6.exchangerate-api.com](https://v6.exchangerate-api.com)) para obtener las tasas de cambio actualizadas. Esto asegura que los valores mostrados durante las conversiones estén alineados con los tipos de cambio más recientes.

## Licencia

Este proyecto está bajo la **GNU GENERAL PUBLIC LICENSE Version 3**. Puedes ver más detalles en el archivo `LICENSE`.
