/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EVC2;

//Crea un progrma que pida al usuario su contraseña(numerica).Dbera terminar cuando introduzca como contraseña el 1111,pero volversela pedir cuantas veces sea necesario.

import java.util.Scanner;

public class Ejercicio7EX2 {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int contra;
    do{
    System.out.print("Ingresa una contraseña: ");
    contra=input.nextInt();
    } while (contra != 1111);
    System.out.print("Acceso permitido");
    }
}