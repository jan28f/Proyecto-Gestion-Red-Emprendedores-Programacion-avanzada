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
    //Setters
    public void setNombre(String nombre)
    {
      this.nombre = nombre;
    }
    public void setEdad(int edad)
    {
      this.edad = edad;
    }
    public void setProfesion(String profesion)
    {
      this.profesion = profesion;
    }  
    public void setExperiencia(String experiencia)
    {
      this.experiencia = experiencia;
    }  
    //Getters
    public String getNombre()
    {
      return nombre;
    }
    public int getEdad()
    {
      return edad;
    }  
    public String getProfesion()
    {
      return profesion;
    }  
    public String getExperiencia()
    {
      return experiencia;
    }  
  }
