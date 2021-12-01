/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.poo6_py1p_garcia_valverde_cabezas;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Plato {
    private int codRestaurante;
    private String nombrePlato;
    private int precio;

    public Plato(int codRetaurante, String nombrePlato, int precio) {
        this.codRestaurante=codRetaurante;
        this.nombrePlato = nombrePlato;
        this.precio = precio;
    }

    public int getCodRestaurante() {
        return codRestaurante;
    }

    public void setCodRestaurante(int codRestaurante) {
        this.codRestaurante = codRestaurante;
    }
    
    

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public static ArrayList<Plato> readFileServiciotxt(String nomfile){
        ArrayList<Plato> plato = new ArrayList<>();
        try(Scanner sc=new Scanner(new File(nomfile))){
            while(sc.hasNextLine()){
                //linea = "091656,21,null"
                String linea=sc.nextLine();
                
                String[] tokens=linea.split(",");
                Plato p=new Plato(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]));
                plato.add(p);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());;
        }
        return plato;
    }
    
    
    
    
    
    
}
