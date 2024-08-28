public class Apoyo
{
  private String nombreApoyo;
  private int montoApoyo;
  private String fechaVencimiento;
  private String estadoApoyo;

  // Constructor
  public Apoyo(String nombreApoyo, int montoApoyo, String fechaVencimiento)
  {
    this.nombreApoyo = nombreApoyo;
    this.montoApoyo = montoApoyo;
    this.fechaVencimiento = fechaVencimiento;
    this.estadoApoyo = "Activo";
  }

  // Setter
  public void setNombreApoyo(String nombreApoyo)
  {
    this.nombreApoyo = nombreApoyo;
  }
  public void setMontoApoyo(int montoApoyo)
  {
    this.montoApoyo = montoApoyo;
  }
  public void setFechaVencimiento(String fechaVencimiento)
  {
    this.fechaVencimiento = fechaVencimiento;
  }
  public void setEstadoApoyo(String estadoApoyo)
  {
    this.estadoApoyo = estadoApoyo;
  }

  // Getter
  public String getNombreApoyo()
  {
    return nombreApoyo;
  }
  public int getMontoApoyo()
  {
    return montoApoyo;
  }
  public String getFechaVencimiento()
  {
    return fechaVencimiento;
  }
  public String getEstadoApoyo()
  {
    return estadoApoyo;
  }
}