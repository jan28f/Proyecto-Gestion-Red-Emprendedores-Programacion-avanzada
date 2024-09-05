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
      recursosYapoyo = new RecursosApoyos();
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
    public String buscarPorNombre(HashMap<String,Emprendimiento> mapa , String name)
        {
          if (mapa.containsKey(name))
          {
            Emprendimiento aux = mapa.get(name);
            return aux.getNombre() + aux.getPropietario();
          }
          else
          {
            return "No se encontro el nombre del emprendimiento";
          }  
        }
  }  
