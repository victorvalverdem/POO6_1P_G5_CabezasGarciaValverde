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
public class EntregaEncomienda extends Servicio{
    private TipoEncomienda tipoencomienda;
    private int cantProductos;

    public EntregaEncomienda(TipoEncomienda tipoencomienda, int cantProductos, int idServicio, Ruta ruta, LocalDate fecha, String hora, Conductor conductor, TipoPago tipopago) {
        super(idServicio, ruta, fecha, hora, conductor, tipopago);
        this.tipoencomienda = tipoencomienda;
        this.cantProductos = cantProductos;
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
    
    public static void ServicioEncomienda(Scanner sc, String nomfile){
        int idEncomienda=Util.GenerarID(nomfile);
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
        ArrayList<String> arr= Util.LeeFichero("conductor.txt");
        
        for(String s: arr){
            String[] linea=s.split(",");
            if(linea[2].equals("D")){
                String codigo=
            }
        }
        
        
    }
}
