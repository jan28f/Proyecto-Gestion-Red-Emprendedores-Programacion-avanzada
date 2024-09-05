public class Emprendimiento
  {
    private String nombre;
    private String propietario;
    private String ArrayList <Proyecto> proyectos;
    private RecursosApoyos recursosYapoyo;
    private String area;
    public Emprendimiento(String nombre, String propietario , String area)
    {
      this.nombre = nombre;
      this.propietario = propietario;
      proyectos = new ArrayList<Proyecto>();
      recursosYapoyo = new Proyecto();
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
    
  }  
