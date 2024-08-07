package EVC3;
import javax.swing.JOptionPane;
//1)Crea una app llamado CalculadoraInversa,nos pedirá 2 numeros(int)y un signo aritmético(String),según este último realizara la operación correspondiente.Al final mostrara el resultado en un cuadro de dialogo.Los signos aritméticos disponibles son::suma los dos operandos.-:resta los operandos.*:multiplica los operandos./:divide los operandos,este debe dar un resultado con decimales(double)^:1 º operando como base y 2 º como exponente.%:módulo,resto de la división entre operando1 y operando2.

//3)Mostrar la longitud de una cadena.

//4)Crear una aplicación que nos permite insertar números hasta que insertemos un-1. Calcular el numero de números introducidos.

//5)Eliminar los espacios de una frase introducidos por consola por el usuario.
public class N1 {
    int numero1;
    int numero2;
    static int suma;
    static int resta;
    static int multiplicacion;
    static int division;
    static double resultado;
    public int sumar(int numero1, int numero2) {
        int suma = numero1 + numero2;
        return suma;
    }
    public int restar(int numero1, int numero2) {
        int resta = numero1 - numero2;
        return resta;
    }
    public int multiplicar(int numero1, int numero2) {
        int multiplicacion = numero1 * numero2;
        return multiplicacion;
    }
    public int dividir(int numero1, int numero2) {
        int division = numero1 / numero2;
        return division;
    }
    public void resultado(int numero1,int numero2){
        if(numero1==numero2){
            resultado=numero1;
        }
        else if(numero1>numero2){
            resultado=numero1-numero2;
        }
        else{
            resultado=numero2-numero1;
        }
}
   public static void main(String[] args) {
       int numero1, numero2;
       numero1 = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero: "));
       numero2 = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero: "));
       N1 operacion=new N1();
       suma = numero1 + numero2;
       resta = numero1 - numero2;
       multiplicacion = numero1 * numero2;
       division = numero1 / numero2;
       operacion.resultado(numero1,numero2);
       JOptionPane.showMessageDialog(null, "El resultado es: "+resultado);
   }
public void sumar(Object object, Object object2) {
    throw new UnsupportedOperationException("Unimplemented method 'sumar'");
}
public void restar(Object object, Object object2) {
    throw new UnsupportedOperationException("Unimplemented method 'restar'");
}
public void multiplicar(Object object, Object object2) {
    throw new UnsupportedOperationException("Unimplemented method 'multiplicar'");
}
public void division(Object object, Object object2) {
    throw new UnsupportedOperationException("Unimplemented method 'division'");
}
public void resultado(Object object, Object object2) {
    throw new UnsupportedOperationException("Unimplemented method 'resultado'");
}
}
