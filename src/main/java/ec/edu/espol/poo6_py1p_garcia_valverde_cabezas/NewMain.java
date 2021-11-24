/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.poo6_py1p_garcia_valverde_cabezas;

import ec.edu.espol.util.Util;
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
        ArrayList<String> cliente=Cliente.LeeFicheroCliente("clientes.txt");
        Cliente.LeeFicheroCliente("clientes.txt");
        int opcion;
        Scanner sc=new Scanner(System.in);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("                   BIENVENIDOS AL SISTEMA                  ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("1. Iniciar Sesion");
        System.out.println("2. Registrar nuevo Usuario");
        System.out.println("3. Salir");
        System.out.println("Elija una opcion: ");
        int eleccion=sc.nextInt();
        int nuevaOpcion;
        int otraOpcion;
        switch(eleccion){
            case 1:
            {
                do{
                    Usuario.IniciarSesion(sc, usuario);
                    
                    
                }
                    
                    
                }
            
            
            }
            
        }while(eleccion!=3);
        
        
        
        
        
        
        
        
            
        }
        else
            
        
        
    
}
