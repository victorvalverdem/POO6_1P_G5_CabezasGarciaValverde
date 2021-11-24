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
public class Restaurante {
    private int codRestaurante;
    private String nombreRestaurante;
    private ArrayList<Plato> menu;

    public Restaurante(int codRestaurante, String nombreRestaurante, ArrayList<Plato> menu) {
        this.codRestaurante = codRestaurante;
        this.nombreRestaurante = nombreRestaurante;
        this.menu = menu;
    }

    public int getCodRestaurante() {
        return codRestaurante;
    }

    public void setCodRestaurante(int codRestaurante) {
        this.codRestaurante = codRestaurante;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public ArrayList<Plato> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Plato> menu) {
        this.menu = menu;
    }
    
    
    
}
