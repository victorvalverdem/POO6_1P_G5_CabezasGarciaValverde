public class Taxi extends Servicio
{
  private int numeroPersona;
  /* Servicio tiene que tener un constructor con lo que sale de parámetro del main, lo realizamos
  */
  public Taxi(Ruta ruta, localDate fecha, String hora, TipoPago tipoPago, numeroPersona)
  {
    super(Ruta ruta, localDate fecha, String hora, TipoPago tipoPago);
    this.numeroPesona = numeroPersona;
  }
}