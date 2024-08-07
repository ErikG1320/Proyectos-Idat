package EVC3;
import javax.swing.JOptionPane;
//5)Eliminar los espacios de una frase introducidos por consola por el usuario.
public class N5 {
    public static void main(String[] args) {
        String frase = JOptionPane.showInputDialog(null, "Introduce una frase");
        frase = frase.trim();
        System.out.println(frase);
    }
}
