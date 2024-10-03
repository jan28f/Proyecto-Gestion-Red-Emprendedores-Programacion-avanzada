/**
 * Clase encargada de representar los recursos y apoyos que tiene un emprendimiento
 */
public class RecursosApoyos
{
    /**
     * Declaracion de variables de la clase:
     * totalEmpleados: Numero total de empleados el emprendimiento.
     * capital: Representa el total del capital actual el emprendimiento.
     * capitalInicial: Representa el capital con el que inicio el emprendimiento.
     * montoApoyo: Representa el apoyo monetario que ha recibido el emprendimiento.
     */
    private int totalEmpleados;
    private int capital;
    private int capitalInicial;
    private int montoApoyo;

    // Constructores
    /**
     * Constructor encargado de inicializar los recursos y apoyos de un emprendimiento con su capital inicial igual al capital12
     * @param totalEmpleados totalEmpleados: Numero total de empleados.
     * @param capital capital: Capital actual del emprendimiento.
     * @param montoApoyo montoApoyo: Monto monetario de apoyo recibidos.
     */
    public RecursosApoyos(int totalEmpleados, int capital, int montoApoyo)
    {
        this.totalEmpleados = totalEmpleados;
        this.capital = capital;
        capitalInicial = capital;
        this.montoApoyo = montoApoyo;
    }
    /**
     * Constructor encargado de inicializar todos los atributos de recursos y apoyos
     * 
     * @param totalEmpleados totalEmpleados: Numero total de empleados.
     * @param capital capital: Capital actual del emprendimiento.
     * @param capitalInicial capitalInicial: Capital con el que se inicio el emprendimiento
     * @param montoApoyo montoApoyo: Monto monetario de apoyo recibidos.
     */
    public RecursosApoyos(int totalEmpleados, int capital, int capitalInicial, int montoApoyo)
    {
        this.totalEmpleados = totalEmpleados;
        this.capital = capital;
        this.capitalInicial = capitalInicial;
        this.montoApoyo = montoApoyo;
    }

    //Gettters
    /**
     * Obtiene el total de empleados del emprendimiento.
     * @return Total de empleados
     */
    public int getTotalEmpleados()
    {
        return totalEmpleados;
    }
    /**
     * Obtiene el capital actual del emprendimiento.
     * @return Capital actual del emprendimiento
     */
    public int getCapital()
    {
        return capital;
    }
    /**
     * Obtiene el capital con el que se inicio el emprendimiento.
     * @return Capital con el que inicio el emprendimiento.
     */
    public int getCapitalInicial()
    {
        return capitalInicial;
    }
    /**
     * Obtiene el total monetario recibido en apoyos al emprendimiento.
     * @return Monto de apoyos monetarios.
     */
    public int getMontoApoyo()
    {
        return montoApoyo;
    }

    //Setters
    /**Establece el total de empleados del emprendimiento, si es menor que 1, se asigna 1 por defecto.
     * @param totalEmpleados Numero del nuevo total de empleados del emprendimiento.
     */
    public void setTotalEmpleados(int totalEmpleados)
    {
        this.totalEmpleados = totalEmpleados;
        if (this.totalEmpleados < 1)
        {
            this.totalEmpleados = 1;
        }
    }
    /**
     * Establece el nuevo capital actual del emprendimiento.
     * @param capital Nuevo capital actual.
     */
    public void setCapital(int capital)
    {
        this.capital = capital;
    }
    /**
     * Establece el nuevo capital inicial del emprendimiento.
     * @param capitalInicial Nuevo capital inicial.
     */
    public void setCapitalInicial(int capitalInicial)
    {
        this.capitalInicial = capitalInicial;
    }
    /**
     * Establece el monto de apoyo monetario del emprendimiento.
     * @param montoApoyo Nuevo monto de apoyo monetario.
     */
    public void setMontoApoyo(int montoApoyo)
    {
        this.montoApoyo = montoApoyo;
    }
    
    // Metodos
    /**
     * Muestra la informacion detalla de los recursos y apoyos del emprendimiento.
     */
    public void info()
    {
        System.out.println("Empleados: " + totalEmpleados);
        System.out.println("Capital actual: " + capital);
        System.out.println("Apoyo monetario: " + montoApoyo);
    }
}