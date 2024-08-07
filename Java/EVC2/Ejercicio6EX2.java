/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EVC2;
//crea un programa que lea una letra tecleada por el usuario y diga si se trata de un vocal,una cifra numerica o consonante
import java.util.Scanner;
public class Ejercicio6EX2 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Introduce una letra:");
    String input= sc.next().toLowerCase();

        if (input.length() > 1) {
            System.out.println("Por favor, introduce solo una letra.");
        } else {
            char letra = input.charAt(0);
            switch (letra) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println("Has introducido una vocal.");
                    break;
                case '0': case '1': case '2': case '3': case '4':
                case '5': case '6': case '7': case '8': case '9':
                    System.out.println("Has introducido una cifra numérica.");
                    break;
                default:
                    if (Character.isLetter(letra)) {
                        System.out.println("Has introducido una consonante.");
                    } else {
                        System.out.println("No has introducido ni una vocal, ni una cifra numérica, ni una consonante.");
                    }
                    break;
            }
        }
    }
}