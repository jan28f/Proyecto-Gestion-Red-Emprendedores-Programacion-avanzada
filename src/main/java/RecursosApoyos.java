public class RecursosApoyos
  {
    private int totalEmpleados;
    private int capital;
    private int montoApoyo;
    public RecursosApoyos(int totalEmpleados,int capital, int montoApoyo)
      {
        this.totalEmpleados = totalEmpleados;
        this.capital = capital;
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

    public void setMontoApoyo(int montoApoyo)
      {
        this.montoApoyo = montoApoyo;
      }
    public void setCapital(int capital)
    {
      this.capital = capital;
    }
  }  