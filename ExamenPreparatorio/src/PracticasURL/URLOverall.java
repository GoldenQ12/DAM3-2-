package PracticasURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URLOverall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1; // Inicializar con un valor que no sea válido

        do {
            clearConsole(); // Limpiar la consola antes de mostrar el menú
            showMenu();
            System.out.println("Introduce una opción: ");
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
                continue; // Volver a mostrar el menú
            }

            switch (opcion) {
                case 1:
                    PropiedadesURL(sc);
                    break;
                case 2:
                    LeerContenidoURL();
                    break;
                case 3:
                    CondicionalesMIME();
                    break;
                case 0:
                    System.out.println("Chau pescau");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        } while (opcion != 0);

        sc.close();
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Error al limpiar la consola: " + e.getMessage());
        }
    }

    public static void showMenu() {
        System.out.println("BIENVENIDO AL REPASO DE URL, AQUI TIENES LAS DISTINTAS OPCIONES");
        System.out.println("----------------------------------------------------------------");
        System.out.println("1.- Propiedades de URL");
        System.out.println("2.- Leer contenido de URL");
        System.out.println("3.- Condicionales de MIME");
        System.out.println("0.- Salir");
    }

    public static void PropiedadesURL(Scanner sc) {
        System.out.println("Introduce una URL: ");
        String urlText = sc.nextLine();
        try {
            URL url = new URL(urlText);
            System.out.println("Protocolo: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Puerto: " + (url.getPort() == -1 ? "No especificado" : url.getPort()));
            System.out.println("Ruta: " + url.getPath());
            System.out.println("Consulta: " + url.getQuery());
            System.out.println("Fragmento: " + url.getRef());
        } catch (MalformedURLException e) {
            System.out.println("URL mal formada: " + e.getMessage());
        }
        waitForEnter(); // Esperar a que el usuario presione Enter
    }

    public static void LeerContenidoURL() {
        // Implementar la lógica para leer contenido de una URL
    	System.out.println("Introduce una URL: ");
        Scanner sc = new Scanner(System.in);
		String urlText = sc.nextLine();
        try {
        	URI uri = new URI(urlText);
            URL urlLink = uri.toURL();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlLink.openStream()));
            String linea;
            while ((linea = in.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (MalformedURLException e) {
            System.out.println("URL mal formada: " + e.getMessage());
        } catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        waitForEnter(); // Esperar a que el usuario presione Enter
    }

    public static void CondicionalesMIME() {
        System.out.println("Introduce una URL: ");
        Scanner sc = new Scanner(System.in);
        String urlText = sc.nextLine();
        try {
            URI uri = new URI(urlText);
            URL urlLink = uri.toURL();
            URLConnection connection = urlLink.openConnection();
            connection.connect();

            // Obtener el tipo de contenido
            String contentType = connection.getContentType();
            System.out.println("Tipo de contenido: " + contentType);

            // Verificar el tipo de contenido y realizar acciones
            if (contentType != null) {
                if (contentType.equals("image/gif")) {
                    System.out.println("Es un GIF. Realizando acción para GIF...");
                    // Aquí puedes agregar la lógica específica para GIF
                } else if (contentType.equals("image/png")) {
                    System.out.println("Es un PNG. Realizando acción para PNG...");
                    // Aquí puedes agregar la lógica específica para PNG
                } else if (contentType.equals("image/jpeg")) {
                    System.out.println("Es un JPEG. Realizando acción para JPEG...");
                    // Aquí puedes agregar la lógica específica para JPEG
                } else if (contentType.equals("text/html")) {
                    System.out.println("Es un HTML. Mostrando contenido...");
                    // Aquí puedes agregar la lógica para mostrar el contenido HTML
                    // Por ejemplo, leer el contenido de la URL y mostrarlo
                    try (Scanner htmlScanner = new Scanner(urlLink.openStream())) {
                        while (htmlScanner.hasNextLine()) {
                            System.out.println(htmlScanner.nextLine());
                        }
                    }
                } else {
                    System.out.println("Tipo de contenido no manejado: " + contentType);
                }
            } else {
                System.out.println("No se pudo determinar el tipo de contenido.");
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        waitForEnter(); // Esperar a que el usuario presione Enter
    }

    public static void waitForEnter() {
        System.out.println("Presiona Enter para continuar...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine(); // Esperar a que el usuario presione Enter
    }
}