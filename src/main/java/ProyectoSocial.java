/**
 * Clase extendida de clase proyecto, representa un proyecto con fin social.
 */
public class ProyectoSocial extends Proyecto
{
    /**
     * Declaracion variables de la clase:
     * comunidadBeneficiada: Representa la comunidad que se beneficia del proyecto.
     */
    private String comunidadBeneficiada;

    // Constructor
    /**
     * Constructor encargado de inicializar un proyecto en estado "En curso" y con ganancias 0.
     * @param identificador Identificador unico del proyecto.
     * @param nombreProyecto Nombre del proyecto.
     * @param encargado Nombre del encargado del proyecto.
     * @param personalRequerido Numero de empleados requeridos para realizar el proyecto.
     * @param costo Costo estimado del proyecto.
     * @param comunidadBeneficiada Comunidad que se beneficia del proyecto.
     */
    public ProyectoSocial(int identificador, String nombreProyecto, String encargado, int personalRequerido, int costo, String comunidadBeneficiada)
    {
        super(identificador, nombreProyecto, encargado, personalRequerido, costo);
        this.comunidadBeneficiada = comunidadBeneficiada;
    }
    /**
     * Constructor encargado de inicializar un proyecto social con un estado y ganancias especifico.
     * @param identificador Identificador unico del proyecto.
     * @param nombreProyecto Nombre del proyecto.
     * @param encargado Nombre del encargado del proyecto.
     * @param personalRequerido Numero de empleados requeridos para realizar el proyecto.
     * @param costo Costo estimado del proyecto.
     * @param ganancias Ganancias del proyecto.
     * @param estado Estado actual del proyecto.
     * @param comunidadBeneficiada Comunidad que se beneficia del proyecto.
     */
    public ProyectoSocial(int identificador, String nombreProyecto, String encargado, int personalRequerido, int costo, int ganancias, String estado, String comunidadBeneficiada)
    {
        super(identificador, nombreProyecto, encargado, personalRequerido, costo, ganancias, estado);
        this.comunidadBeneficiada = comunidadBeneficiada;
    }

    // Getter
    /**
     * Obtiene la comunidad beneficiada por el proyecto.
     */
    public String getComunidadBeneficiada()
    {
        return comunidadBeneficiada;
    }

    // Setter
    /**
     * Establece la comunidad que se beneficia del proyecto.
     * @param comunidadBeneficiada Comunidad beneficiada por el proyecto.
     * */
    public void setComunidadBeneficiada(String comunidadBeneficiada)
    {
        this.comunidadBeneficiada = comunidadBeneficiada;
    }

    // Metodos
    /**
     * Sobreescritura de metodo info, mostrando ahora la comunidad que se beneficia del proyecto.
     */
    public void info()
    {
        System.out.println("Identificador del proyecto: " + getIdentificador());
        System.out.println("Nombre del proyecto: " + getNombreProyecto());
        System.out.println("Encargado: " + getEncargado());
        System.out.println("Costo: " + getCosto());
        System.out.println("Personal: " + getPersonalRequerido());
        System.out.println("Estado: " + getEstado());
        System.out.println("Comunidad beneficiada: " + comunidadBeneficiada);
    }
}
