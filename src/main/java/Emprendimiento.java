import java.util.ArrayList;

/**
 * Clase encargada de representar un emprendimiento, con sus proyectos y recursos.
 */
public class Emprendimiento
{
    /**
     * Declaracion de variables de la clase:
     * nombre: Nombre del emprendimiento.
     * propietario: Nombre del propietario del emprendimiento.
     * area: Area de trabajo del emprendimiento.
     * recursosApoyos: Recursps y apoyos del emprendimiento.
     * proyectos: Lista de proyectos del emprendimiento.
     * crecimiento: Porcentaje de crecimiento del emprendimiento.
     */
    private String nombre;
    private String propietario;
    private String area;
    private RecursosApoyos recursosApoyo;
    private ArrayList <Proyecto> proyectos;
    private float crecimiento;
    
    // Constructor
    /**
     * Constructor encargado de inicializar un emprendimiento con informacion basica.
     * @param nombre Nombre del emprendimiento.
     * @param propietario Nombre del propietario del emprendimiento.
     * @param area Area de trabajo del emprendimiento.
     */
    public Emprendimiento(String nombre, String propietario , String area)
    {
        this.nombre = nombre;
        this.propietario = propietario;
        this.area = area;
        this.recursosApoyo = new RecursosApoyos(1,0,0);
        proyectos = new ArrayList<Proyecto>();
    }
    /**
     * Constructor encargado de inicializar el emprendimiento con recursos y apoyos especificos.
     * @param nombre Nombre del emprendimiento.
     * @param propietario Nombre del propietario del emprendimiento.
     * @param area Area de trabajo del emprendimiento.
     * @param empleados Numero total de empleados del emprendimiento.
     * @param capital Capital del emprendimiento.
     * @param montoApoyo Monto monetario total de apoyos recibidos por el emprendimiento.
     */
    public Emprendimiento(String nombre, String propietario, String area, int empleados, int capital, int montoApoyo)
    {
        this.nombre = nombre;
        this.propietario = propietario;
        proyectos = new ArrayList<Proyecto>();
        this.recursosApoyo = new RecursosApoyos(empleados, capital, montoApoyo);
        this.area = area;
        crecimiento = 0.0f;
    }
    /**
     * Constructor encargado de inicializar un emprendimiento con sus recursos y capital inicial especifico.
     * @param nombre Nombre del emprendimiento.
     * @param propietario Nombre del propietario del emprendimiento.
     * @param area Area de trabajo del emprendimiento.
     * @param empleados Numero total de empleados del emprendimiento.
     * @param capital Capital del emprendimiento.
     * @param capitalInicial Capital inicial del emprendimiento.
     * @param montoApoyo Monto monetario total de apoyos recibidos por el emprendimiento.
     */
    public Emprendimiento(String nombre, String propietario, String area, int empleados, int capital, int capitalInicial, int montoApoyo)
    {
        this.nombre = nombre;
        this.propietario = propietario;
        proyectos = new ArrayList<Proyecto>();
        this.recursosApoyo = new RecursosApoyos(empleados, capital, capitalInicial, montoApoyo);
        this.area = area;
        crecimiento = 0.0f;
    }

    //Getters
    /**
     * Obtiene el nombre del emprendimiento.
     * @return Nombre del emprendimiento.
     */
    public String getNombre()
    {
        return nombre;
    }
    /**
     * Obtiene el nombre del propietario del emprendimiento.
     * @return Nombre del propietario del emprendimiento.
     */
    public String getPropietario()
    {
        return propietario;
    }
    /**
     * Obtiene el area de trabajo del emprendimiento.
     * @return Area de trabajo del emprendimiento.
     */
    public String getArea()
    {
        return area;
    }
    /**
     * Obtiene el total de empleados del emprendimiento.
     * @return Total de empleados del emprendimiento.
     */
    public int getTotalEmpleados()
    {
        return recursosApoyo.getTotalEmpleados();
    }
    /**
     * Obtiene el capital actual del emprendimiento.
     * @return Capital actual del emprendimiento.
     */
    public int getCapital()
    {
        return recursosApoyo.getCapital();
    }
    /**
     * Obtiene el capital inicial del emprendimiento.
     * @return Capital inicial del emprendimiento.
     */
    public int getCapitalInicial()
    {
        return recursosApoyo.getCapitalInicial();
    }
    /**
     * Obtiene el monoto total del apoyo monetario recibido por el emprendimiento.
     * @return Monto monetario total de apoyos recibidos por el emprendimiento.
     */
    public int getMontoApoyo()
    {
        return recursosApoyo.getMontoApoyo();
    }
    /**
     * Obtiene el porcentaje de crecimiento del emprendimiento.
     * @return Porcentaje de crecimiento del emprendimiento.
     */
    public float getCrecimiento()
    {
        return crecimiento;
    }
    
