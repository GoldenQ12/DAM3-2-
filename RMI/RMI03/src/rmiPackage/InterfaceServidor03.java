package rmiPackage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfaceServidor03 extends Remote{
	int sumar (ArrayList<Integer> array) throws RemoteException;
}
