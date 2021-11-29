/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.poo6_py1p_garcia_valverde_cabezas;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
 // Clase abstracta?
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

    public double calcularPrecioServicio()
    {
      int min = 1;
      int max = 10;
      double precio = Math.random()*(max-min+1)+min;
      return precio;
  }
    public static ArrayList<Servicio> readFileClientestxt(String nomfile){
        ArrayList<Servicio> servicio = new ArrayList<>();
        try(Scanner sc=new Scanner(new File(nomfile))){
            while(sc.hasNextLine()){
                //linea = "091656,21,null"
                String linea=sc.nextLine();
                
                String[] tokens=linea.split(",");
                
                Servicio c=new Cliente(tokens[0],tokens[1],Integer.parseInt(tokens[2]));
                clientes.add(c);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());;
        }
        return clientes;
    }

  // Aquí la sobrecarga; invocación del adecuado se da en la condicional del menú
  
  public double calcularPrecioServicio(TipoPago tipopago)
    {
      double precio_base = calcularPrecioServicio();
      double precio_final = precio_base + (precio_base*10)/100;
      return precio_final;
    }

    /* Métodos anteriores de calcularPrecio Stephany
    public static double valorPagar(TipoPago p){
        double numAle=Math.random()*100;
        if(p.equals(p.TARJETACREDITO)){
            double aumen=numAle+(numAle*0.10);
            return aumen;
        }
        else
            return numAle;
    */
    
    
    
    
}
