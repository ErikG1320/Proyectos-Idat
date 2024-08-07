package EVC3;
//import java.util.Scanner;
import javax.swing.JOptionPane;
public class MenuPrincipal {
    public static void main(String[] args) {

        int opcion;

        do {
    opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "Menú Principal\n" +
                "1. Calculadora Inversa\n" +
                "2. Imprimir Frase\n" +
                "3. Longitud de Cadena\n" +
                "4. Contar Números\n" +
                "5. Eliminar Espacios\n" +
                "6. Salir\n" +
                "Ingrese una opción:"));

            switch (opcion) {
                case 1:
                    N1.main(args);
                    break;
                case 2:
                    N2.main(args);
                    break;
                case 3:
                    N3.main(args);
                    break;
                case 4:
                    N4.main(args);
                    break;
                case 5:
                    N5.main(args);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
            }
        } while (opcion != 6);
    }
}

