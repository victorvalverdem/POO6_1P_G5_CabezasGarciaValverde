/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.poo6_py1p_garcia_valverde_cabezas;

import ec.edu.espol.util.Util;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Taxi extends Servicio{
    private int numeroPersona;

    public Taxi(int numeroPersona, int idServicio, Ruta ruta, LocalDate fecha, String hora, Conductor conductor, TipoPago tipopago) {
        super(idServicio, ruta, fecha, hora, conductor, tipopago);
        this.numeroPersona = numeroPersona;
    }

    public int getNumeroPersona() {
        return numeroPersona;
    }

    public void setNumeroPersona(int numeroPersona) {
        this.numeroPersona = numeroPersona;
    }
    
    // Método de cálculo servicio debe ir en el padre, porwue se hereda a los servicios hijos
    /*
    public static double valorPagar(TipoPago p){
        double numAle=Math.random()*100;
        if(p.equals(p.TARJETACREDITO)){
            double aumen=numAle+(numAle*0.10);
            return aumen;
        }
        else
            return numAle;
    }
    */
    public static void ServicioTaxi(Scanner sc, String nomfile, ArrayList<Taxi> taxi){
        //String tp;
        System.out.println("****BIENVENIDO AL SERVICIO DE TAXI****");
        System.out.println("**Ingrese la ruta**");
        System.out.println("Desde: ");
        String desde=sc.next();
        System.out.println("Hacia: ");
        String hacia=sc.next();
        Ruta r=new Ruta(desde, hacia);
        System.out.println("Ingrese la Fecha del viaje(AAAA-MM-DD): ");
        String ld=sc.next();
        LocalDate LD=LocalDate.parse(ld);
        System.out.println("Hora de Viaje: ");
        String hora=sc.next();
        System.out.println("Tipo de pago (EFECTIVO/TARJETACREDITO): ");
        String tp=sc.next();
        TipoPago TP=TipoPago.valueOf(tp);
        System.out.println("Numero de Personas que viajarán: ");
        int numPersonas=sc.nextInt();
        System.out.println("El valor a pagar es: "+Taxi.valorPagar(TP));
        int IDtaxi=Util.GenerarID(nomfile);
        Taxi taxi=new Taxi(numPersonas,IDtaxi,r,LD,hora,,TP);
        System.out.println("Acepta el viaje? SI/NO");
        String respuesta=sc.next();
        if(respuesta.equals("SI")){
            ArrayList<String> arreglo=Util.LeeFichero("conductores.txt");
            
        }
        

    }
    
    public static String EleccionConductor(String nomfile){
        ArrayList<String> nuevoArr=new ArrayList();
        ArrayList<String> arreglo=Util.LeeFichero(nomfile);
        for(String s: arreglo){
            String[] datos=s.split(",");
            if(datos[2].equals("D")){
                nuevoArr.add(datos[3]);
            }
                
            }
        
    }
    
    public static void cambiarCaracterConductor(String nomfile){
        ArrayList<String> arreglo=Util.LeeFichero(nomfile);
        for(String s: arreglo){
            String[] datos=s.split(",");
            if(datos[2].equals("D")){
                
            }
        }
    
    }

    @Override
    public String toString() {
        return super.idServicio+"d";
    }
    
    
    
    
    
    
}
