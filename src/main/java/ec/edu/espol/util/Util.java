/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

import ec.edu.espol.poo6_py1p_garcia_valverde_cabezas.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Util {
    
    
    
    public static int MenuCliente(Scanner sc){
        System.out.println("*********************MENU***********************");
        System.out.println("\n");
        System.out.println("************************************************");
        System.out.println("1. Solicitar servicio de Taxi");
        System.out.println("2. Solicitar servicio a domicilio");
        System.out.println("3. Solicitar entrega encomienda");
        System.out.println("4. Consultar Servicios");
        System.out.println("5. Salir\n");
        System.out.println("Elejir una opcion: ");
        
        int numero = sc.nextInt();
        return numero;
    }
    
    public static int MenuConductor(Scanner sc){
        System.out.println("******************MENU CONDUCTOR****************");
        System.out.println("\n");
        System.out.println("**************************************************");
        System.out.println("1. Consultar Servicio Asignado ");
        System.out.println("2. Salir");
        System.out.println("Elija una opcion: ");
        int opcion=sc.nextInt();
        return opcion;
    }
    
    public static boolean ValidarUsuario(Scanner sc){
        ArrayList<String> usuarios=Usuario.LeeFicheroUsuario("usuarios.txt");
        System.out.println("****************INICIO DE SESION******************");
        System.out.println("\n");
        System.out.println("Ingresar Usuario: ");
        String user=sc.next();
        System.out.println("Ingresar Contraseña: ");
        String contrasena=sc.next();
        boolean i = false;
        for(String u: usuarios){
            String[] datos=u.split(",");
            if((datos[3].equals(user)) && (datos[4].equals(contrasena))){
                System.out.println("Ingreso correctamente");
                i=true;
                //cedula,nombre,apellido,user,contrasena,celular,tipoUsuario
                if()
            }
            else{
                System.out.println("Datos incorrectos");
                i=false;
            }
        }
        return i;

        
    }
    
    
    
    
    
    
    public static int GenerarID(String nomfile) {
        int id = 0;
        try (Scanner sc = new Scanner(new File(nomfile))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] sepa = linea.split(",");
                id = Integer.parseInt(sepa[0]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return id + 1;
    }
    
    public static ArrayList<String> LeeFichero(String nombrearchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo,StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                lineas.add(linea);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lineas;

    }
    
    public static void EscribirArchivo(String nombreArchivo, ArrayList<String> linea) {

        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombreArchivo,true);
            bw = new BufferedWriter(fichero);
            bw.write(linea+"\n");
         

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    //fichero.close();
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
