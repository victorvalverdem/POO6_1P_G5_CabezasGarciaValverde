/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.poo6_py1p_garcia_valverde_cabezas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Pedido {
    private int numeroPedido;
    private ArrayList<Plato> platoSeleccionado;
    private Restaurante restaurante;
    
    
    public Pedido(int numeroPedido, ArrayList<Plato> platoSeleccionado, Restaurante restaurante) {
        this.numeroPedido = numeroPedido;
        this.platoSeleccionado = platoSeleccionado;
        this.restaurante = restaurante;
    }
    
    
    

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public ArrayList<Plato> getPlatoSeleccionado() {
        return platoSeleccionado;
    }

    public void setPlatoSeleccionado(ArrayList<Plato> platoSeleccionado) {
        this.platoSeleccionado = platoSeleccionado;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
    
    public void saveFilePedido(String nomfile,ArrayList<Plato> platoSeleccionado){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            for(Plato p:platoSeleccionado){
                double precio=Pedido.PrecioPlato(platoSeleccionado, p.getNombrePlato());
                pw.println(this.numeroPedido+","+this.restaurante.getCodRestaurante()+","+p.getNombrePlato()+","+precio);
            }
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Plato> platoSeleccionado(Scanner sc){
        System.out.println("****SELECCIONAR PLATO****");
        ArrayList<String> plato=new ArrayList<>();
        
        System.out.println("Escriba el nombre del plato: ");
        String nombrePlato=sc.next();
        plato.add(nombrePlato);
        System.out.println("Desea registrar más platos? SI/NO: ");
        String respuesta=sc.next().toLowerCase();
        while(respuesta.equals("SI")){
            System.out.println("Escriba el nombre del plato: ");
            String nombre=sc.next();
            plato.add(nombre);
        }
        ArrayList<Plato> platos=Plato.readFileServiciotxt("menus.txt");
        ArrayList<Plato> platoSelecc=new ArrayList<>();
        for(String s: plato){
            for(Plato p:platos){
                if(p.getNombrePlato().equals(s)){
                    platoSelecc.add(p);
                }
            }
        }
        return platoSelecc;
    }
    
    public static double PrecioPlato(ArrayList<Plato> platos, String nombrePlato){
        double precio=0;
        for(Plato p: platos){
            if(p.getNombrePlato().equals(nombrePlato)){
                precio+=p.getPrecio();
            }
        }
        return precio;
    }
    
    
    @Override
    public String toString() {
        
        
        return "Pedido{" + "numeroPedido=" + numeroPedido + ", platoSeleccionado=" + platoSeleccionado + ", restaurante=" + restaurante + '}';
    }
    
    
    
    
}