    //Setter
    /**
     * Establece el nuevo nombre del emprendimiento.
     * @param nombre Nuevo nombre del emprendimiento.
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    /**
     * Estable el nuevo propietario del emprendimiento.
     * @param propietario Nombre del nuevo propietario del emprendimiento.
     */
    public void setPropietario(String propietario)
    {
        this.propietario = propietario;
    }
    /**
     * Establece la nueva area de trabajo del emprendimiento.
     * @param area Nueva area de trabajo.
     */
    public void setArea(String area)
    {
        this.area = area;
    }
    /**
     * Establece el nuevo total de empleados del emprendimiento.
     * @param totalEmpleados Nuevo total de empleados del emprendimiento.
     */
    public void setTotalEmpleados(int totalEmpleados)
    {
        recursosApoyo.setTotalEmpleados(totalEmpleados);
    }
    /**
     * Establece el nuevo monto del capital actual del emprendimiento.
     * @param capital Nuevo monto del capital del emprendimiento.
     */
    public void setCapital(int capital)
    {
        recursosApoyo.setCapital(capital);
    }
    /**
     * Establece el nuevo monto del capital inicial del emprendimiento.
     * @param capitalInicial Nuevo monto del capital inicial del emprendimiento.
     */
    public void setCapitalInicial(int capitalInicial)
    {
        recursosApoyo.setCapitalInicial(capitalInicial);
    }
    /**
     * Establece el nuevo monto del apoyo monetario recibido por el emprendimiento.
     * @param montoApoyo Nuevo monto del apoyo monetario recibido por el emprendimiento.
     */
    public void setMontoApoyo(int montoApoyo)
    {
        recursosApoyo.setMontoApoyo(montoApoyo);
    }
    /**
     * Establece el nuevo porcentaje de crecimiento del emprendimiento.
     * @param crecimiento Nuevo porcentaje de crecimiento del emprendimiento.
     */
    public void setCrecimiento(float crecimiento)
    {
        this.crecimiento = crecimiento;
    }

