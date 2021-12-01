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
public class EntregaEncomienda extends Servicio{
    private TipoEncomienda tipoencomienda;
    private int cantProductos;
    private double valorPagar;

    public EntregaEncomienda(int idServicio, Ruta ruta, LocalDate fecha, String hora, Conductor conductor, TipoPago tipopago, Double valorPagar,TipoEncomienda tipoencomienda, int cantProductos) {
        super(idServicio, ruta, fecha, hora, conductor, tipopago);
        this.tipoencomienda = tipoencomienda;
        this.cantProductos = cantProductos;
        this.valorPagar=valorPagar;
    }

    public TipoEncomienda getTipoencomienda() {
        return tipoencomienda;
    }

    public void setTipoencomienda(TipoEncomienda tipoencomienda) {
        this.tipoencomienda = tipoencomienda;
    }

    public int getCantProductos() {
        return cantProductos;
    }

    public void setCantProductos(int cantProductos) {
        this.cantProductos = cantProductos;
    }
    
    public void saveFileServicio(String nomfile, String nombreCliente, String nombreConductor){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(idServicio+","+nombreCliente+","+nombreConductor+","+super.ruta.getOrigen()+","+super.ruta.getDestino()+","+super.getFecha()+","+super.getHora()+","+this.tipoencomienda+","+this.cantProductos+","+super.tipopago+","+this.valorPagar);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static String ServicioEncomienda(Scanner sc, ArrayList<Conductor> conductores, ArrayList<Vehiculo> vehiculos, String nombreCliente){
        System.out.println("****BIENVENIDO AL SERVICIO DE ENCOMIENDA****");
        int idEncomienda=Util.GenerarID("encomiendas.txt");
        System.out.println("***Ingrese la ruta***");
        System.out.println("Desde: ");
        String desde=sc.next();
        System.out.println("Hacia: ");
        String hacia=sc.next();
        Ruta r=new Ruta(desde,hacia);
        System.out.println("Ingrese la fecha de encomienda(AAAA-MM-DD): ");
        String fecha=sc.next();
        LocalDate fc=LocalDate.parse(fecha);
        System.out.println("Ingrese la hora de entrega(HH:MM): ");
        String hora=sc.next();
        System.out.println("Tipo de pago (EFECTIVO/TARJETACREDITO): ");
        String tp=sc.next();
        TipoPago TP=TipoPago.valueOf(tp);
        System.out.println("Tipo de Encomienda(MEDICAMENTOS/ROPA/DOCUMENTOS): ");
        String tpEnc=sc.next();
        TipoEncomienda TPEnco=TipoEncomienda.valueOf(tpEnc);
        System.out.println("Cantidad de productos a enviar: ");
        int cantidad=sc.nextInt();
        Double valorPag=valorPagar(TP);
        String nombreConductor=Conductor.EleccionConductorMoto(conductores, vehiculos);
        Conductor conductor=Conductor.ApartirdelNombre(conductores, nombreConductor);
        //int idServicio, Ruta ruta, LocalDate fecha, String hora, Conductor conductor, TipoPago tipopago, Double valorPagar,TipoEncomienda tipoencomienda, int cantProductos
        EntregaEncomienda ec=new EntregaEncomienda(idEncomienda, r, fc, hora, conductor, TP, valorPag, TPEnco,cantidad);
        System.out.println("Acepta la encomienda? SI/NO");
        String respuesta=sc.next();
        if(respuesta.equals("SI")){
            ec.saveFileServicio("encomiendas.txt", nombreCliente, nombreConductor); 
            return "SI";
        }
        else{
            return "NO";
        }
        
        
    }

    @Override
    public String toString() {
        return "EntregaEncomienda{" + "tipoencomienda=" + tipoencomienda + ", cantProductos=" + cantProductos + ", valorPagar=" + valorPagar + '}';
    }
    
    
}
