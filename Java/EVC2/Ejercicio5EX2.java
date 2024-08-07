
package EVC2;

import java.util.Scanner;


public class Ejercicio5EX2 {
public static void main(String[] args){
Scanner input = new Scanner(System.in);
System.out.print("Ingresa tu primer numero: ");
int v1=input.nextInt();
System.out.print("Ingresa tu segundo numero: ");
int v2=input.nextInt();
if (esMultiplo(v1, v2)) {
            System.out.println(v1 + " es múltiplo de " + v2 + ".");
        } else {
            System.out.println(v1 + " no es múltiplo de " + v2 + ".");
        }
    }

    public static boolean esMultiplo(int num1, int num2) {
        return num2 != 0 && num1 % num2 == 0;
}
}