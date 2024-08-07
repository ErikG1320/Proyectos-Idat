/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EVC2;
//crea un programa que muestre los primeros ocho numeros pares :2 4 6 8 10 12

import java.util.Scanner;

public class Ejercicio9EX2 {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numero = 2;
    for (int i = 0; i < 8; i++) {
            System.out.println(numero);
            numero += 2;
        }
    }
}