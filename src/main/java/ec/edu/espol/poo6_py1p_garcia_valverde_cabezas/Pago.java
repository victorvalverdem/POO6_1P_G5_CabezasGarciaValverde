/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.poo6_py1p_garcia_valverde_cabezas;

/**
 *
 * @author USER
 */
public class Pago {
    private int totalPagar;
    private Cliente cliente;
    private Servicio servicio;

    public Pago(int totalPagar, Cliente cliente, Servicio servicio) {
        this.totalPagar = totalPagar;
        this.cliente = cliente;
        this.servicio = servicio;
    }

    public int getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(int totalPagar) {
        this.totalPagar = totalPagar;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return "Pago{" + "totalPagar=" + totalPagar + ", cliente=" + cliente + ", servicio=" + servicio + '}';
    }
    
    
    
}
