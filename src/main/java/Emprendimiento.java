import java.util.ArrayList;

public class Emprendimiento
  {
    private String nombreEmprendimiento;
    private String nombrePropietario;
    private String especialidad;
    private ArrayList<Proyecto> proyectos;
    private int capitalMonetario;
    private int totalEmpleados;
    private ArrayList<Apoyo> apoyos;

    public Emprendimiento(String nombreEmprendimiento, String nombrePropietario, String especialidad, int capitalMonetario, int totalEmpleados)
    {
      this.nombreEmprendimiento = nombreEmprendimiento;
      this.nombrePropietario = nombrePropietario;
      this.especialidad = especialidad;
      this.capitalMonetario = capitalMonetario;
      this.totalEmpleados = totalEmpleados;
      this.proyectos = new ArrayList<Proyecto>();
      this.apoyos = new ArrayList<Apoyo>();
    }

    // Setters
    public void setNombreEmprendimiento(String nombreEmprendimiento)
    {
      this.nombreEmprendimiento = nombreEmprendimiento;
    }
    public void setNombrePropietario(String nombrePropietario)
    {
      this.nombrePropietario = nombrePropietario;
    }
    public void setEspecialidad(String especialidad)
    {
      this.especialidad = especialidad;
    }
    public void setCapitalMonetario(int capitalMonetario)
    {
      this.capitalMonetario = capitalMonetario;
    }
    public void setTotalEmpleados(int totalEmpleados)
    {
      this.totalEmpleados = totalEmpleados;
    }
    
    // Getters
    public String getNombreEmprendimiento()
    {
      return nombreEmprendimiento;
    }
    public String getNombrePropietario()
    {
      return nombrePropietario;
    }
    public String getEspecialidad()
    {
      return especialidad;
    }
    public int getCapitalMonetario()
    {
      return capitalMonetario;
    }
    public int getTotalEmpleados()
    {
      return totalEmpleados;
    }
    public ArrayList<Proyecto> getProyectos()
    {
      return proyectos;
    }
    public ArrayList<Apoyo> getApoyos()
    {
      return apoyos;
    }
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
        
        //Constructores
        public Proyecto(String nombreProyecto, String empresaEncargada, String liderProyecto,int personalRequerido, int personalActual, int costoEstimado, int gastoActual,String estadoActual)
        {
           this.nombreProyecto = nombreProyecto;
           this.empresaEncargada = empresaEncargada;
           this.liderProyecto = liderProyecto;
           this.personalRequerido = personalRequerido;
           this.personalActual = personalActual;
           this.costoEstimado = costoEstimado;
           this.gastoActual = gastoActual;
           this.estadoActual = estadoActual;
        }
        //Setters
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
        //Gettters 
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
    public class Apoyo
      {
        private String nombreApoyo;
        private int montoApoyo;
        private String fechaVencimiento;
        private String estadoApoyo;

        //Constructor
        public Apoyo(String nombreApoyo,int montoApoyo, String fechaVencimiento, String estadoApoyo)
        {
          this.nombreApoyo = nombreApoyo;
          this.montoApoyo = montoApoyo;
          this.fechaVencimiento = fechaVencimiento;
          this.estadoApoyo = estadoApoyo;
        }

        //Setter
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

        //Gettters
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
  }
