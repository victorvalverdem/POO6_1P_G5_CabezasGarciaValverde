/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.poo6_py1p_garcia_valverde_cabezas;

import ec.edu.espol.util.Util;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author USER
 */
public class NewMain {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        ArrayList<String> usuario=Usuario.LeeFicheroUsuario("usuarios.txt");
        ArrayList<Cliente> cliente=Cliente.readFileClientestxt("clientes.txt");
        ArrayList<Conductor> conductores=Conductor.readFileConductortxt("conductores.txt");
        ArrayList<Vehiculo> vehiculos=Vehiculo.readFileVehiculotxt("vehiculos.txt");
        int opcion;
        Scanner sc=new Scanner(System.in);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("                   BIENVENIDOS AL SISTEMA                  ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("1. Iniciar Sesion");
        System.out.println("2. Registrar nuevo Usuario");
        System.out.println("3. Salir");
        System.out.println("Elija una opcion: ");
        int eleccion=sc.nextInt();
        int nuevaOpcion;
        int otraOpcion;
        int elejir;
        do{
            boolean sub_salir= false;
            switch (eleccion) {
                case 1: {
                    boolean validar = Util.ValidarUsuario(sc,usuario);
                    do {
                        Util.ValidarUsuario(sc,usuario);
                    } while (validar == false);
                    if(validar==true){
                        
                    }

                }
                case 2:{
                    
                    do{
                        System.out.println("1. Registrar Cliente");
                        System.out.println("2. Registrar Conductor");
                        System.out.println("3. Regresar");
                        System.out.println("Elegir una opcion: ");
                        elejir = sc.nextInt();
                        switch (elejir){ 
                            case 1: {
                                String nombreCliente=Cliente.MenuClienteNuevo(sc, cliente);
                                int menuCli=Util.MenuCliente(sc);
                                switch(menuCli){
                                    case 1:{
                                        String Respuesta = Taxi.ServicioTaxi(sc, conductores, vehiculos, nombreCliente);
                                        if (Respuesta.equals("NO")) {
                                            sub_salir = true;
                                            break;
                                        }
                                    }
                                    
                                    case 2:{
                                        String resp=Delivery.ServicioDelivery(sc, conductores, vehiculos, nombreCliente);
                                        if(resp.equals("NO")){
                                            sub_salir =true;
                                            break;
                                        }
                                    }
                                    
                                    case 3:{
                                        String RespuestaEncomienda= EntregaEncomienda.ServicioEncomienda(sc, conductores, vehiculos, nombreCliente);
                                        
                                    
                                    }
                                        
                                
                                }
                                
                                

                            }
                            case 2: {

                                Conductor.MenuNuevoConductor(sc, conductores, vehiculos);
                            }
                            
                            case 3:{
                                sub_salir=true;
                                break;  
                            }

                            default:
                                System.out.println("Elija una opcion");
                        }
                        
                    }while(elejir!=4);
                    break;

                }
                case 3: 
                {
                    System.out.println("Gracias por visitarnos");
                    break;
                } 
                    
                default:
                    System.out.println("El programa solo tiene 3 opciones");
            }
                
        }while(eleccion != 3);
        
    }
}

            
        
    
        
