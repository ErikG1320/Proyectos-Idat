package EVC3;
import javax.swing.JOptionPane;
//2)Pedir al usuario que ingrese una frase se imprima la cantidad de veces igual a su longitud.
public class N2 {
    public static void main(String[] args) {
        String entrada = JOptionPane.showInputDialog("Ingrese una frase");
        int longitud = entrada.length();
        System.out.println("Tiene una longitud de letras de: "+ longitud + " Letras ");
    }

}
