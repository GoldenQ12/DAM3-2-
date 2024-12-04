import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceServidor01 extends Remote{
    String saludo(String nombre) throws RemoteException;
}