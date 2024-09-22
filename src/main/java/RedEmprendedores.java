import java.util.HashMap;

public class RedEmprendedores
{
    private HashMap<String, Emprendimiento> emprendimientos;
    
    // Constructor
    public RedEmprendedores()
    {
        emprendimientos = new HashMap<String, Emprendimiento>();
    }

    // Metodos emprendimientos
    public boolean registrarEmprendimiento(String nombre, String propietario, String area, int empleados, int capital, int montoApoyo)
    {
        if (emprendimientos.get(nombre) != null)
        {
            System.out.println(nombre + " ya se encuentra registrado");
            return false;
        }
        Emprendimiento emprendimiento = new Emprendimiento(nombre, propietario, area, empleados, capital, montoApoyo);
        emprendimientos.put(nombre, emprendimiento);
        if (emprendimientos.get(nombre) != null)
        {
            System.out.println("No se ha podido registrar " + nombre);
            return false;
        }
        System.out.println("Se ha registrado " + nombre);
        return true;
    }
    public boolean registrarEmprendimiento(String nombre, String propietario, String area, int empleados, int capital, int capitalInicial, int montoApoyo)
    {
        if (emprendimientos.get(nombre) != null)
        {
            System.out.println(nombre + " ya se encuentra registrado");
            return false;
        }
        Emprendimiento emprendimiento = new Emprendimiento(nombre, propietario, area, empleados, capital, capitalInicial, montoApoyo);
        emprendimientos.put(nombre, emprendimiento);
        if (emprendimientos.get(nombre) != null)
        {
            System.out.println("No se ha podido registrar " + nombre);
            return false;
        }
        System.out.println("Se ha registrado " + nombre);
        return true;
    }
    public Emprendimiento obtenerEmprendimiento(String aBuscar)
    {
        Emprendimiento emprendimiento = emprendimientos.get(aBuscar);
        if (emprendimiento == null)
        {
            System.out.println("No se ha encontrado " + aBuscar + "en el registro");
            return null;
        }

        return emprendimiento;
    }
    public boolean eliminarEmprendimiento(String aEliminar)
    {
        if (emprendimientos.remove(aEliminar) == null)
        {
            System.out.println("No se ha encontrado " + aEliminar + "en el registro");
            return false;
        }
        System.out.println("Se ha eliminado " + aEliminar + " del registro");
        return true;
    }
    public String conseguirClaves()
    {
        return String.join(",", emprendimientos.keySet());
    }
}