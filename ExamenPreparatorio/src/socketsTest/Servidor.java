package socketsTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class Servidor {

    public static void main(String[] args)throws IOException {
        int puerto=6000;

        System.setProperty("javax.net.ssl.keyStore", "certificados/AlmacenSSL");
        System.setProperty("javax.net.ssl.keyStorePassword","1234567");

        SSLServerSocketFactory sfact=(SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket servidorSSL=(SSLServerSocket) sfact.createServerSocket(puerto);
        SSLSocket clienteConectado=null;

        DataInputStream flujoEntrada=null;
        DataOutputStream flujoSalida=null;

        Random randomizado=new Random();
        int numRandom=0;
        for(int i=1;i<5;i++){
            System.out.println("Esperando al cliente "+i);
            clienteConectado=(SSLSocket) servidorSSL.accept();
            flujoEntrada=new DataInputStream(clienteConectado.getInputStream());
            System.out.println("Recibiendo del cliente "+i+" '"+flujoEntrada.readUTF()+i+"'");
            flujoSalida=new DataOutputStream(clienteConectado.getOutputStream());
            numRandom=randomizado.nextInt(10)+1;
            flujoSalida.writeInt(numRandom);
            clienteConectado.close();
        }
        //Cerrar streams y sockets
        flujoEntrada.close();
        flujoSalida.close();
    }
}