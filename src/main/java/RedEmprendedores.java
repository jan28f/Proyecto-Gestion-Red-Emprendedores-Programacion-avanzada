import java.util.HashMap;

/**
 * Clase encargada de representar una red de emprendimientos, en la cual se puede registrar, eliminar y acceder a emprendimientos.
 */
public class RedEmprendedores
{
    /**
     * Declaracion de variables de la clase:
     * emprendimientos: Mapa para almacenar los emprendimientos registrados, usando de clave el nombre del emprendimiento.
     */
    private HashMap<String, Emprendimiento> emprendimientos;
    
    // Constructor
    /**
     * Constructor que inicializa una red de emprendimientos.
     */
    public RedEmprendedores()
    {
        emprendimientos = new HashMap<String, Emprendimiento>();
    }

    // Metodos emprendimientos
    /**
     * Se registra un nuevo emprendimiento con la informacion proporcionada.
     * @param nombre Nombre del emprendimiento.
     * @param propietario Nombre del propietario del emprendimiento.
     * @param area Area a la que se dedica el emprendimiento.
     * @param empleados Numero del total de empleados del emprendimiento.
     * @param capital Capital del emprendimiento.
     * @param montoApoyo Monto monetario de los apoyos recibidos por el emprendimiento.
     * @return Retorna true si se registro exitosamente el emprendimiento, false en caso contrario.
     */
    public boolean registrarEmprendimiento(String nombre, String propietario, String area, int empleados, int capital, int montoApoyo)
    {
        if (emprendimientos.containsKey(nombre))
        {
            System.out.println(nombre + " ya se encuentra registrado");
            return false;
        }
        Emprendimiento emprendimiento = new Emprendimiento(nombre, propietario, area, empleados, capital, montoApoyo);
        emprendimientos.put(nombre, emprendimiento);
        if (!emprendimientos.containsKey(nombre))
        {
            System.out.println("No se ha podido registrar " + nombre);
            return false;
        }
        System.out.println("Se ha registrado " + nombre);
        return true;
    }
    /**
     * Se registra un emprendimiento con la informacion proporcionada y con un capital inicial especificado.
     * @param nombre Nombre del emprendimiento.
     * @param propietario Nombre del propietario del emprendimiento.
     * @param area Area a la que se dedica el emprendimiento.
     * @param empleados Numero del total de empleados del emprendimiento.
     * @param capital Capital del emprendimiento.
     * @param capitalInicial Capital inicial del emprendimiento.
     * @param montoApoyo Monto monetario de los apoyos recibidos por el emprendimiento.
     * @return Retorna true si se registro exitosamente el emprendimiento, false en caso contrario.
     */
    public boolean registrarEmprendimiento(String nombre, String propietario, String area, int empleados, int capital, int capitalInicial, int montoApoyo)
    {
        if (emprendimientos.containsKey(nombre))
        {
            System.out.println(nombre + " ya se encuentra registrado");
            return false;
        }
        Emprendimiento emprendimiento = new Emprendimiento(nombre, propietario, area, empleados, capital, capitalInicial, montoApoyo);
        emprendimientos.put(nombre, emprendimiento);
        if (!emprendimientos.containsKey(nombre))
        {
            System.out.println("No se ha podido registrar " + nombre);
            return false;
        }
        System.out.println("Se ha registrado el emprendimiento" + nombre);
        return true;
    }
    /**
     * Obtiene un emprendimiento registrado por su nombre.
     * @param aBuscar Nombre del emprendimiento a buscar.
     * @return Retorna el emprendimiento encontrado si esta, en caso contrario retorna null si no se encuentra registrado.
     * @throws EmprendimientoNoEncontradoException Si no se encuentra el emprendimiento.
     */
    public Emprendimiento obtenerEmprendimiento(String aBuscar) throws EmprendimientoNoEncontradoException
    {
        Emprendimiento emprendimiento = emprendimientos.get(aBuscar);
        if (emprendimiento == null)
        {
            throw new EmprendimientoNoEncontradoException("No se ha encontrado " + aBuscar + " en el registro");
        }

        return emprendimiento;
    }
    /**
     * Elimina un emprendimiento registrado por su nombre.
     * @param aEliminar Nombre del emprendimiento a eliminar.
     * @return Retorna true si se elimino el emprendimiento, en caso contrario retorna false si no se pudo eliminar.
     */
    public boolean eliminarEmprendimiento(String aEliminar)
    {
        if (emprendimientos.remove(aEliminar) == null)
        {
            System.out.println("No se ha encontrado " + aEliminar + " en el registro");
            return false;
        }
        System.out.println("Se ha eliminado " + aEliminar + " del registro");
        return true;
    }
    /**
     * Obtiene una cadena con el nombre de todos los emprendimientos registrados.
     * @return Una cadena con el nombre de todos los emprendimientos registrados separados por una ",".
     */
    public String conseguirClaves()
    {
        return String.join(",", emprendimientos.keySet());
    }
}