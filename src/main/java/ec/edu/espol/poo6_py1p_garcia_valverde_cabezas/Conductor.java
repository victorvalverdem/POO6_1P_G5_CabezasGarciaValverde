/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.poo6_py1p_garcia_valverde_cabezas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Conductor extends Usuario{
    //private int codUsuario;
    private int numLicencia;
    //private Estado estado;
    private Vehiculo vehiculo;
    private Estado estado;

    public Conductor(int numLicencia, Vehiculo vehiculo, Estado estado, String numeroCedula, String nombre, String apellido, String usuario, String contrasena, String celular, String tipoUsuario) {
        super(numeroCedula, nombre, apellido, usuario, contrasena, celular, tipoUsuario);
        this.numLicencia = numLicencia;
        this.vehiculo = vehiculo;
        this.estado = estado;
    }

    public int getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(int numLicencia) {
        this.numLicencia = numLicencia;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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
    /*
    public static ArrayList<Conductor> LeeFicheroConductor(String nombrearchivo) {
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
    */
    
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
