public class Proyecto
  {
    private String nombreProyecto;
    private String encargado;
    private int personalRequerido;
    private int costoEstimado;
    private int ganancias;
    private String estadoActual;
    public Proyecto(String nombreProyecto,String encargado,int personalRequerido, int  costoEstimado, String estadoActual)
    {
      this.nombreProyecto = nombreProyecto;
      this.encargado = encargado;
      this.personalRequerido = personalRequerido;
      this.costoEstimado = costoEstimado;
      this.estadoActual = estadoActual;
    }
    public Proyecto(String nombreProyecto,String encargado,int personalRequerido, int  costoEstimado)
    {
      this.nombreProyecto = nombreProyecto;
      this.encargado = encargado;
      this.personalRequerido = personalRequerido;
      this.costoEstimado = costoEstimado;
      this.estadoActual = "Activo";
    }
    //Getter
    public String getNombreProyecto()
    {
      return nombreProyecto;
    } 
    public String getEncargado()
    {
      return encargado;
    }
    public int getPersonalRequerido()
    {
      return personalRequerido;
    }
    public int getCostoEstimado()
    {
      return costoEstimado;
    }
    public int getGanancias()
    {
      return ganancias;
    }
    public String getEstadoActual()
    {
      return estadoActual;
    }
    //Setter
    public void setNombreProyecto(String nombreProyecto)
    {
      this.nombreProyecto = nombreProyecto;
    } 
    public void setEncargado(String encargado)
    {
      this.encargado = encargado;
    }
    public void setPersonalRequerido(int personalRequerido)
    {
      this.personalRequerido = personalRequerido;
    }
    public void setCostoEstimado(int costoEstimado)
    {
      this.costoEstimado = costoEstimado;
    }
    public void setGanancias(int ganancias)
    {
      this.ganancias = ganancias;
    }
    public void setEstadoActual(String estadoActual)
    {
      this.estadoActual = estadoActual;
    }
    
    public void info()
    {
      System.out.println("Nombre del proyecto: " + nombreProyecto);
      System.out.println("Encargado: " + encargado);
      System.out.println("Costo: " + costoEstimado);
      System.out.println("Personal: " + personalRequerido);
      System.out.println("Estado: " + estadoActual);
    }
    public void registrarGanancias(int ganancias)
    {
      this.ganancias +=  ganancias;
      if (this.ganancias < 0)
      {
        estadoActual = "Cancelado";
        System.out.println("Se ha cancelado el proyecto debido a las perdidas");
      }
    }
    public void registrarGanancias(int ganancias, int perdidas)
    {
      this.ganancias += (ganancias - perdidas);
      if (this.ganancias < 0)
      {
        estadoActual = "Cancelado";
        System.out.println("Se ha cancelado el proyecto debido a las perdidas");
      }
    }
  }  
