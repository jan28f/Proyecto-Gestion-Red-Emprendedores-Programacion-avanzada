import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
  HashMap <String,Emprendimiento> mapa;
  public Main()
  {
    this.mapa = new HashMap<>();
  }
  public static void main(String [] args) throws IOException
  {
    
    Main app = new Main();
    app.menuPrincipal();
  }

  public void menuPrincipal() throws IOException
  {
    Emprendimiento emprendedor1;
    Proyecto proyecto1;
    Emprendimiento emprendedor2;
    Proyecto proyecto2;
    Emprendimiento emprendedor3;
    Proyecto proyecto3;

    BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
    int opcion = -1;
    do
    {
      
      System.out.println("============================");
      System.out.println("       Menu Principal");
      System.out.println("============================");
      System.out.println("1) Registrar emprendimiento y proyectos");
      System.out.println("3) Buscar emprendimiento");
      System.out.println("2) Buscar proyecto");;
      System.out.println("5) Salir del programa\n");
      System.out.print("Ingrese una opcion: ");

      String numero = lector.readLine();
      opcion = Integer.parseInt(numero);
      switch(opcion)
      {
        case 1:
          emprendedor1 = new Emprendimiento("Juan    Perez","Samsung","Telefonia Movil");
          proyecto1 = new Proyecto("Nuevo Samsung","Xi ping",20,20000,"Activo");
          emprendedor1.insertarProyecto(proyecto1);
          emprendedor2 = new Emprendimiento("Jose Mena","Entel","Movil");
          proyecto2 = new Proyecto("Arreglar internet","Franny",21,30000,"Activo");
          registrarMapa("Juan Perez",emprendedor1);
          registrarMapa("Jose Mena",emprendedor2);
          

          break;
        case 2:
          
          
          break;
        case 3:
          System.out.println(buscarPorNombre("Jose Mena"));   
          break;
        case 4:
          break;
        case 5:
          
          break;
        
        default:
          break;
        }
      System.out.print("Presiona Enter para continuar...");
      lector.readLine();    
      } while (opcion != 5);
    lector.close();
  }
  public void registrarMapa(String clave, Emprendimiento aux)
    {
      if (!mapa.containsKey(clave))
      {
        mapa.put(clave,aux);
      }
      else
      {
        System.out.println("Ya se encuentra en el mapa");
      }
    }
  public String buscarPorNombre( String name)
    {
      if (mapa.containsKey(name))
      {
        Emprendimiento aux = mapa.get(name);
        return "Nombre: " + aux.getNombre() + ", Propietario: " + aux.getPropietario();
      }
      else
      {
        return "No se encontro el nombre del emprendimiento";
      }  
    }

}
