public class ProyectoTecnologico extends Proyecto
{
    /**
     * Declaracion de variables de la clase:
     * tecnologiaUsada: Se indica la tecnologia que se utiliza para llevar a cabo el proyecto.
     */
    private String tecnologiaUsada;

    // Constructor
    /**
     * Constructor encargado de inicializar un proyecto tecnologico con estado "En curso" y 0 ganancias y con la tecnologia con la que se lleva a cabo.
     * @param identificador Identificador unico del proyecto.
     * @param nombreProyecto Nombre del proyecto.
     * @param encargado Nombre del encargado del proyecto.
     * @param personalRequerido Numero de empleados requeridos para realizar el proyecto.
     * @param costo Costo estimado del proyecto.
     * @param tecnologiaUsada Tecnologia con la que se lleva a cabo el proyecto.
     */
    public ProyectoTecnologico(int identificador, String nombreProyecto, String encargado, int personalRequerido, int costo, String tecnologiaUsada)
    {
        super(identificador, nombreProyecto, encargado, personalRequerido, costo);
        this.tecnologiaUsada = tecnologiaUsada;
    }
    /**
     * Constructor encargado de inicializar un proyecto tecnologico con un estado y ganancias especifico.
     * @param identificador Identificador unico del proyecto.
     * @param nombreProyecto Nombre del proyecto.
     * @param encargado Nombre del encargado del proyecto.
     * @param personalRequerido Numero de empleados requeridos para realizar el proyecto.
     * @param costo Costo estimado del proyecto.
     * @param ganancias Ganancias del proyecto.
     * @param estado Estado actual del proyecto.
     * @param tecnologiaUsada Tecnologia con la que se lleva a cabo el proyecto.
     */
    public ProyectoTecnologico(int identificador, String nombreProyecto, String encargado, int personalRequerido, int costo, int ganancias, String estado, String tecnologiaUsada)
    {
        super(identificador, nombreProyecto, encargado, personalRequerido, costo, ganancias, estado);
        this.tecnologiaUsada = tecnologiaUsada;
    }

    // Getter
    /**
     * Obtiene la tecnologia utilizada para llevar a cabo el proyecto.
     * @return Tecnologia utilizada para realizar el proyecto.
     */
    public String getTecnologiaUsada()
    {
        return tecnologiaUsada;
    }

    // Setter
    /**
     * Establece la tecnologia que se esta usando para realizar el proyecto.
     * @param tecnologiaUsada Tecnologia a utilizar en el proyecto.
     */
    public void setTecnologiaUsada(String tecnologiaUsada)
    {
        this.tecnologiaUsada = tecnologiaUsada;
    }

    // Metodos
    /**
     * Sobreescritura de metodo info, mostrando ahora la tecnologia con la que se realiza el proyecto.
     */
    public void info()
    {
        System.out.println("Identificador del proyecto: " + getIdentificador());
        System.out.println("Nombre del proyecto: " + getNombreProyecto());
        System.out.println("Encargado: " + getEncargado());
        System.out.println("Costo: " + getCosto());
        System.out.println("Personal: " + getPersonalRequerido());
        System.out.println("Estado: " + getEstado());
        System.out.println("Tecnología usada: " + tecnologiaUsada);
    }
}
