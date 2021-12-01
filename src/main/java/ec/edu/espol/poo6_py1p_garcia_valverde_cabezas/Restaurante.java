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
public class Restaurante {
    private int codRestaurante;
    private String nombreRestaurante;
    private ArrayList<Plato> menu;

    public Restaurante(int codRestaurante, String nombreRestaurante) {
        this.codRestaurante = codRestaurante;
        this.nombreRestaurante = nombreRestaurante;
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
    
    
    public static ArrayList<Restaurante> readFileServiciotxt(String nomfile){
        ArrayList<Restaurante> restaurante=new ArrayList<>();
        try(Scanner sc=new Scanner(new File(nomfile))){
            while(sc.hasNextLine()){
                //linea = "091656,21,null"
                
                String linea=sc.nextLine();
                
                String[] tokens=linea.split(",");
                Restaurante r=new Restaurante(Integer.parseInt(tokens[0]), tokens[1]);
                restaurante.add(r);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());;
        }
        return restaurante;
    }

    @Override
    public String toString() {
        return "Restaurante{" + "codRestaurante=" + codRestaurante + ", nombreRestaurante=" + nombreRestaurante + ", menu=" + menu + '}';
    }
    
    
    
    
    
}
