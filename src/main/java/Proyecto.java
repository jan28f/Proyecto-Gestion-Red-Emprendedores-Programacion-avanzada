public class Proyecto
{
    private int identificador;
    private String nombreProyecto;
    private String encargado;
    private int personalRequerido;
    private int costo;
    private int ganancias;
    private String estado;

    // Constructor
    public Proyecto(int identificador, String nombreProyecto, String encargado, int personalRequerido, int costo)
    {
        this.identificador = identificador;
        this.nombreProyecto = nombreProyecto;
        this.encargado = encargado;
        this.personalRequerido = personalRequerido;
        this.costo = costo;
        ganancias = 0;
        this.estado = "En curso";
    }
    public Proyecto(int identificador, String nombreProyecto, String encargado,int personalRequerido, int costo, String estado)
    {
        this.identificador = identificador;
        this.nombreProyecto = nombreProyecto;
        this.encargado = encargado;
        this.personalRequerido = personalRequerido;
        this.costo = costo;
        ganancias = 0;
        this.estado = estado;
    }
    public Proyecto(int identificador, String nombreProyecto, String encargado,int personalRequerido, int costo, int ganancias, String estado)
    {
        this.identificador = identificador;
        this.nombreProyecto = nombreProyecto;
        this.encargado = encargado;
        this.personalRequerido = personalRequerido;
        this.costo = costo;
        this.ganancias = ganancias;
        this.estado = estado;
    }
    
    //Getter
    public int getIdentificador()
    {
        return identificador;
    }
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
    public int getCosto()
    {
        return costo;
    }
    public int getGanancias()
    {
        return ganancias;
    }
    public String getEstado()
    {
        return estado;
    }

    //Setter
    public void setIdentificador(int identificador)
    {
        this.identificador = identificador;
    }
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
    public void setCosto(int costo)
    {
        this.costo = costo;
    }
    public void setGanancias(int ganancias)
    {
        this.ganancias = ganancias;
    }
    public void setEstadoActual(String estado)
    {
        this.estado = estado;
    }
    
    // Metodos
    public void info()
    {
        System.out.println("Identificador del proyecto: " + identificador);
        System.out.println("Nombre del proyecto: " + nombreProyecto);
        System.out.println("Encargado: " + encargado);
        System.out.println("Costo: " + costo);
        System.out.println("Personal: " + personalRequerido);
        System.out.println("Estado: " + estado);
    }
    public void registrarGanancias(int ganancias, int perdidas)
    {
        this.ganancias += (ganancias - perdidas);
        if (this.ganancias < 0)
        {
            estado = "Cancelado";
            System.out.println("Se ha cancelado el proyecto debido a las perdidas");
        }
    }
    public void registrarGanancias(int ganacias)
    {
        registrarGanancias(ganacias, 0);
    }
}  
