import java.io.*;

public class Menu
{
    private RedEmprendedores redemprendimiento = new RedEmprendedores();
    private BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

    public void cargarCasosPrueba() throws IOException
    {
        InputStream archivoEmprendimientos = getClass().getClassLoader().getResourceAsStream("datos/emprendimientosPrueba.csv");
        InputStream archivoProyectos = getClass().getClassLoader().getResourceAsStream("datos/proyectosPrueba.csv");
        BufferedReader lectorArchivo = new BufferedReader(new InputStreamReader(archivoEmprendimientos));

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

            redemprendimiento.registrarEmprendimiento(nombre, propietario, area, empleados, capital, ganancias);
            System.out.println("Se ha registrado el emprendimiento " + nombre);
        }
        lectorArchivo.close();

        System.out.println("Cargando proyectos...");
        lectorArchivo = new BufferedReader(new InputStreamReader(archivoProyectos));
        while ((linea = lectorArchivo.readLine()) != null)
        {
            String[] info = linea.split(",");

            String nombreEmprendimiento = info[0];
            int idProyecto = Integer.parseInt(info[1]);
            String nombreProyecto = info[2];
            String encargadoProyecto = info[3];
            int personalRequerido = Integer.parseInt(info[4]);
            int costoEstimado = Integer.parseInt(info[5]);
            int ganancias = Integer.parseInt(info[6]);
            String estado = info[7];

            Emprendimiento emprendimiento = redemprendimiento.obtenerEmprendimiento(nombreEmprendimiento);
            if (emprendimiento != null)
            {
                emprendimiento.insertarProyecto(idProyecto, nombreProyecto, encargadoProyecto, personalRequerido, costoEstimado, ganancias, estado);
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
            System.out.println("==============================");
            System.out.println("       Menu Principal");
            System.out.println("==============================");
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
                    registrarEmprendimiento();
                    break;
                case 2:
                    buscarEmprendimiento();
                    break;
                case 3:
                    eliminarEmprendimiento();
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
    public void registrarEmprendimiento() throws IOException
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

        redemprendimiento.registrarEmprendimiento(nombre, propietario, area, empleados, capital, montoApoyo);
    }
    public void buscarEmprendimiento() throws IOException
    {
        System.out.print("Ingresa el nombre del emprendimiento a buscar: ");
        String aBuscar = lector.readLine();

        Emprendimiento emprendimiento = redemprendimiento.obtenerEmprendimiento(aBuscar);
        if (emprendimiento != null)
        {
        menuEmprendimiento(emprendimiento);
        }
    }
    public void eliminarEmprendimiento() throws IOException
    {
        System.out.print("Ingrese el nombre del emprendimiento a eliminar: ");
        String aEliminar = lector.readLine();

        redemprendimiento.eliminarEmprendimiento(aEliminar);
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
            System.out.println("\n1) Registrar proyecto");
            System.out.println("2) Buscar proyecto por identificador");
            System.out.println("3) Buscar proyecto por nombre");
            System.out.println("4) Eliminar proyecto por identificador");
            System.out.println("5) Eliminar proyecto por nombre");
            System.out.println("6) Ver proyectos");
            System.out.println("7) Ver resultados de emprendimiento");
            System.out.println("8) Cambiar propietario del emprendimiento");
            System.out.println("9) Cambiar area del emprendimiento");
            System.out.println("10) Cambiar total de empleados del emprendimiento");
            System.out.println("11) Cambiar capital del emprendimiento");
            System.out.println("12) Volver menu principal\n");

            opcion = leerEntero("Ingrese una opcion: ");
            switch (opcion)
            {
                case 1:
                    int id = leerEntero("Ingrese el identificador del proyecto: ");
                    String nombre = leerCadena("Ingrese el nombre del proyecto: ");
                    String encargado = leerCadena("Ingrese el encargado del proyecto: ");
                    int personal = leerEntero("Ingrese el personal requerido por el proyecto: ");
                    int costo = leerEntero("Ingrese el costo del proyecto: ");
                    emprendimiento.insertarProyecto(id, nombre, encargado, personal, costo);
                    break;
                case 2:
                    int idBuscar = leerEntero("Ingrese el identificador del proyecto a buscar: ");
                    Proyecto proyecto = emprendimiento.conseguirProyecto(idBuscar);
                    if (proyecto != null)
                    {
                        menuProyecto(proyecto);
                    }
                    else
                    {
                        System.out.println("No se ha encontrado el proyecto con identificador " + idBuscar);
                    }
                    break;
                case 3:
                    String nombreBuscar = leerCadena("Ingrese el nombre del proyecto a buscar: ");
                    proyecto = emprendimiento.conseguirProyecto(nombreBuscar);
                    if (proyecto != null)
                    {
                        menuProyecto(proyecto);
                    }
                    else
                    {
                        System.out.println("No se ha encontrado el proyecto con nombre " + nombreBuscar);
                    }
                    break;
                case 4:
                    int idEliminar = leerEntero("Ingrese el identificador del proyecto a eliminar: ");
                    emprendimiento.eliminarProyecto(idEliminar);
                case 5:
                    String nombreEliminar = leerCadena("Ingrese el nombre del proyecto a eliminar: ");
                    emprendimiento.eliminarProyecto(nombreEliminar);
                    break;
                case 6:
                    emprendimiento.verProyectos();
                    break;
                case 7:
                    emprendimiento.resultados();
                    break;
                case 8:
                    String propietarioNuevo = leerCadena("Ingrese el nombre del nuevo propietario del emprendimiento: ");
                    emprendimiento.setPropietario(propietarioNuevo);
                    System.out.println("Se ha cambiado el propietario del emprendimiento a " + propietarioNuevo);
                    break;
                case 9:
                    String areaNuevo = leerCadena("Ingrese la nueva area de trabajo del emprendimiento: ");
                    emprendimiento.setArea(areaNuevo);
                    System.out.println("Se ha cambiado el area de trabajo del emprendimiento a " + areaNuevo);
                    break;
                case 10:
                    int totalEmpleadosNuevo = leerEntero("Ingrese el nuevo total de empleados del emprendimiento: ");
                    emprendimiento.setTotalEmpleados(totalEmpleadosNuevo);
                    System.out.println("Se ha cambiado el total de empleados del emprendimiento a: " + totalEmpleadosNuevo);
                    break;
                case 11:
                    int capitalNuevo = leerEntero("Ingrese el nuevo capital del emprendimiento: ");
                    emprendimiento.setCapital(capitalNuevo);
                    System.out.println("Se ha cambiado el capital del emprendimiento a: " + capitalNuevo);
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
            System.out.println("\n1) Registrar ganancias");
            System.out.println("2) Cambiar nombre de proyecto");
            System.out.println("3) Cambiar encargado de proyecto");
            System.out.println("4) Cambiar personal requerido para el proyecto");
            System.out.println("5) Cambiar costo del proyecto");
            System.out.println("6) Cambiar estado del proyecto");
            System.out.println("7) Volver menu emprendimiento\n");

            opcion = leerEntero("Ingrese una opcion: ");
            switch (opcion)
            {
                case 1:
                    int ganancias = leerEntero("Ingrese las ganancias del proyecto: ");
                    if (leerCadena("¿Quiere registrar perdidas? (s/n)").equals("s"))
                    {
                        proyecto.registrarGanancias(ganancias, leerEntero("Ingrese las perdidas del proyecto: "));
                    }
                    System.out.println("\nLas ganancias del proyecto son: " + proyecto.getGanancias());
                    break;
                case 2:
                    proyecto.setNombreProyecto(leerCadena("Ingrese el nuevo nombre del proyecto: "));
                    System.out.println("\nSe ha cambio el nombre del proyecto a: " + proyecto.getNombreProyecto());
                    break;
                case 3:
                    proyecto.setEncargado(leerCadena("Ingrese al nuevo encargado del proyecto: "));
                    System.out.println("\nSe ha cambiado al encargado del proyecto a: " + proyecto.getEncargado());
                    break;
                case 4:
                    proyecto.setPersonalRequerido(leerEntero("Ingrese la nueva cantidad de personal requerido en el proyecto: "));
                    System.out.println("\nSe ha cambiado el personal requerido del proyecto a: " + proyecto.getPersonalRequerido());
                    break;
                case 5:
                    proyecto.setCosto(leerEntero("Ingrese el nuevo costo del proyecto: "));
                    System.out.println("\nSe ha cambiado el costo del proyecto a: " + proyecto.getCosto());
                    break;
                case 6:
                    proyecto.setEstadoActual("Ingrese el nuevo estado del proyecto (En curso / Completo / Cancelado): ");
                    System.out.println("\nSe ha cambiado el estado del proyecto a: " + proyecto.getEstado());
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
    public int leerEntero(String mensaje) throws IOException
    {
        System.out.printf(mensaje);
        int valor = Integer.parseInt(lector.readLine());

        return valor;
    }
    public String leerCadena(String mensaje) throws IOException
    {
        System.out.printf(mensaje);
        String cadena = lector.readLine();

        return cadena;
    }
}