    // Metodos
    /**
     * Busca un proyecto por su identificador.
     * @param aBuscar Numero de identificacion del proyecto a buscar.
     * @return Retorna el proyecto si lo encuentra, en caso contrario retorna null si no lo encuentra.
     */
    public Proyecto conseguirProyecto(int aBuscar)
    {
        for (Proyecto proyecto : proyectos)
        {
            if (proyecto.getIdentificador() == aBuscar)
            {
                return proyecto;
            }
        }
        return null;
    }
    /**
     * Busca un proyecto por su nombre.
     * @param aBuscar Nombre del proyecto a buscar.
     * @return Retorna el proyecto si lo encuentra, en caso contrario retorna null si no lo encuentra.
     */
    public Proyecto conseguirProyecto(String aBuscar)
    {
        for (Proyecto proyecto : proyectos)
        {
            if (proyecto.getNombreProyecto().equals(aBuscar))
            {
                return proyecto;
            }
        }
        return null;
    }
    /**
     * Inserta un nuevo proyecto sin especificar ganancias ni estado.
     * @param identificador Identificador del proyecto.
     * @param nombre Nombre del proyecto.
     * @param encargado Nombre del encargado del proyecto.
     * @param personalRequerido Total de personal que requiere el proyecto.
     * @param costo Costo estimado del proyecto.
     * @return Retorna true si se inserto el proyecto exitosamente, false en caso contrario.
     */
    public boolean insertarProyecto(int identificador, String nombre, String encargado, int personalRequerido, int costo)
    {
        if (conseguirProyecto(identificador) == null)
        {
            Proyecto proyecto = new Proyecto(identificador, nombre, encargado, personalRequerido, costo);
            proyectos.add(proyecto);
            return true;
        }
        System.out.println("Ya existe un proyecto con el identificador " + identificador);
        return false;
    }
    /**
     * Inserta un proyecto especificando su estado.
     * @param identificador Identificador del proyecto.
     * @param nombre Nombre del proyecto.
     * @param encargado Nombre del encargado del proyecto.
     * @param personalRequerido Total de personal que requiere el proyecto.
     * @param costo Costo estimado del proyecto.
     * @param estado Estado actual del proyecto.
     * @return Retorna true si se inserto el proyecto exitosamente, false en caso contrario.
     */
    public boolean insertarProyecto(int identificador, String nombre, String encargado, int personalRequerido, int costo, String estado)
    {
        if (conseguirProyecto(identificador) == null)
        {
            Proyecto proyecto = new Proyecto(identificador, nombre, encargado, personalRequerido, costo, estado);
            proyectos.add(proyecto);
            return true;
        }
        System.out.println("Ya existe un proyecto con el identificador " + identificador);
        return false;
    }
    /**
     * Inserta un proyecto especificando su estado y ganancias.
     * @param identificador Identificador del proyecto.
     * @param nombre Nombre del proyecto.
     * @param encargado Nombre del encargado del proyecto.
     * @param personalRequerido Total de personal que requiere el proyecto.
     * @param costo Costo estimado del proyecto.
     * @param ganancias Ganancias del proyecto.
     * @param estado Estado actual del proyecto.
     * @return Retorna true si se inserto el proyecto exitosamente, false en caso contrario.
     */
    public boolean insertarProyecto(int identificador, String nombre, String encargado, int personalRequerido, int costo, int ganancias, String estado)
    {
        if (conseguirProyecto(identificador) == null)
        {
            Proyecto proyecto = new Proyecto(identificador, nombre, encargado, personalRequerido, costo, ganancias, estado);
            proyectos.add(proyecto);
            return true;
        }
        System.out.println("Ya existe un proyecto con el identificador " + identificador);
        return false;
    }
    /**
     * Se elimina un proyecto por su identificador
     * @param aEliminar Identificador del proyecto a eliminar.
     * @return Retorna true si se elimino el proyecto, retorna false en caso contrario.
     */
    public boolean eliminarProyecto(int aEliminar)
    {
        Proyecto proyecto = conseguirProyecto(aEliminar);
        if (proyecto != null)
        {
            System.out.println("Se ha eliminado el proyecto con el identificador " + aEliminar);
            proyectos.remove(proyecto);
            return true;
        }
        System.out.println("No se ha encontrado algun proyecto con el identificador " + aEliminar);
        return false;
    }
    /**
     * Se elimina un proyecto por su nombre.
     * @param aEliminar Nombre del proyecto a eliminar.
     * @return Retorna true si se elimino el proyecto, retorna false en caso contrario.
     */
    public boolean eliminarProyecto(String aEliminar)
    {
        Proyecto proyecto = conseguirProyecto(aEliminar);
        if (proyecto != null)
        {
            System.out.println("Se ha eliminado el proyecto con el nombre " + aEliminar);
            proyectos.remove(proyecto);
            return true;
        }
        System.out.println("No se ha encontrado algun proyecto con el nombre " + aEliminar);
        return false;
    }
    /**
     * Muestra todos los proyectos registrados en el emprendimiento.
     */
    public void verProyectos()
    {
        if (proyectos.size() == 0)
        {
            System.out.println("No se han registrado proyectos");
        }
        else
        {
            int cont = 0;
            for (Proyecto proyecto : proyectos)
            {
                System.out.println("Proyecto " + cont);
                System.out.println("==========================");
                proyecto.info();
                System.out.println("");
                cont++;
            }
        }
    }
    /**
     * Calcula el crecimiento del emprendimiento, usando las ganancias de los proyectos.
     * Manejo de excepcion si el capital inicial es 0.
     */
    public void calcularCrecimiento()
    {
        float totalGanancias = 0;
        for (Proyecto proyecto : proyectos)
        {
            totalGanancias += proyecto.getGanancias();
        }

        try
        {
            if (recursosApoyo.getCapitalInicial() == 0)
            {
                throw new ArithmeticException("El capital inicial es cero, no se puede calcular el crecimiento.");
            }
            float crecimiento = (totalGanancias / recursosApoyo.getCapitalInicial()) * 100;
            setCrecimiento(crecimiento);
        }
        catch (ArithmeticException e)
        {
            System.out.println(e.getMessage());
            setCrecimiento(0);
        }
    }
    /**
     * Muestra la informacion detallada del emprendimiento.
     */
    public void info()
    {
        calcularCrecimiento();
        System.out.println("Nombre emprendimiento: " + nombre);
        System.out.println("Propietario: " + propietario);
        System.out.println("Area de trabajo del emprendimiento: " + area);
        recursosApoyo.info();
        System.out.println("Crecimiento: " + crecimiento + "%");
    }
    /**
     * Muestra un resumenen de los resultados y estados de los proyectos del emprendimento.
     */
    public void resultados()
    {
        int totalGanancias = 0;
        int proyectosCompletos = 0;
        int proyectosActivos = 0;
        int proyectosCancelados = 0;

        for (Proyecto proyecto : proyectos)
        {
            totalGanancias += proyecto.getGanancias();
            if (proyecto.getEstado().equals("Completado"))
            {
                proyectosCompletos++;
            }
            else if (proyecto.getEstado().equals("En curso"))
            {
                proyectosActivos++;
            }
            else
            {
                proyectosCancelados++;
            }
        }

        System.out.println("Resumen de estado de proyectos");
        System.out.println("==============================\n");
        System.out.println("Total proyectos: " + proyectos.size());
        System.out.println("Proyectos completados: " + proyectosCompletos);
        System.out.println("Proyectos cancelados: " + proyectosCancelados);
        System.out.println("Proyectos en curso: "  + proyectosActivos);
        System.out.println("Total ganancias: " + totalGanancias);
    }
    /**
     * Obtiene una cadena con los identificadores de los proyectos del emprendimiento.
     * @return Una cadena con los identificadores de los proyectos separados por ",".
     */
    public String conseguirIdProyectos()
    {
        String identificadores = "";
        for (Proyecto proyecto : proyectos)
        {
            if (!identificadores.isEmpty())
            {
                identificadores += ",";
            }
            identificadores += String.valueOf(proyecto.getIdentificador());
        }

        return identificadores;
    }
}