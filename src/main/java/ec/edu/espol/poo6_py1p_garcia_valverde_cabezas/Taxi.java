/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.poo6_py1p_garcia_valverde_cabezas;

import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Taxi extends Servicio{
    private int numeroPersona;
    private double valorApagar;

    public Taxi( int idServicio, Ruta ruta, LocalDate fecha, String hora, Conductor conductor, int numeroPersona,TipoPago tipopago, double valorApagar) {
        super(idServicio, ruta, fecha, hora, conductor, tipopago);
        this.numeroPersona = numeroPersona;
        this.valorApagar=valorApagar;
    }

    public int getNumeroPersona() {
        return numeroPersona;
    }

    public void setNumeroPersona(int numeroPersona) {
        this.numeroPersona = numeroPersona;
    }

    public double getValorApagar() {
        return valorApagar;
    }

    public void setValorApagar(double valorApagar) {
        this.valorApagar = valorApagar;
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
    
    public void saveFileServicio(String nomfile, String nombreCliente, String nombreConductor){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(idServicio+","+nombreCliente+","+nombreConductor+","+super.ruta.getOrigen()+","+super.ruta.getDestino()+","+super.getFecha()+","+super.getHora()+","+this.numeroPersona+","+super.tipopago+","+this.valorApagar);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static ArrayList<Servicio> readFileServiciotxt(String nomfile, Conductor c){
        ArrayList<Servicio> servicio = new ArrayList<>();
        try(Scanner sc=new Scanner(new File(nomfile))){
            while(sc.hasNextLine()){
                //linea = "091656,21,null"
                String linea=sc.nextLine();
                
                String[] tokens=linea.split(",");
                String rutaIn=tokens[3];
                String rutaF=tokens[4];
                Ruta r=new Ruta(rutaIn, rutaF);
                LocalDate Fecha=LocalDate.parse(tokens[5]);
                TipoPago tp=TipoPago.valueOf(tokens[8]);
                //( int idServicio, Ruta ruta, LocalDate fecha, String hora, Conductor conductor, int numeroPersona,TipoPago tipopago, double valorApagar
                Servicio s=new Taxi(Integer.parseInt(tokens[0]),r,Fecha,tokens[3],c,Integer.parseInt(tokens[7]),tp,Double.parseDouble(tokens[9]));
                servicio.add(s);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());;
        }
        return servicio;
    }
    public static String ServicioTaxi(Scanner sc, ArrayList<Conductor> conductores, ArrayList<Vehiculo> vehiculos, String nombreCliente){
        //String tp;
        System.out.println("****BIENVENIDO AL SERVICIO DE TAXI****");
        int IDtaxi=Util.GenerarID("viajes.txt");
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
        String nombreConductor=Conductor.EleccionConductorAuto(conductores, vehiculos);
        Conductor cond=Conductor.ApartirdelNombre(conductores, nombreConductor);
        Double Valorp= valorPagar(TP);
        
        //public Taxi( int idServicio, Ruta ruta, LocalDate fecha, String hora, Conductor conductor, int numeroPersona,TipoPago tipopago)
        Taxi t=new Taxi(IDtaxi,r,LD,hora,cond, numPersonas,TP, Valorp);
        System.out.println("Acepta el viaje? SI/NO");
        String respuesta=sc.next();
        if(respuesta.equals("SI")){
            t.saveFileServicio("viajes.txt", nombreCliente, nombreConductor); 
            return "SI";
        }
        else{
            return "NO";
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
        return "Taxi{" + "numeroPersona=" + numeroPersona + ", valorApagar=" + valorApagar + '}';
    }
    
    
    
    
    
    
    
}
