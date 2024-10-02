/**
 * Clase encargada de representar el proyecto de un emprendimiento.
 */
public class Proyecto
{
    /**
     * Declaracion de variables de la clase:
     * identificados: Identificador unico del proyecto.
     * nombreProyecto: Nombre del proyecto.
     * encargado: Nombre del encargado del proyecto.
     * personalRequerido: Numero de empleados requeridos para poder realizar el proyecto
     * costo: Costo estimado del proyecto.
     * ganancias: Ganancias generadas por el proyecto.
     * estado: Estado actual del proyecto (En curso, Completo, Cancelado)
     */
    private int identificador;
    private String nombreProyecto;
    private String encargado;
    private int personalRequerido;
    private int costo;
    private int ganancias;
    private String estado;

    // Constructor
    /**
     * Constructor encargado de inicializar un proyecto en estado "En curso" y con ganancias 0.
     * @param identificador Identificador unico del proyecto.
     * @param nombreProyecto Nombre del proyecto.
     * @param encargado Nombre del encargado del proyecto.
     * @param personalRequerido Numero de empleados requeridos para realizar el proyecto.
     * @param costo Costo estimado del proyecto.
     */
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
    /**
     * Constructor encargado de inicializar un proyecto con un estado especificado y con 0 ganancias.
     * @param identificador Identificador unico del proyecto.
     * @param nombreProyecto Nombre del proyecto.
     * @param encargado Nombre del encargado del proyecto.
     * @param personalRequerido Numero de empleados requeridos para realizar el proyecto.
     * @param costo Costo estimado del proyecto.
     * @param estado Estado actual del proyecto.
     */
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
    /**
     * Constructor encargado de inicializar un proyecto con un estado y ganancias especificados anteriormente.
     * @param identificador Identificador unico del proyecto.
     * @param nombreProyecto Nombre del proyecto.
     * @param encargado Nombre del encargado del proyecto.
     * @param personalRequerido Numero de empleados requeridos para realizar el proyecto.
     * @param costo Costo estimado del proyecto.
     * @param ganancias Ganancias generadas por el proyecto.
     * @param estado Estado actual del proyecto.
     */
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
    /**
     * Obtiene el identificador del proyecto.
     * @return Identificador del proyecto.
     */
    public int getIdentificador()
    {
        return identificador;
    }
    /**
     * Obtiene el nombre del proyecto.
     * @return Nombre del proyecto.
     */
    public String getNombreProyecto()
    {
        return nombreProyecto;
    }
    /**
     * Obtiene el nombre del encargado del proyecto.
     * @return Nombre del encargado del proyecto.
     */
    public String getEncargado()
    {
        return encargado;
    }
    /**
     * Obtiene el numero de empleados requeridos para el proyecto.
     * @return Empleados requeridos para el proyecto.
     */
    public int getPersonalRequerido()
    {
        return personalRequerido;
    }
    /**
     * Obtiene el costo estimado del proyecto.
     * @return Costo estimado del proyecto.
     */
    public int getCosto()
    {
        return costo;
    }
    /**
     * Obtiene las ganancias generadasa por el proyecto.
     * @return Ganancias del proyecto.
     */
    public int getGanancias()
    {
        return ganancias;
    }
    /**
     * Obtiene el estado actual del proyecto.
     * @return Estado actual del proyecto.
     */
    public String getEstado()
    {
        return estado;
    }

    //Setter
    /**
     * Establece el identificador unico del proyecto.
     * @param identificador Nuevo identificador.
     */
    public void setIdentificador(int identificador)
    {
        this.identificador = identificador;
    }
    /**
     * Establece el nuevo nombre del proyecto.
     * @param nombreProyecto Nuevo nombre del proyecto.
     */
    public void setNombreProyecto(String nombreProyecto)
    {
        this.nombreProyecto = nombreProyecto;
    }
    /**
     * Establece el nuevo encargado del proyecto.
     * @param encargado Nombre del nuevo encargado.
     */
    public void setEncargado(String encargado)
    {
        this.encargado = encargado;
    }
    /**
     * Establece el nuevo total de personal requerido por el proyecto.
     * @param personalRequerido Nuevo total de personal requerido.
     */
    public void setPersonalRequerido(int personalRequerido)
    {
        this.personalRequerido = personalRequerido;
    }
    /**
     * Establece el nuevo costo estimado del proyecto.
     * @param costo Nuevo costo estimado.
     */
    public void setCosto(int costo)
    {
        this.costo = costo;
    }
    /**
     * Establece la nueva cantidad de ganancias del proyecto.
     * @param ganancias Nuevo monto de ganancias.
     */
    public void setGanancias(int ganancias)
    {
        this.ganancias = ganancias;
    }
    /**
     * Establece el nuevo estado actual del proyecto.
     * @param estado Estado actual.
     */
    public void setEstadoActual(String estado)
    {
        this.estado = estado;
    }
    
    // Metodos
    /**
     * Muestra la informacion detallada del proyecto.
     */
    public void info()
    {
        System.out.println("Identificador del proyecto: " + identificador);
        System.out.println("Nombre del proyecto: " + nombreProyecto);
        System.out.println("Encargado: " + encargado);
        System.out.println("Costo: " + costo);
        System.out.println("Personal: " + personalRequerido);
        System.out.println("Estado: " + estado);
    }
    /**
     * Se registran las ganancias y perdidas del proyecto.
     * Si la ganancia final es negativa, se cambia el estado del proyecto a "Cancelado".
     * @param ganancias Monto de ganancias generadas.
     * @param perdidas Monto de perdidas.
     */
    public void registrarGanancias(int ganancias, int perdidas)
    {
        this.ganancias += (ganancias - perdidas);
        if (this.ganancias < 0)
        {
            estado = "Cancelado";
            System.out.println("Se ha cancelado el proyecto debido a las perdidas");
        }
    }
    /**
     * Se registran solo las ganancias del proyecto.
     * @param ganacias Monto de ganancias generadas.
     */
    public void registrarGanancias(int ganacias)
    {
        registrarGanancias(ganacias, 0);
    }
}  
