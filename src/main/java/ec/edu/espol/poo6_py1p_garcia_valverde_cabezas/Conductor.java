/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.poo6_py1p_garcia_valverde_cabezas;

import ec.edu.espol.util.Util;
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
    private Estado estado;
    private Vehiculo vehiculo;
    private int codVe;

    public Conductor(String numeroCedula, String nombre, String apellido, String usuario, String contrasena, String celular, String tipoUsuario,String numLicencia, Estado estado, Vehiculo vehiculo) {
        super(numeroCedula, nombre, apellido, usuario, contrasena, celular, tipoUsuario);
        this.numLicencia = numLicencia;
        this.estado = estado;
        this.vehiculo = vehiculo;
    }
    
    public Conductor(String numeroCedula, String numLicencia, Estado estado, int codVeh){
        super(numeroCedula);
        this.numLicencia=numLicencia;
        this.estado=estado;
        this.codVe=codVeh;
    
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

    public int getCodVe() {
        return codVe;
    }

    public void setCodVe(int codVe) {
        this.codVe = codVe;
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
 
    public static ArrayList<Conductor> readFileConductortxt(String nomfile){
        ArrayList<Conductor> conductor = new ArrayList<>();
        try(Scanner sc=new Scanner(new File(nomfile))){
            while(sc.hasNextLine()){
                //linea = "091656,21,null"
                String linea=sc.nextLine();
                
                String[] tokens=linea.split(",");
                String datos=tokens[2];
                Estado estado=Estado.valueOf(datos);
                Conductor c=new Conductor(tokens[0],tokens[1],estado, Integer.parseInt(tokens[3]));
                conductor.add(c);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());;
        }
        return conductor;
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
    
    
    public static void MenuNuevoConductor(Scanner sc, ArrayList<Conductor> conductores, ArrayList<Vehiculo> vehiculos){//ingresa un usuario al .txt
        ArrayList<Conductor> cadena=new ArrayList<>();
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
        System.out.println("Numero de Licencia: ");
        String numLicencia=sc.next();
        System.out.println("Estado(D/O): ");
        String esta=sc.next();
        Estado estado=Estado.valueOf(esta);
        vehiculos=Vehiculo.readFileVehiculotxt("vehiculos.txt");
        Vehiculo v=Vehiculo.MenuVehiculo(sc);
        
        //(String numeroCedula, String nombre, String apellido, String usuario, String contrasena, String celular, String tipoUsuario,String numLicencia, Estado estado, Vehiculo vehiculo) 
        Conductor c=new Conductor(numCedula, nombre, apellido, user, password, celular, tipUsuario,numLicencia, estado, v);
        if(conductores.isEmpty()){
            c.saveFileConductor("conductores.txt");
            c.saveFile("usuario.txt");
            System.out.println("Conductor Registrado");
        }
        ArrayList<String> numerosdeCedulas=new ArrayList<>();
        for(Conductor con: conductores){
            if(!numerosdeCedulas.contains(con.getNumeroCedula())){
                numerosdeCedulas.add(con.getNumeroCedula());
            }
        }
        if(numerosdeCedulas.contains(numCedula)){
            System.out.println("El Conductor ya existe");
        }
        else{
            cadena.add(c);
            c.saveFileConductor("conductores.txt");
            c.saveFile("usuario.txt");
            System.out.println("Ingreso de Conductor Exitoso");
        }
        
    }
    
    /*
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
        
        
    }*/
    /*
    public static void cambiarEstadoConductor(ArrayList<String> arreglo){
        
    }*/
    
    public static String EleccionConductor(ArrayList<Conductor> conductores, ArrayList<Vehiculo> vehiculos){
        ArrayList<String> conductor=new ArrayList();
        for(Conductor c: conductores){
            for(Vehiculo v: vehiculos){
                if((!conductor.contains(c.getNumeroCedula())) && (c.getEstado().equals(Estado.D)) ){
                    if( (c.getCodVe()==v.getCodigoVehiculo()) && v.getTipoVeh().equals(TipoVehiculo.A)){
                        conductor.add(c.getNombre());
                    }
                }
            }
            
        }
        String s=conductor.get(0);
        return s;
    }

    @Override
    public String toString() {
        return "Conductor{" + this.numeroCedula+","+ numLicencia + ","+ estado + ","+ codVe + '}';
    }
    
    
        

   
    
    
    
    
    
}
