package socketsTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Cliente {

    public static void main(String[] args) {
        String host="Localhost";
        int puerto=6000;

        System.setProperty("javax.net.ssl.trustStore","certificados/UsuarioAlmacenSSL");
        System.setProperty("javax.net.ssl.trustStorePassword","890123");
        SSLSocketFactory sfact=(SSLSocketFactory) SSLSocketFactory.getDefault();
        try {
            SSLSocket Cliente=(SSLSocket) sfact.createSocket(host, puerto);
            DataOutputStream flujoSalida=new DataOutputStream(Cliente.getOutputStream());
            flujoSalida.writeUTF("Hola soy el cliente ");
            DataInputStream flujoEntrada=new DataInputStream(Cliente.getInputStream());
            int num=+flujoEntrada.readInt();
            System.out.println("El server envia "+num);
            flujoSalida.close();
            flujoEntrada.close();
            Cliente.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}