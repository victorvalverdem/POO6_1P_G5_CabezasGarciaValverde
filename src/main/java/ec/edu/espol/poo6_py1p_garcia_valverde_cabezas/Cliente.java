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
public class Cliente extends Usuario{
    private String numeroTarjeta;
    private int edad;

    public Cliente(String numeroCedula, String nombre, String apellido, String usuario, String contrasena, String celular, String tipoUsuario,String numeroTarjeta, int Edad) {
        super(numeroCedula, nombre, apellido, usuario, contrasena, celular, tipoUsuario);
        this.numeroTarjeta=numeroTarjeta;
        this.edad=Edad;
    }
    
    public Cliente(String numeroCedula,String numeroTarjeta,int edad){
        super(numeroCedula);
        this.numeroTarjeta=numeroTarjeta;
        this.edad=edad;
        }
    
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    
    
    public void saveFileCliente(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(super.getNumeroCedula()+","+this.edad+","+this.numeroTarjeta);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
 
    public static ArrayList<Cliente> readFileClientestxt(String nomfile){
        ArrayList<Cliente> clientes = new ArrayList<>();
        try(Scanner sc=new Scanner(new File(nomfile))){
            while(sc.hasNextLine()){
                //linea = "091656,21,null"
                String linea=sc.nextLine();
                
                String[] tokens=linea.split(",");
                
                Cliente c=new Cliente(tokens[0],tokens[1],Integer.parseInt(tokens[2]));
                clientes.add(c);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());;
        }
        return clientes;
    } 
  
    public static String MenuClienteNuevo(Scanner sc, ArrayList<Cliente> clientes){//ingresa un usuario al .txt
        //ArrayList<Cliente> cadena=new ArrayList<>();
        System.out.println("Ingrese numero de cedula: ");
        String cedula=sc.next();
        System.out.println("Nombre: ");
        String nombre=sc.next();
        System.out.println("Apellido: ");
        String apellido=sc.next();
        System.out.println("Edad: ");
        int edad=sc.nextInt();
        System.out.println("user: ");
        String user=sc.next();
        System.out.println("Contrasena: ");
        String password=sc.next();
        System.out.println("Celular: ");
        String celular=sc.next();
        System.out.println("TipoUsuario(C/R)");
        String tipUsuario=sc.next();        
        System.out.println("Numero Tarjeta de Credito: ");
        String tarC=sc.next();
        Cliente c=new Cliente(cedula, nombre, apellido, user, password, celular, tipUsuario,tarC,edad);
        
        if(clientes.isEmpty()){
            c.saveFileCliente("clientes.txt");
            c.saveFile("usuario.txt");
            System.out.println("Ingreso de Cliente Exitoso");
            //Cliente.EscribirArchivoCliente("usuario.txt",c );
            //ManejoArchivos.EscribirArchivo("clientes.txt",cedula+","+edad+","+tarC);
            //ManejoArchivos.EscribirArchivo("usuario.txt", cedula+","+ nombre+","+ apellido+","+ user+","+ password+","+ celular+","+ tipUsuario);
        }
        ArrayList<String> numerosdeCedulas=new ArrayList<>();
        for (Cliente clien:clientes){
            if(!numerosdeCedulas.contains(clien.getNumeroCedula())){
                numerosdeCedulas.add(clien.getNumeroCedula());
            }
        }
        do{
        {
            System.out.println("Cliente existe");
            Cliente.MenuClienteNuevo(sc, clientes);
            
        }
        }while(numerosdeCedulas.contains(cedula));
        if(!numerosdeCedulas.contains(cedula)){
            //cadena.add(c);
            c.saveFileCliente("clientes.txt");
            c.saveFile("usuario.txt");
            System.out.println("Ingreso de Cliente Exitoso");
        }
        return nombre;
    }
    
    
    
    public static boolean buscarxCedula(ArrayList<String> arreglo, String u){
        for(String s: arreglo){
            if(s.contains(u)){
                return true; 
            }
        }
        return false;
        
    }
    
    
    
    
    public String toString(){
        return "Cliente = {"+this.numeroCedula+","+this.numeroTarjeta+","+this.edad+"} ";
    }
    
}