package PracticasRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfacePracticas extends Remote{
	int sumar(ArrayList<Integer> arr) throws RemoteException;
}
