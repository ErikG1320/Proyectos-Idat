/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EVC2;
//Pide al usuario una cantidad de millas nauticas nauticas la equivalencia en metros , usando una milla nautica=1852 mtros
import java.util.Scanner;
public class Ejecicio3EX2 {
    public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Ingrese una cantida de millas nauticas: ");
    double millasnauticas=input.nextDouble();
    double metros=millasnauticas*1852;
    System.out.println(millasnauticas + " millas náuticas equivalen a " + metros + " metros.");
    input.close();
    
}
}