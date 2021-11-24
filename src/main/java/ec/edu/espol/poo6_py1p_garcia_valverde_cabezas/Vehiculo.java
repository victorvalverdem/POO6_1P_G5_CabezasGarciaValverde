/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.poo6_py1p_garcia_valverde_cabezas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Vehiculo {
    private int codigoVehiculo;
    private String placa;
    private String modelo;
    private String marca;
    private TipoVehiculo tipoVeh;

    public Vehiculo(int codigoVehiculo, String placa, String modelo, String marca, TipoVehiculo tipoVeh) {
        this.codigoVehiculo = codigoVehiculo;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.tipoVeh = tipoVeh;
    }

    public int getCodigoVehiculo() {
        return codigoVehiculo;
    }

    public void setCodigoVehiculo(int codigoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
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
    public static ArrayList<Vehiculo> LeeFichero(String nombrearchivo) {
        ArrayList<Vehiculo> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo,StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                String[] datos=linea.split(",");
                
                TipoVehiculo tpVh=TipoVehiculo.valueOf(datos[4]);
                Vehiculo veh=new Vehiculo(Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],tpVh) ;
                lineas.add(veh);
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lineas;
    }
    
    
}
