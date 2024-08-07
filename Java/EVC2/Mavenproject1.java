/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package EVC2;

//Crea un programa que calcule el resto de dividir 3784 entre 16 usando variables
import java.util.Scanner;
public class Mavenproject1 {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Ingresa tu primer numero: ");
    int v1=input.nextInt();
    System.out.print("Ingresa tu segundo numero: ");
    int v2=input.nextInt();
   float resultado=(float) v1/v2 ;
   System.out.print("La división es: " + resultado);
    input.close();
    }
}
