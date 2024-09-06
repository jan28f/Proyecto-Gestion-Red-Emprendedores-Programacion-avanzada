import java.util.ArrayList;
public class Emprendimiento
  {
    private String nombre;
    private String propietario;
    private ArrayList <Proyecto> proyectos;
    private RecursosApoyos recursosYapoyo;
    private String area;
    
    public Emprendimiento(String nombre, String propietario , String area)
    {
      this.nombre = nombre;
      this.propietario = propietario;
      proyectos = new ArrayList<Proyecto>();
      this.recursosYapoyo = new RecursosApoyos(5,100000,20000);
      this.area = area;
    }
    public Emprendimiento(String nombre, String propietario , String area, RecursosApoyos recursosApoyos)
    {
      this.nombre = nombre;
      this.propietario = propietario;
      proyectos = new ArrayList<Proyecto>();
      this.recursosYapoyo = recursosApoyos;
      this.area = area;
    }
    //Getters
    public String getNombre()
    {
      return nombre;
    }
    public String getPropietario()
    {
      return propietario;
    }
    public String getArea()
    {
      return area;
    }
    public RecursosApoyos getRecursosYApoyo()
    {
      return recursosYapoyo;
    }  
    //Setter
    public void setNombre(String nombre)
    {
      this.nombre = nombre;
    }
    public void setPropietario(String propietario)
    {
      this.propietario = propietario;
    }
    public void setArea(String area)
    {
      this.area = area;
    }
    
    public void insertarProyecto(Proyecto project)
    {
      boolean esta = false;
      for (int i = 0 ;  i < proyectos.size() ; i++)
        {
           if (proyectos.get(i).getNombreProyecto().equals(project.getNombreProyecto())) 
               {
                 System.out.println("El proyecto ya se encuentra");
                 esta = true;
                 break;
               }
        }
      if (esta == false)
      {
        proyectos.add(project);
        System.out.println("Se ha agregado el proyecto de forma correcta");
      }
    }
    public void info()
    {
      System.out.println("Nombre del emprendimiento: " + nombre);
      System.out.println("Propietario del emprendimiento: " + propietario);
      System.out.println("Area de trabajo del emprendimiento: " + area);
      RecursosApoyos recursosApoyos = this.getRecursosYApoyo();
      System.out.println("Empleados del emprendimiento: " + recursosApoyos.getTotalEmpleados());
      System.out.println("Capital monetario del emprendimiento: " + recursosApoyos.getCapital());
      System.out.println("Total de apoyo monetario del emprendimiento: " + recursosApoyos.getMontoApoyo());
    }
    public void verProyectos()
    {
      int totalProyectos = proyectos.size();
      if (totalProyectos == 0)
      {
        System.out.println("No se tienen proyectos registrados");
      }
      else
      {
        System.out.println("Lista de proyectos:\n");
        for (int i = 0 ; i < totalProyectos ; i++)
        {
          Proyecto proyecto = proyectos.get(i);
          proyecto.info();
          System.out.println();
        }
      }
    }
    public Proyecto getProyecto(String aBuscar)
    {
      for (int i = 0 ; i < proyectos.size() ; i++)
      {
        Proyecto proyecto = proyectos.get(i);
        if (proyecto.getNombreProyecto().equals(aBuscar))
        {
          return proyecto;
        }
      }
      return null;
    }
  }  