package packageRepaso;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class Servidor {
	public static void main(String[] args) throws IOException{
		int puerto = 6000;
		System.setProperty("javax.net.ssl.keyStore", "certificados/AlmacenSSL");
        System.setProperty("javax.net.ssl.keyStorePassword","1234567");

        SSLServerSocketFactory sfact=(SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket servidorSSL=(SSLServerSocket) sfact.createServerSocket(puerto);
        SSLSocket clienteConectado=null;

        ObjectInputStream flujoEntrada=null;
        ObjectOutputStream flujoSalida=null;
        for(int i = 0; i<5; i++) {
        	try {
        	System.out.println("Cliente conectado");
        	clienteConectado = (SSLSocket) servidorSSL.accept();
        	flujoEntrada = new ObjectInputStream( clienteConectado.getInputStream());
			System.out.println("Cliente ha enviado: " + flujoEntrada.readObject());
			flujoSalida = new ObjectOutputStream(clienteConectado.getOutputStream());
			Persona p1 = new Persona("Juan", 40);
			flujoSalida.writeObject((Persona) p1);
			clienteConectado.close();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	flujoEntrada.close();
            flujoSalida.close();
        }
	}
}
