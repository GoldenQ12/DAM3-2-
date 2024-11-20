import java.net.*;
import java.util.Scanner;
import java.io.*;


public class URL02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una URL: ");
        String url = sc.nextLine();

        try {
            URI uri = new URI(url);
            URL urlLink = uri.toURL();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlLink.openStream()));
            String linea;
            while ((linea = in.readLine()) != null) {
                System.out.println(linea);
            }

            in.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        sc.close();
    }


}

