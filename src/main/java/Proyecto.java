public class Proyecto
{
  private String nombreProyecto;
  private String empresaEncargada;
  private String liderProyecto;
  private int personalRequerido;
  private int personalActual;
  private int costoEstimado;
  private int gastoActual;
  private String estadoActual;

  // Constructor
  public Proyecto(String nombreProyecto, String empresaEncargada, String liderProyecto, int personalRequerido, int personalActual, int costoEstimado)
  {
    this.nombreProyecto = nombreProyecto;
    this.empresaEncargada = empresaEncargada;
    this.liderProyecto = liderProyecto;
    this.personalRequerido = personalRequerido;
    this.personalActual = personalActual;
    this.costoEstimado = costoEstimado;
    this.gastoActual = 0;
    this.estadoActual = "En ejecucion";
  }

  // Setter
  public void setNombreProyecto(String nombreProyecto)
  {
    this.nombreProyecto = nombreProyecto;
  }
  public void setEmpresaEncargada(String empresaEncargada)
  {
    this.empresaEncargada = empresaEncargada;
  }
  public void setLiderProyecto(String liderProyecto)
  {
    this.liderProyecto = liderProyecto;
  }
  public void setPersonalRequerido(int personalRequerido)
  {
    this.personalRequerido = personalRequerido;
  }
  public void setPersonalActual(int personalActual)
  {
    this.personalActual = personalActual;
  }
  public void setCostoEstimado(int costoEstimado)
  {
    this.costoEstimado = costoEstimado;
  }
  public void setGastoActual(int gastoActual)
  {
    this.gastoActual = gastoActual;
  }
  public void setEstadoActual(String estadoActual)
  {
    this.estadoActual = estadoActual;
  }
  
  // Getter
  public String getNombreProyecto()
  {
    return nombreProyecto;
  }
  public String getEmpresaEncargada()
  {
    return empresaEncargada;
  }
  public String getLiderProyecto()
  {
    return liderProyecto;
  }
  public int getPersonalRequerido()
  {
    return personalRequerido;
  }
  public int getPersonalActual()
  {
    return personalActual;
  }
  public int getCostoEstimado()
  {
    return costoEstimado;
  }
  public int getGastoActual()
  {
    return gastoActual;
  }
  public String getEstadoActual()
  {
    return estadoActual;
  }
}