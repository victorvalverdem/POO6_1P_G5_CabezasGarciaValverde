/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.poo6_py1p_garcia_valverde_cabezas;

import java.time.LocalDate;

/**
 *
 * @author USER
 */
public class Delivery extends Servicio{
    private Pedido pedido;

    public Delivery(Pedido pedido, int idServicio, Ruta ruta, LocalDate fecha, String hora, Conductor conductor, TipoPago tipopago) {
        super(idServicio, ruta, fecha, hora, conductor, tipopago);
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    
    
}
