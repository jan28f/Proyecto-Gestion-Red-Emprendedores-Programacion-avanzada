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
  }
