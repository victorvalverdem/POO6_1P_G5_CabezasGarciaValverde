/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.poo6_py1p_garcia_valverde_cabezas;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author USER
 */
public class NewMain {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        ArrayList<Usuario> usuario=Usuario.LeeFichero("usuarios.txt");
       
        
        Scanner sc=new Scanner(System.in);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("                   BIENVENIDOS AL SISTEMA                  ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("USUARIO: ");
        String usu=sc.next();
        
        
        
    }
    
}
