package rmiPackage;

import java.rmi.Naming;
import java.util.Iterator;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {

        try {
        	InterfaceServidor02 obj = (InterfaceServidor02) Naming.lookup("//127.0.0.1/ObjetoHola");
        	System.out.println("Que deseas realizar?");
        	for (int i = 0; i < 15; i++) {
        		System.out.print("-");
        	}
        	System.out.println();
        	System.out.println("1.- Sumar");
        	System.out.println("2.- Restar");
            Scanner sc = new Scanner(System.in);
            
            int opc = sc.nextInt();
        	switch (opc) {
			case 1: {
				System.out.println("Introduce un numero: ");
				int num1 = sc.nextInt();
				System.out.println("Introduce otro numero: ");
				int num2 = sc.nextInt();
				System.out.println("" + num1 + " + " + num2 + " = " + obj.sumar(num1, num2));
				break;
			}
			case 2: {
				System.out.println("Introduce un numero: ");
				int num1 = sc.nextInt();
				System.out.println("Introduce otro numero: ");
				int num2 = sc.nextInt();
				System.out.println("" + num1 + " - " + num2 + " = " + obj.restar(num1, num2));
				break;
			}
			default:
				System.out.println("Por favor, introduzca o 1 o 2");
			}
            
            sc.close();
           
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
