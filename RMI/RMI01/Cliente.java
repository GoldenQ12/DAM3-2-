import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {

        String msg = "";
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el nombre: ");
            String nombre = sc.nextLine();

            InterfaceServidor01 obj = (InterfaceServidor01) Naming.lookup("//127.0.0.1/ObjetoHola");
            msg = obj.saludo(nombre);
            System.out.println(msg);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
