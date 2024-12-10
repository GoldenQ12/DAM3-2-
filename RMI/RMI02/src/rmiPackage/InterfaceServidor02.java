package rmiPackage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceServidor02 extends Remote{
	
	int sumar ( int num1, int num2 ) throws RemoteException;
	
	int restar ( int num1, int num2 ) throws RemoteException;
}
