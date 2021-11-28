import java.lang.Math;

public abstract class Servicio
{
  protected int idServicio;
  protected Ruta ruta;
  protected localDate fecha;
  protected String hora;
  protected Conductor Conductor;
  protected TipoPago tipoPago;

  public Servicio(Ruta ruta, localDate fecha, String hora, TipoPago tipoPago)
  {
    this.ruta = ruta;
    this.fecha = fecha;
    this.hora = hora;
    this.tipoPago = tipoPago
  }


  public double calcularPrecioServicio(){
    int min = 1;
    int max = 10;
    double precio = 
    Math.random()*(max-min+1)+min;
    return precio;
  }
  
  public double calcularPrecioServicio(String credito)
    {
      double precio_base = calcularPrecioServicio();
      double precio_final = precio_base + (precio_base*10)/100;
      return precio_final;
    }
}