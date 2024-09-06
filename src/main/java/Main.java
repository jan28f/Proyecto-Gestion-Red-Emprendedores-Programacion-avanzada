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
      System.out.println("1) Registrar emprendimiento");
      System.out.println("2) Buscar emprendimiento");
      System.out.println("3) Eliminar emprendimiento");
      System.out.println("4) Cargar datos de prueba");
      System.out.println("5) Salir del programa\n");
      System.out.print("Ingrese una opcion: ");

      String numero = lector.readLine();
      opcion = Integer.parseInt(numero);
      switch(opcion)
      {
        case 1:
          System.out.print("Ingresa el nombre del emprendimiento: ");
          String nombre = lector.readLine();
          System.out.print("Ingresa el nombre del propietario del emprendimiento: ");
          String propietario = lector.readLine();
          System.out.print("Ingresa el area a la que se dedica el emprendimiento: ");
          String area = lector.readLine();
          System.out.print("Ingrese cuantos empleados tiene el emprendimiento: ");
          int empleados = Integer.parseInt(lector.readLine());
          System.out.print("Ingrese el capital inicial del emprendimiento: ");
          int capital = Integer.parseInt(lector.readLine());
          System.out.print("Ingrese el monto de los apoyos que tiene el emprendimiento: ");
          int montoApoyo = Integer.parseInt(lector.readLine());

          RecursosApoyos recursosYApoyos = new RecursosApoyos(empleados, capital, montoApoyo);
          Emprendimiento nuevoEmprendimiento = new Emprendimiento(nombre, propietario, area, recursosYApoyos);
          if (mapa.get(nombre) == null)
          {
            mapa.put(nombre, nuevoEmprendimiento);
            System.out.println("Se agrego el emprendimiento " + nombre + "al registro");
          }
          else
          {
            System.out.println("\nYa existe un emprendimiento con el nombre registro " + nombre);
          }
          break;
        case 2:
          System.out.print("Ingresa el nombre del emprendimiento a buscar: ");
          String aBuscar = lector.readLine();

          Emprendimiento emprendimiento = mapa.get(aBuscar);
          if (emprendimiento != null)
          {
            menuEmprendimiento(emprendimiento);
          }
          else
          {
            System.out.println("No se ha encontrado ningun emprendimiento registrado con el nombre de " + aBuscar);
          }
          break;
        case 3:
          System.out.print("Ingrese el nombre del emprendimiento a eliminar: ");
          String aEliminar = lector.readLine();

          if (mapa.remove(aEliminar) != null)
          {
            System.out.print("Se ha eliminado " + aEliminar + "del registro de emprendedores");
          }
          else
          {
            System.out.print("No se ha encontrado " + aEliminar + "en el registro de emprendedores para eliminarlo");
          }
          break;
        case 4:
          emprendedor1 = new Emprendimiento("Juan    Perez","Samsung","Telefonia Movil");
          proyecto1 = new Proyecto("Nuevo Samsung","Xi ping",20,20000,"Activo");
          emprendedor1.insertarProyecto(proyecto1);
          emprendedor2 = new Emprendimiento("Jose Mena","Entel","Movil");
          proyecto2 = new Proyecto("Arreglar internet","Franny",21,30000,"Activo");
          registrarMapa("Juan Perez",emprendedor1);
          registrarMapa("Jose Mena",emprendedor2);
          break;
        case 5:
          System.out.print("Saliendo del programa...");
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

  public void menuEmprendimiento(Emprendimiento emprendimiento) throws IOException
  {
    BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
    int opcion = -1;
    do
    {  
      System.out.println("============================");
      System.out.println("    Menu emprendimiento");
      System.out.println("============================");
      emprendimiento.info();
      System.out.println("\n1) Cambiar propietario");
      System.out.println("2) Cambiar area de emprendimiento");
      System.out.println("3) Modificar total de empleados");
      System.out.println("4) Modificar capital");
      System.out.println("5) Modificar total apoyo");
      System.out.println("6) Ver proyectos");
      System.out.println("7) Buscar proyecto");
      System.out.println("8) Volver menu principal\n");
      System.out.print("Ingrese una opcion: ");

      opcion = Integer.parseInt(lector.readLine());
      switch (opcion)
      {
        case 1:
          break;
        case 2:
          break;
        case 3:
          break;
        case 4:
          break;
        case 5:
          break;
        case 6:
          break;
        case 7:
          break;
        case 8:
          break;
        default:
          break;
      }
    } while (opcion != 8);
  }
}