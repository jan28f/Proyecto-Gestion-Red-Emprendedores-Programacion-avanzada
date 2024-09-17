import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;

public class Menu
{
  private HashMap <String, Emprendimiento> mapa = new HashMap<String, Emprendimiento>();;
  private BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

  public void cargarCasosPrueba() throws IOException
  {
    String archivoEmprendimientos = "src/main/java/datos/empPrueba.csv";
    String archivoProyectos = "src/main/java/datos/proPrueba.csv";
    BufferedReader lectorArchivo = new BufferedReader(new FileReader(archivoEmprendimientos));
    String linea;

    System.out.println("Cargando emprendimientos...");
    while ((linea = lectorArchivo.readLine()) != null)
    {
      String[] info = linea.split(",");

      String nombre = info[0];
      String propietario = info[1];
      String area = info[2];
      int empleados = Integer.parseInt(info[3]);
      int capital = Integer.parseInt(info[4]);
      int ganancias = Integer.parseInt(info[5]);

      RecursosApoyos recursosYApoyos = new RecursosApoyos(empleados, capital, ganancias);
      Emprendimiento emprendimiento = new Emprendimiento(nombre, propietario, area, recursosYApoyos);
      mapa.put(nombre, emprendimiento);
      System.out.println("Se ha registrado el emprendimiento " + nombre);
    }
    lectorArchivo.close();

    System.out.println("Cargando proyectos...");
    lectorArchivo = new BufferedReader(new FileReader(archivoProyectos));
    while ((linea = lectorArchivo.readLine()) != null)
    {
      String[] info = linea.split(",");

      String nombreEmprendimiento = info[0];
      int idProyecto = Integer.parseInt(info[1]);
      String nombreProyecto = info[2];
      String encargadoProyecto = info[3];
      int personalRequerido = Integer.parseInt(info[4]);
      int costoEstimado = Integer.parseInt(info[5]);
      String estadoActual = info[6];

      Proyecto proyecto = new Proyecto(idProyecto, nombreProyecto, encargadoProyecto, personalRequerido, costoEstimado, estadoActual);
      Emprendimiento emprendimiento = mapa.get(nombreEmprendimiento);
      if (emprendimiento != null)
      {
        emprendimiento.insertarProyecto(proyecto);
        System.out.println("Se ha agregado el proyecto " + nombreProyecto + " al emprendimiento " + nombreEmprendimiento);
      }
      else
      {
        System.out.println("Emprendimiento no encontrado: " + nombreEmprendimiento);
      }
    }
    lectorArchivo.close();
  }

  public void menuPrincipal() throws IOException
  {
    cargarCasosPrueba();
    int opcion = -1;
    do
    {
      System.out.println("============================");
      System.out.println("       Menu Principal");
      System.out.println("============================");
      System.out.println("1) Registrar emprendimiento");
      System.out.println("2) Buscar emprendimiento");
      System.out.println("3) Eliminar emprendimiento");
      System.out.println("4) Salir del programa\n");
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
          System.out.println("Saliendo del programa...");
          break;
        default:
          break;
        }
      System.out.print("Presiona Enter para continuar...");
      lector.readLine();
      } while (opcion != 4);
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
      System.out.println("6) Ver resultados y crecimiento");
      System.out.println("7) Ver proyectos");
      System.out.println("8) Registrar proyecto");
      System.out.println("9) Buscar proyecto por nombre");
      System.out.println("10) Buscar proyecto por identificador");
      System.out.println("11) Eliminar proyecto");
      System.out.println("12) Volver menu principal\n");
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
          emprendimiento.resultados();
          System.out.println("El emprendimiento a crecido " + String.format("%.2f", emprendimiento.calcularCrecimiento()) + "%");
          break;
        case 7:
          emprendimiento.verProyectos();
          break;
        case 8:
          System.out.print("Ingrese el nombre del proyecto: ");
          String nombre = lector.readLine();
          System.out.print("Ingrese el identificador del proyecto: ");
          int id = Integer.parseInt(lector.readLine());
          System.out.print("Ingrese el encargado del proyecto: ");
          String encargado = lector.readLine();
          System.out.print("Ingrese el personal del proyecto: ");
          int personal = Integer.parseInt(lector.readLine());
          System.out.print("Ingrese el costo del proyecto: ");
          int costo = Integer.parseInt(lector.readLine());
          emprendimiento.insertarProyecto(id, nombre, encargado, personal, costo);
          break;
        case 9:
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
        case 10:
          System.out.print("Ingrese el identificador del proyecto a buscar: ");
          int identificador = Integer.parseInt(lector.readLine());
          proyecto = emprendimiento.getProyecto(identificador);
          if (proyecto == null)
          {
            System.out.println("No se ha encontrado el proyecto con identificador " + identificador);
          }
          else
          {
            menuProyecto(proyecto);
          }
          break;
        case 11:
          System.out.print("Ingrese el nombre del proyecto a eliminar: ");
          String aEliminar = lector.readLine();
          emprendimiento.eliminarProyecto(aEliminar);
          break;
        case 12:
          break;
        default:
          break;
      }
      System.out.print("Presiona Enter para continuar...");
      lector.readLine();
    } while (opcion != 12);
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
      System.out.println("5) Registrar ganancias del proyecto");
      System.out.println("6) Modificar estado del proyecto");
      System.out.println("7) Volver menu emprendimiento\n");
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
          System.out.print("Ingrese las ganancias del proyecto: ");
          int ganancias = Integer.parseInt(lector.readLine());
          System.out.print("Ingrese las perdidas del proyecto: ");
          int perdidas = Integer.parseInt(lector.readLine());

          if (perdidas == 0)
            proyecto.registrarGanancias(ganancias);
          else
            proyecto.registrarGanancias(ganancias, perdidas);
          break;
        case 6:
          System.out.print("Ingrese el estado actual del proyecto: ");
          String nuevoEstado = lector.readLine();

          proyecto.setEstadoActual(nuevoEstado);
          System.out.println("\nSe ha modificado el estado del proyecto a " + nuevoEstado);
          break;
        case 7:
          System.out.println("Volviendo al menu anterior...");
          break;
        default:
          break;
      }
      System.out.print("Presiona Enter para continuar...");
      lector.readLine();
    } while (opcion != 7);
  }
}