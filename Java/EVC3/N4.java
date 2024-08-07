package EVC3;

import javax.swing.JOptionPane;
//4)Crear una aplicación que nos permite insertar números hasta que insertemos un-1. Calcular el numero de números introducidos.
public class N4{
    public static void main(String[] args) {
        int n1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número"));

        while (n1!= -1)
        {
            n1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número"));
            break;
        }

    }
}