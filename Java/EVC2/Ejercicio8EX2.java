/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EVC2;


//Crea un progrma que escriba en pantalla los numeros pares del 26 al 10 descendiendo,usando while
public class Ejercicio8EX2 {
    public static void main(String[] args) {
    int numero = 26;
        while (numero >= 10) {
            if (numero % 2 == 0) {
                System.out.println(numero);
            }
            numero--;
        }
    }
}