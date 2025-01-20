package socketsTest;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {
	 public Cliente() {
	        try {
	            Socket socket = new Socket("localhost", 5000);

	            Persona p1 = new Persona("Juan", 20);

	            OutputStream outputStream = socket.getOutputStream();
	            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

	            objectOutputStream.writeObject(p1);

	            socket.close();
	        } catch (Exception e) {
	            System.err.println("Error: " + e.getMessage());
	        }
	    }
	    public static void main(String[] args) {
	        new Cliente();
	    }
}
