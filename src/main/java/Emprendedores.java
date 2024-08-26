public class Emprendedores
  {
    private String nombre;
    private int edad;
    private String profesion;
    private String experiencia;

    public Emprendedores(String nombre,int edad,String profesion, String experiencia)
    {
      this.nombre = nombre;
      this.edad = edad;
      this.profesion = profesion;
      this.experiencia = experiencia;
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
