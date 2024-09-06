import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
  public HashMap <String, Emprendimiento> mapa;
  public BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

  public Main()
  {
    this.mapa = new HashMap<String, Emprendimiento>();
  }
  public static void main(String [] args) throws IOException
  {
    
    Main app = new Main();
    app.menuPrincipal();
  }

  public void menuPrincipal() throws IOException
  {
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
          registrarEmprendimiento(mapa);
          break;
        case 2:
          buscarEmprendimiento(mapa);
          break;
        case 3:
          eliminarEmprendimiento(mapa);
          break;
        case 4:
          cargarCasosPrueba(mapa);
          break;
        case 5:
          System.out.println("Saliendo del programa...");
          break;
        default:
          break;
        }
      System.out.print("Presiona Enter para continuar...");
      lector.readLine();
      } while (opcion != 5);
    lector.close();
  }
  public void registrarEmprendimiento(HashMap<String, Emprendimiento> mapa) throws IOException
  {
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
      System.out.println("Se agrego el emprendimiento " + nombre + " al registro");
    }
    else
    {
      System.out.println("\nYa existe un emprendimiento con el nombre registro " + nombre);
    }
  }
  public void buscarEmprendimiento(HashMap<String, Emprendimiento> mapa) throws IOException
  {
    System.out.print("Ingresa el nombre del emprendimiento a buscar: ");
    String aBuscar = lector.readLine();

    Emprendimiento emprendimiento = mapa.get(aBuscar);
    if (emprendimiento != null)
    {
      System.out.println("Se ha encontrado un emprendimiento\n");
      menuEmprendimiento(emprendimiento);
    }
    else
    {
      System.out.println("No se ha encontrado ningun emprendimiento registrado con el nombre de " + aBuscar);
    }
  }
  public void eliminarEmprendimiento(HashMap<String, Emprendimiento> mapa) throws IOException
  {
    System.out.print("Ingrese el nombre del emprendimiento a eliminar: ");
    String aEliminar = lector.readLine();

    if (mapa.remove(aEliminar) != null)
    {
      System.out.println("Se ha eliminado " + aEliminar + " del registro de emprendedores");
    }
    else
    {
      System.out.println("No se ha encontrado " + aEliminar + " en el registro de emprendedores para eliminarlo");
    }
  }
  public void cargarCasosPrueba(HashMap<String, Emprendimiento> mapa) throws IOException
  {
    Emprendimiento emprendedor1;
    Proyecto proyecto1;
    Emprendimiento emprendedor2;
    Proyecto proyecto2;
    Emprendimiento emprendedor3;
    Proyecto proyecto3;
    emprendedor1 = new Emprendimiento("Samsung","Juan Perez","");
    proyecto1 = new Proyecto("Nuevo celular","Xi ping",20,20000,"Activo");
    emprendedor1.insertarProyecto(proyecto1);
    emprendedor2 = new Emprendimiento("Entel","Jose Mena","Telecomunicaciones");
    proyecto2 = new Proyecto("Arreglar internet","Franny",21,30000,"Activo");
    mapa.put(emprendedor1.getNombre(),emprendedor1);
    System.out.println("Se ha registrado la empresa " + emprendedor1.getNombre());
    mapa.put(emprendedor2.getNombre(),emprendedor2);
    System.out.println("Se ha registrado la empresa " + emprendedor2.getNombre());

  }
  public void menuEmprendimiento(Emprendimiento emprendimiento) throws IOException
  {
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
          System.out.println("Indica el nuevo propietario");
          String nuevoPropietario = lector.readLine();
          emprendimiento.setPropietario(nuevoPropietario);
          System.out.println("Se ha cambiado con exito");
          break;
        case 2:
          System.out.println("Indica una nueva area de emprendimiento");
          String nuevaArea = lector.readLine();
          System.out.println("Se ha cambiado con exito");
          emprendimiento.setArea(nuevaArea);
          System.out.println("Se ha cambiado con exito");
          break;
        case 3:
          System.out.println("Indica una nueva cantidad de empleados");
          String numero1 = lector.readLine();
          int nuevoTotalEmpleados = Integer.parseInt(numero1);
          emprendimiento.setRecursosYapoyosEmpleados(nuevoTotalEmpleados);
          System.out.println("Se ha cambiado con exito");
          break;
        case 4:
          System.out.println("Indica una nueva Capital");
          String numero2 = lector.readLine();
          int nuevoCapital = Integer.parseInt(numero2);
          emprendimiento.setRecursosYapoyosCapital(nuevoCapital);
          System.out.println("Se ha cambiado con exito");
          break;
        case 5:
          System.out.println("Indica un nuevo total de apoyo");
          String numero3 = lector.readLine();
          int nuevoTotalApoyo = Integer.parseInt(numero3);
          emprendimiento.setRecursosYapoyosMonto(nuevoTotalApoyo);
          System.out.println("Se ha cambiado con exito");
          break;
        case 6:
          emprendimiento.verProyectos();
          break;
        case 7:
          System.out.print("Ingrese el nombre del proyecto a buscar: ");
          String aBuscar = lector.readLine();
          Proyecto proyecto = emprendimiento.getProyecto(aBuscar);
          if (proyecto == null)
          {
            System.out.println("No se ha encontrado el proyecto " + aBuscar);
          }
          else
          {
            menuProyecto(proyecto);
          }
          break;
        case 8:
          break;
        default:
          break;
      }
      System.out.print("Presiona Enter para continuar...");
      lector.readLine();
    } while (opcion != 8);
  }
  public void menuProyecto(Proyecto proyecto) throws IOException
  {
    int opcion = -1;
    do
    {  
      System.out.println("============================");
      System.out.println("        Menu proyecto");
      System.out.println("============================");
      proyecto.info();
      System.out.println("\n1) Cambiar nombre de proyecto");
      System.out.println("2) Cambiar encargado de proyecto");
      System.out.println("3) Modificar personal requerido");
      System.out.println("4) Modificar costo del proyecto");
      System.out.println("5) Modificar estado del proyecto");
      System.out.println("6) Volver menu emprendimiento\n");
      System.out.print("Ingrese una opcion: ");

      opcion = Integer.parseInt(lector.readLine());
      switch (opcion)
      {
        case 1:
          System.out.print("Ingrese el nuevo nombre del proyecto: ");
          String nuevoNombre = lector.readLine();

          proyecto.setNombreProyecto(nuevoNombre);
          System.out.println("\nSe ha cambiado el nombre del proyecto a " + nuevoNombre);
          break;
        case 2:
          System.out.print("Ingrese el nuevo encargado del proyecto: ");
          String nuevoEncargado = lector.readLine();

          proyecto.setEncargado(nuevoEncargado);
          System.out.println("\nSe ha cambiado el encargado del proyecto a " + nuevoEncargado);
          break;
        case 3:
          System.out.print("Ingrese la nueva cantidad de personal del proyecto: ");
          int nuevoPersonal = Integer.parseInt(lector.readLine());

          proyecto.setPersonalRequerido(nuevoPersonal);
          System.out.println("\nSe ha modificado la cantidad de personal en el proyecto");
          break;
        case 4:
          System.out.print("Ingrese el nuevo costo del proyecto: ");
          int nuevoCosto = Integer.parseInt(lector.readLine());

          proyecto.setCostoEstimado(nuevoCosto);
          System.out.println("\nSe ha modificado el costo del proyecto");
          break;
        case 5:
          System.out.print("Ingrese el estado actual del proyecto: ");
          String nuevoEstado = lector.readLine();

          proyecto.setEstadoActual(nuevoEstado);
          System.out.println("\nSe ha modificado el estado del proyecto a " + nuevoEstado);
          break;
        case 6:
          System.out.println("Volviendo al menu anterior...");
          break;
        default:
          break;
      }
      System.out.print("Presiona Enter para continuar...");
      lector.readLine();
    } while (opcion != 6);
  }
}