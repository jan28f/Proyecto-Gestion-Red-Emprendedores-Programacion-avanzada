import java.util.ArrayList;

public class Emprendimiento
{
    private String nombre;
    private String propietario;
    private String area;
    private RecursosApoyos recursosApoyo;
    private ArrayList <Proyecto> proyectos;
    private float crecimiento;
    
    // Constructor
    public Emprendimiento(String nombre, String propietario , String area)
    {
        this.nombre = nombre;
        this.propietario = propietario;
        this.area = area;
        this.recursosApoyo = new RecursosApoyos(1,0,0);
        proyectos = new ArrayList<Proyecto>();
    }
    public Emprendimiento(String nombre, String propietario, String area, int empleados, int capital, int montoApoyo)
    {
        this.nombre = nombre;
        this.propietario = propietario;
        proyectos = new ArrayList<Proyecto>();
        this.recursosApoyo = new RecursosApoyos(empleados, capital, montoApoyo);
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
    public float getCrecimiento()
    {
        return crecimiento;
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
    public void setTotalEmpleados(int totalEmpleados)
    {
        recursosApoyo.setTotalEmpleados(totalEmpleados);
    }
    public void setCapital(int capital)
    {
        recursosApoyo.setCapital(capital);
    }
    public void setCapitalInicial(int capitalInicial)
    {
        recursosApoyo.setCapitalInicial(capitalInicial);
    }
    public void setMontoApoyo(int montoApoyo)
    {
        recursosApoyo.setMontoApoyo(montoApoyo);
    }
    public void setCrecimiento(float crecimiento)
    {
        this.crecimiento = crecimiento;
    }

    // Metodos
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
    public boolean insertarProyecto(int identificador, String nombre, String encargado, int personalRequerido, int costo)
    {
        if (conseguirProyecto(identificador) != null)
        {
            Proyecto proyecto = new Proyecto(identificador, nombre, encargado, personalRequerido, costo);
            proyectos.add(proyecto);
            return true;
        }
        System.out.println("Ya existe un proyecto con el identificador " + identificador);
        return false;
    }
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
                System.out.println("\n");
                cont++;
            }
        }
    }
    public void calcularCrecimiento()
    {
        float totalGanancias = 0;
        for (Proyecto proyecto : proyectos)
        {
            totalGanancias += proyecto.getGanancias();
        }

        float crecimiento = (totalGanancias / recursosApoyo.getCapitalInicial()) * 100;
        setCrecimiento(crecimiento);
    }
    public void info()
    {
        calcularCrecimiento();
        System.out.println("Nombre emprendimiento: " + nombre);
        System.out.println("Propietario: " + propietario);
        System.out.println("Area de trabajo del emprendimiento: " + area);
        recursosApoyo.info();
        System.out.println("Crecimiento: " + crecimiento + "%");
    }
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
}