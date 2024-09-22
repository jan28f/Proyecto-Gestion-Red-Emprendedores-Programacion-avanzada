public class RecursosApoyos
{
    private int totalEmpleados;
    private int capital;
    private int capitalInicial;
    private int montoApoyo;

    // Constructor
    public RecursosApoyos(int totalEmpleados, int capital, int montoApoyo)
    {
        this.totalEmpleados = totalEmpleados;
        this.capital = capital;
        capitalInicial = capital;
        this.montoApoyo = montoApoyo;
    }
    public RecursosApoyos(int totalEmpleados, int capital, int capitalInicial, int montoApoyo)
    {
        this.totalEmpleados = totalEmpleados;
        this.capital = capital;
        this.capitalInicial = capitalInicial;
        this.montoApoyo = montoApoyo;
    }

    //Gettters
    public int getTotalEmpleados()
    {
        return totalEmpleados;
    }
    public int getCapital()
    {
        return capital;
    }
    public int getCapitalInicial()
    {
        return capitalInicial;
    }
    public int getMontoApoyo()
    {
        return montoApoyo;
    }

    //Setters
    public void setTotalEmpleados(int totalEmpleados)
    {
        this.totalEmpleados = totalEmpleados;
        if (this.totalEmpleados < 1)
        {
            this.totalEmpleados = 1;
        }
    }
    public void setCapital(int capital)
    {
        this.capital = capital;
    }
    public void setCapitalInicial(int capitalInicial)
    {
        this.capitalInicial = capitalInicial;
    }
    public void setMontoApoyo(int montoApoyo)
    {
        this.montoApoyo = montoApoyo;
    }
    
    // Metodos
    public void info()
    {
        System.out.println("Empleados: " + totalEmpleados);
        System.out.println("Capital actual: " + capital);
        System.out.println("Apoyo monetario: " + montoApoyo);
    }
}