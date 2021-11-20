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
public class Cliente extends Usuario{
    private String numeroTarjeta;
    private int edad;
    private Pago pago;

    public Cliente(String numeroTarjeta, int edad, Pago pago, String numeroCedula, String nombre, String apellido, String usuario, String contrasena, String celular, String tipoUsuario) {
        super(numeroCedula, nombre, apellido, usuario, contrasena, celular, tipoUsuario);
        this.numeroTarjeta = numeroTarjeta;
        this.edad = edad;
        this.pago = pago;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
    
    
    
    
    
}