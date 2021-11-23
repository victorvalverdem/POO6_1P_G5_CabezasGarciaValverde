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
public class Vehiculo {
    private String placa;
    private String modelo;
    private String marca;
    private TipoVehiculo tipoVeh;

    public Vehiculo(String placa, String modelo, String marca, TipoVehiculo tipoVeh) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.tipoVeh = tipoVeh;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public TipoVehiculo getTipoVeh() {
        return tipoVeh;
    }

    public void setTipoVeh(TipoVehiculo tipoVeh) {
        this.tipoVeh = tipoVeh;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", modelo=" + modelo + ", marca=" + marca + ", tipoVeh=" + tipoVeh + '}';
    }   
    
    
    
}
