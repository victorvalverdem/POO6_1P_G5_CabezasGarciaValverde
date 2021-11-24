/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.poo6_py1p_garcia_valverde_cabezas;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Servicio {
    protected int idServicio;
    protected Ruta ruta;
    protected LocalDate fecha;
    protected String hora;
    protected Conductor conductor;
    protected TipoPago tipopago;

    
    public Servicio(int idServicio, Ruta ruta, LocalDate fecha, String hora, Conductor conductor, TipoPago tipopago) {
        this.idServicio = idServicio;
        this.ruta = ruta;
        this.fecha = fecha;
        this.hora = hora;
        this.conductor = conductor;
        this.tipopago = tipopago;
    }
    
    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public TipoPago getTipopago() {
        return tipopago;
    }

    public void setTipopago(TipoPago tipopago) {
        this.tipopago = tipopago;
    }
    /*
    public static void IngresoServicio(Scanner sc, String nomfile){
        System.out.println("****BIENVENIDO AL SERVICIO DE TAXI****");
        System.out.println("**Ingrese la ruta**");
        System.out.println("Desde: ");
        String desde=sc.next();
        System.out.println("Hacia: ");
        String hacia=sc.next();
        Ruta r=new Ruta(desde, hacia);
        LocalDate dateActual=LocalDate.now();
        
    
    }
*/
    
    
}
