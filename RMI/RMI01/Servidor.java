import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends UnicastRemoteObject implements InterfaceServidor01, Remote {
    public Servidor() throws RemoteException{
        super();
    }

    public String saludo (String nombre)throws RemoteException { 
        try {
            return  "Hola " + nombre;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static void main(String[] args) throws RemoteException {
        try {
            Servidor obj = new Servidor();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://127.0.0.1/ObjetoHola", obj);
            System.out.println("Objeto Hola registrado");
        } catch (RemoteException re) {
            System.out.println("Remote exception: " + re.getMessage());
            throw new RemoteException();
        } catch (MalformedURLException e) {
            System.out.println("Malformed " + e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}