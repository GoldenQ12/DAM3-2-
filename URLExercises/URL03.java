
import java.net.*;
import java.util.Scanner;


public class URL03{
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una URL: ");
        
        String url = sc.nextLine();

        try{
            URL u = new URL(url);
            URLConnection uc = u.openConnection();
            System.out.println("Tipo de contenido: " + uc.getContentType());
            System.out.println("Codificación: " + uc.getContentEncoding());
            System.out.println("Milisecs / 1999: " + uc.getDate());
            System.out.println("Fecha: " + new java.util.Date(uc.getDate()));
            System.out.println("Fecha modificada: " + new java.util.Date(uc.getLastModified()));
            System.out.println("Fecha expiración: " + new java.util.Date(uc.getExpiration()));
            System.out.println("Tamaño: " + uc.getContentLength());
            sc.close();

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}