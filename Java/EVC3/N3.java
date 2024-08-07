package EVC3;
import javax.swing.JOptionPane;
//3)Mostrar la longitud de una cadena.
public class N3 {
    public static void main(String[] args) {
        String cadena = JOptionPane.showInputDialog("Ingrese una cadena");
        int longitud = cadena.length();
        JOptionPane.showMessageDialog(null, "La longitud de la cadena es: " + longitud);
    }
}
