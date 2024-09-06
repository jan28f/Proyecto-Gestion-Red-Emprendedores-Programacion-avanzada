import java.util.ArrayList;

public class Emprendimiento
{
  private String nombre;
  private String propietario;
  private ArrayList <Proyecto> proyectos;
  private RecursosApoyos recursosYapoyo;
  private String area;
  private float crecimiento;
    
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
    crecimiento = 0.0f;
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
  public void setRecursosYapoyosEmpleados(int totalApoyo)
  {
    this.recursosYapoyo.setTotalEmpleados(totalApoyo);
  }
  public void setRecursosYapoyosCapital(int capital)
  {
    this.recursosYapoyo.setCapital(capital); 
  }
  public void setRecursosYapoyosMonto(int montoApoyo)
  {
    this.recursosYapoyo.setMontoApoyo(montoApoyo);
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
  public void insertarProyecto(String nombre, String encargado, int personal, int costo)
  {
    for (int i = 0 ;  i < proyectos.size() ; i++)
    {
      if (proyectos.get(i).getNombreProyecto().equals(nombre)) 
      {
        System.out.println("El proyecto ya se encuentra");
        return;
      }
    }
    Proyecto nuevoProyecto = new Proyecto(nombre, encargado, personal, costo);
    proyectos.add(nuevoProyecto);
    System.out.println("Se ha agregado el proyecto de forma correcta");
  }
  public void eliminarProyecto(String aEliminar)
  {
    for (int i = 0 ; i < proyectos.size() ; i++)
    {
      if (proyectos.get(i).getNombreProyecto().equals(aEliminar))
      {
        proyectos.remove(i);
        System.out.println("Se ha eliminado el proyecto " + aEliminar);
        return;
      }
    }
    System.out.println("No se ha encontrado " + aEliminar);
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
    System.out.println("Crecimiento: " + crecimiento + "%");
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
  public float calcularCrecimiento()
  {
    int totalGanancias = 0;
    for (int i = 0 ; i < proyectos.size() ; i++)
    {
      totalGanancias += proyectos.get(i).getGanancias();
    }

    crecimiento += (totalGanancias / (float)recursosYapoyo.getCapital()) * 100;
    return totalGanancias;
  }
  public void resultados()
  {
    int totalProyectos = proyectos.size();
    int proyectosExitosos = 0;
    int proyectosCancelados = 0;
    for (int i = 0 ; i < proyectos.size() ; i++)
    {
      if (proyectos.get(i).getEstadoActual().equals("Completado"))
      {
        proyectosExitosos++;
      }
      else if (proyectos.get(i).getEstadoActual().equals("Cancelado"))
      {
        proyectosCancelados++;
      }
    }

    System.out.println("Resultados del emprendimiento " + nombre + "\n");
    System.out.println("Total de proyectos: " + totalProyectos);
    System.out.println("Proyectos exitosos: " + proyectosExitosos);
    System.out.println("Proyectos cancelados: " + proyectosCancelados);

    if (proyectosExitosos == totalProyectos)
    {
      System.out.println("El emprendimiento ha sido exitoso en todos sus proyectos.");
    } 
    else if (proyectosCancelados == totalProyectos)
    {
      System.out.println("El emprendimiento ha fallado en todos sus proyectos.");
    } 
    else
    {
      System.out.println("El emprendimiento tiene resultados mixtos.");
    }
  }
}