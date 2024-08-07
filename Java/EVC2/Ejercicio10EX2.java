/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EVC2;

import java.util.Scanner;

public class Ejercicio10EX2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingresa tu edad: ");
        int edad = input.nextInt();
        System.out.print("Ingresa tu fecha de nacimiento: ");
        int fechan = input.nextInt();
        System.out.println("Estos son tus datos: Edad - " + edad + ", Fecha de nacimiento - " + fechan);
    }
}
