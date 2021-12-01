/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.poo6_py1p_garcia_valverde_cabezas;

import static ec.edu.espol.poo6_py1p_garcia_valverde_cabezas.Servicio.valorPagar;
import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Delivery extends Servicio{
    private Pedido pedido;
    private double valorApagar;

    public Delivery(int idServicio, Ruta ruta, LocalDate fecha, String hora, Conductor conductor, TipoPago tipopago, Double ValorApagar, Pedido pedido) {
        super(idServicio, ruta, fecha, hora, conductor, tipopago);
        this.pedido = pedido;
        this.valorApagar=ValorApagar;
    }
    
    public Delivery(int idServicio, Ruta ruta, LocalDate fecha, String hora, Conductor conductor, TipoPago tipopago, Double ValorApagar) {
        super(idServicio, ruta, fecha, hora, conductor, tipopago);
        this.valorApagar=ValorApagar;
    }
    
    

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public double getValorApagar() {
        return valorApagar;
    }

    public void setValorApagar(double valorApagar) {
        this.valorApagar = valorApagar;
    }
    
    
    public void saveFileDelivery(String nomfile, String nombreCliente, String nombreConductor){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(idServicio+","+nombreCliente+","+nombreConductor+","+super.ruta.getOrigen()+","+super.ruta.getDestino()+","+super.getFecha()+","+super.getHora()+","+this.pedido.getNumeroPedido()+","+super.tipopago+","+this.valorApagar);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    /*
    public static ArrayList<Servicio> readFileServiciotxt(String nomfile, Conductor c){
        ArrayList<Servicio> servicio = new ArrayList<>();
        try(Scanner sc=new Scanner(new File(nomfile))){
            while(sc.hasNextLine()){
                //linea = "091656,21,null"
                String linea=sc.nextLine();
                
                String[] tokens=linea.split(",");
                String rutaIn=tokens[3];
                String rutaF=tokens[4];
                Ruta r=new Ruta(rutaIn, rutaF);
                LocalDate Fecha=LocalDate.parse(tokens[5]);
                TipoPago tp=TipoPago.valueOf(tokens[8]);
                //( int idServicio, Ruta ruta, LocalDate fecha, String hora, Conductor conductor, int numeroPersona,TipoPago tipopago, double valorApagar
                Servicio s=new EntregaEncomienda(Integer.parseInt(tokens[0]),r,Fecha,tokens[3],c,Integer.parseInt(tokens[7]),tp,Double.parseDouble(tokens[9]));
                servicio.add(s);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());;
        }
        return servicio;
    }
*/
    public static String ServicioDelivery(Scanner sc, ArrayList<Conductor> conductores, ArrayList<Vehiculo> vehiculos, String nombreCliente){
        //String tp;
        System.out.println("****BIENVENIDO AL SERVICIO DE DELIVERY DE COMIDA****");
        int IDDelivey=Util.GenerarID("delivery.txt");
        System.out.println("**Ingrese la ruta**");
        System.out.println("Desde: ");
        String desde=sc.next();
        System.out.println("Hacia: ");
        String hacia=sc.next();
        Ruta r=new Ruta(desde, hacia);
        System.out.println("Ingrese la Fecha del viaje(AAAA-MM-DD): ");
        String ld=sc.next();
        LocalDate LD=LocalDate.parse(ld);
        System.out.println("Hora de Viaje: ");
        String hora=sc.next();
        System.out.println("Tipo de pago (EFECTIVO/TARJETACREDITO): ");
        String tp=sc.next();
        TipoPago TP=TipoPago.valueOf(tp);
        System.out.println("Numero de Personas que viajarán: ");
        int numPersonas=sc.nextInt();
        String nombreConductor=Conductor.EleccionConductorMoto(conductores, vehiculos);
        Conductor cond=Conductor.ApartirdelNombre(conductores, nombreConductor);
        Double Valorp= valorPagar(TP);
        ArrayList<Plato> platoSeleccionado=Pedido.platoSeleccionado(sc);        

       //int idServicio, Ruta ruta, LocalDate fecha, String hora, Conductor conductor, TipoPago tipopago, Double ValorApagar, Pedido pedido   
        System.out.println("Acepta el Delivery? SI/NO");
        String respuesta=sc.next();
        if(respuesta.equals("SI")){
            for(Plato p: platoSeleccionado){
            int IDpedido=Util.GenerarID("pedidos.txt");
            Delivery s=new Delivery(IDDelivey, r, LD, hora, cond, TP, Valorp );
            s.saveFileDelivery("delivery.txt", nombreCliente, nombreConductor); 
            return "SI";
            }
            
        }
        else{
            return "NO";
        }
        return null;
    }
    
    
}
