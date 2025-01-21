package packageRepaso;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
            ObjectOutputStream flujoSalida=new ObjectOutputStream(Cliente.getOutputStream());
            Persona p2 = new Persona("Angel", 60);
            flujoSalida.writeObject((Persona) p2);
            ObjectInputStream flujoEntrada=new ObjectInputStream(Cliente.getInputStream());
            System.out.println("El servidor ha mandado " + (Persona) flujoEntrada.readObject());
            flujoSalida.close();
            flujoEntrada.close();
            Cliente.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
