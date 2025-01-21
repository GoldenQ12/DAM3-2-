
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.*;
import java.util.Scanner;


public class URL04{
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una URL: ");
        

        try{
            URL u = new URL("https://imageupscaler.com/wp-content/uploads/2024/07/deblured-cutty-fox.jpg");
            URLConnection uc = u.openConnection();
            String ct = uc.getContentType();
            int cl = uc.getContentLength();

            if (ct.startsWith("/text") || cl == -1) {
                System.out.println("Tipo texto");
                sc.close();
                return;
            }

            InputStream is = uc.getInputStream();
            BufferedInputStream in = new BufferedInputStream(is);

            String file = u.getFile();
            file = file.substring(file.lastIndexOf('/')+1);

            String user = System.getProperty("user.home");
            FileOutputStream fout = new FileOutputStream(user + "/Desktop/prueba" + file);

            BufferedOutputStream out = new BufferedOutputStream(fout);

            int i;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
            out.flush();
            in.close();
            out.close();
            sc.close();

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}