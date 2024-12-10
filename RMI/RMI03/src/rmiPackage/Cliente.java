package rmiPackage;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {

        try {
        	int num = 1;
        	ArrayList<Integer> numArray = new ArrayList<Integer>();
        	InterfaceServidor03 obj = (InterfaceServidor03) Naming.lookup("//127.0.0.1/ObjetoHola");
        	do {
        		Scanner sc = new Scanner(System.in);
                System.out.println("Introduce un numero: ");
                num = sc.nextInt();
                numArray.add(num);
        	} while (num != 0);
        	
        	System.out.println("La suma de todos los numeros es: " + obj.sumar(numArray));
            
            
           
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
