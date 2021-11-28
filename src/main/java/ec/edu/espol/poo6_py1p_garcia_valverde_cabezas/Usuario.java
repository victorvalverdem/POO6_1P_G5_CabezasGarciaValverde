/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.poo6_py1p_garcia_valverde_cabezas;


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
public abstract class Usuario {
    protected String numeroCedula;
    protected String nombre;
    protected String apellido;
    protected String usuario;
    protected String contrasena;
    protected String celular;
    protected String tipoUsuario;

    public Usuario(String numeroCedula, String nombre, String apellido,String usuario, String contrasena, String celular, String tipoUsuario) {
        this.numeroCedula = numeroCedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.celular = celular;
        this.tipoUsuario = tipoUsuario;
                
    }
    
    public Usuario(String numCedula){
        this.numeroCedula=numCedula;
        
        
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
    
    public static ArrayList<String> LeeFicheroUsuario(String nombrearchivo) {
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

    
    
    /*
    
    public static String TipoDeUsuario(ArrayList<Usuario> usuario, String user)
    {
        for(Usuario u : usuario)
        {
            if(u.getUsuario().equals(user))
                return u.getTipoUsuario();
        }
        return null;
    }
    
    public static boolean ValidarUsuario(String usuIngr, String passw, ArrayList<String> usu){
        for(Usuario u:usu){
            if(usuIngr.equals(u.getUsuario()) && passw.equals(u.getContrasena()))
                return true;
        }
        return false;
    }*/
 
    
    
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.numeroCedula+","+this.nombre+","+this.apellido+","+this.usuario+","+this.contrasena+","+this.celular+","+this.tipoUsuario);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public boolean equals(Object o){
       
        if(this==o){
            return true;
        }
        if(o!=null && this.getClass()!=o.getClass()){
            Usuario otro=(Usuario) o;
            return this.numeroCedula==otro.numeroCedula;
        }
        else
            return false;
              
    }
    
    @Override
    public String toString() {
        return "Usuario ={ "+numeroCedula +","+ nombre +","+ apellido +","+ usuario +","+ contrasena +","+ celular +","+ tipoUsuario
                +"} ";
    }
    
    
    
    
}
