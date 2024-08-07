
package EVC2;

import java.util.Scanner;
public class Ejercicio4EX2 {
public static void main(String[] args){
Scanner input = new Scanner(System.in);
System.out.print("Ingresa su primer numero: ");
int v1=input.nextInt();
System.out.print("Ingresa su segundo numero: ");
int v2=input.nextInt();
int res=(int)v1+v2;
System.out.print("La suma es: " + res);
input.close();
}
}