import java.net.*;
import java.util.Scanner;

public class URL01 {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una URL: ");
        String url = sc.nextLine();

        try {
            URL urlLink = new URL(url);
            System.out.println("Protocol: " + urlLink.getProtocol());
            System.out.println("Host: " + urlLink.getHost());
            System.out.println("File: " + urlLink.getFile());
            System.out.println("Port: " + urlLink.getPort());
            System.out.println("Ref: " + urlLink.getRef());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        sc.close();
    }
    
}