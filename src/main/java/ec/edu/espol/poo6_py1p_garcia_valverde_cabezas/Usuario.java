/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.poo6_py1p_garcia_valverde_cabezas;

import ec.edu.espol.util.Util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Usuario {
    protected String numeroCedula;
    protected String nombre;
    protected String apellido;
    protected String usuario;
    protected String contrasena;
    protected String celular;
    protected String tipoUsuario;

    public Usuario(String numeroCedula, String nombre, String apellido, String usuario, String contrasena, String celular, String tipoUsuario) {
        this.numeroCedula = numeroCedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.celular = celular;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public static ArrayList<Usuario> LeeFichero(String nombrearchivo) {
        ArrayList<Usuario> lineas = new ArrayList<>();
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
                String[] datos=linea.split(",");
                Usuario u=new Usuario(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6]);
                lineas.add(u);
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
    
    

    public static void EscribirArchivo(String nombreArchivo, Usuario u) {

        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombreArchivo,true);
            bw = new BufferedWriter(fichero);
            bw.write(u+"\n");
            

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
    
    
    public static String TipoDeUsuario(ArrayList<Usuario> usuario, String user)
    {
        for(Usuario u : usuario)
        {
            if(u.getUsuario().equals(user))
                return u.getTipoUsuario();
        }
        return null;
    }
    
    public static boolean ValidarUsuario(String usuIngr, String passw, ArrayList<Usuario> usu){
        for(Usuario u:usu){
            if(usuIngr.equals(u.getUsuario()) && passw.equals(u.getContrasena()))
                return true;
        }
        return false;
    }
 
    
    public static void MenuUsuario(Scanner sc, String nomfile, ArrayList<Usuario> usuar){//ingresa un usuario al .txt
        System.out.println("Ingrese numero de cedula: ");
        String numCedula=sc.next();
        System.out.println("Nombre: ");
        String nombre=sc.next();
        System.out.println("Apellido: ");
        String apellido=sc.next();
        System.out.println("user: ");
        String user=sc.next();
        System.out.println("Contrasena: ");
        String password=sc.next();
        System.out.println("Celular: ");
        String celular=sc.next();
        System.out.println("TipoUsuario(C/R)");
        String tipUsuario=sc.next();
        Usuario usuario=new Usuario(numCedula, nombre, apellido, user, password,celular,tipUsuario);
        boolean validarCedula=false;
        if(usuar.isEmpty()){
            Usuario.EscribirArchivo(nomfile, usuario);
            System.out.println("Usuario Registrado");
        }
        else{
            for(Usuario u:usuar){
                if(!(u.getNumeroCedula().equals(numCedula))){
                    validarCedula=true;
                }
            }
            if(validarCedula ==true){
                Usuario.EscribirArchivo(nomfile, usuario);
                System.out.println("***USUARIO REGISTRADO***");
            }
            else
                System.out.println("Numero de cedula repetido, no se puede ingresar");
            
        }
        
    }
    
    public static void IniciarSesion(Scanner sc, ArrayList<Usuario> usuario){
        System.out.println("USUARIO: ");
        String usu = sc.next();
        System.out.println("Contrasena: ");
        String contr = sc.next();
        int opcion;
        if (Usuario.ValidarUsuario(usu, contr, usuario) == true) {
            System.out.println("Ingreso Exitoso!");
            if (Usuario.TipoDeUsuario(usuario, usu).equals("C")) {
                do{
                    opcion=Util.MenuCliente(sc);
                    switch(opcion){
                        case 1:
                    
                    }while(opcion!=5);//salir
                
                
                
                }
                
            }
            else{
                Util.MenuConductor(sc);
            }
        } 
    }
    
    
    @Override
    public String toString() {
        return numeroCedula +","+ nombre +","+ apellido +","+ usuario +","+ contrasena +","+ celular +","+ tipoUsuario;
    }
    
    
}
