/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.poo6_py1p_garcia_valverde_cabezas;

import java.util.ArrayList;

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
    
    
}
