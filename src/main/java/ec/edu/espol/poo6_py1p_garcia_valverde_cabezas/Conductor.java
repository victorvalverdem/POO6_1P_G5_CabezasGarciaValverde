/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.poo6_py1p_garcia_valverde_cabezas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Conductor extends Usuario{
    private String numLicencia;
    //private Estado estado;
    private Estado estado;
    private Vehiculo vehiculo;

    public Conductor(String numLicencia, Estado estado, Vehiculo vehiculo, String numeroCedula, String nombre, String apellido, String usuario, String contrasena, String celular, String tipoUsuario) {
        super(numeroCedula, nombre, apellido, usuario, contrasena, celular, tipoUsuario);
        this.numLicencia = numLicencia;
        this.estado = estado;
        this.vehiculo = vehiculo;
    }
    
    public Conductor(String numeroCedula, String numLicencia, Estado estado, Vehiculo vehiculo){
        super(numeroCedula);
        this.numLicencia=numLicencia;
        this.estado=estado;
        this.vehiculo=vehiculo;
    
    }

    public String getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(String numLicencia) {
        this.numLicencia = numLicencia;
    }
    

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public void saveFileConductor(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(super.getNumeroCedula()+","+this.numeroCedula+","+this.estado+","+this.vehiculo.getCodigoVehiculo());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
 
    public static ArrayList<Cliente> readFileConductortxt(String nomfile){
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
  
    
    /*
    public int buscarCodigo(ArrayList<String> conductor){
        for(String s: conductor){
            String[] datos=s.split(",");
            if(datos[2].equals("D")){
                
            }
        }
    }
*/
    
    
    public static void MenuNuevoConductor(Scanner sc, String nomfile, ArrayList<String> usuar){//ingresa un usuario al .txt
        ArrayList<String> cadena=new ArrayList<>();
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
        boolean validarCedula=false;
        String n=new String();
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
    
    
    public static String ElegirConductor(ArrayList<String> conductores){
        ArrayList<String> nuevo=new ArrayList();
        for(String c:conductores){
            String[] datos=c.split(",");
            String codUsuario=datos[0];
            int licencia=Integer.parseInt(datos[1]);
            String estado=datos[2];
            String codigoV=datos[3];
            if(estado.equals("D")){
                nuevo.add(estado);
            }            
        }
        for(int i=0, i<nuevo.size())
        
        
    }
    
    public static void cambiarEstadoConductor(ArrayList<String> arreglo){
        
    }
    
    
    public static int numeroAleatorio(int minimo, int maximo){
        return Thread   
    }
    
    

   
    
    
    
    
    
}
