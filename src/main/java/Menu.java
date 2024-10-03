import java.io.*;

/**
 * Clase encargada de representar los menus de la aplicacion, para que el usuario pueda interactuar
 * y gestionar los emprendimientos y sus proyectos.
 */
public class Menu
{
    /**
     * Declaracion de variables de la clase:
     * redEmprendimientos: Instancia para gestionar los emprendimientos.
     * lector: Entrada para que el usuario pueda interactuar.
     */
    private RedEmprendedores redemprendimiento = new RedEmprendedores();
    private BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Metodo que muestra el menu principal para que el usuario pueda interactuar con sus distintas opciones.
     * @throws IOException Si ocurre un error con la entrada/salida.
     */
    public void menuPrincipal() throws IOException
    {
        System.out.println("Cargando casos de prueba...");
        cargarDatos("datos/emprendimientosPrueba.csv", "datos/proyectosPrueba.csv");
        System.out.println("Cargando datos...");
        cargarDatos("datos/emprendimientos.csv", "datos/proyectos.csv");
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

            opcion = leerEntero("Ingrese una opcion: ");
            switch(opcion)
            {
                case 1:
                    String nombre = leerCadena("Ingresa el nombre del emprendimiento: ");
                    String propietario = leerCadena("Ingresa el nombre del propietario del emprendimiento: ");
                    String area = leerCadena("Ingresa el area a la que se dedica el emprendimiento: ");
                    int empleados = leerEntero("Ingrese cuantos empleados tiene el emprendimiento: ");
                    int capital = leerEntero("Ingrese el capital inicial del emprendimiento: ");
                    int montoApoyo = leerEntero("Ingrese el monto de los apoyos que tiene el emprendimiento: ");
                    redemprendimiento.registrarEmprendimiento(nombre, propietario, area, empleados, capital, montoApoyo);
                    break;
                case 2:
                    String aBuscar = leerCadena("Ingresa el nombre del emprendimiento a buscar: ");
                    Emprendimiento emprendimiento = redemprendimiento.obtenerEmprendimiento(aBuscar);
                    if (emprendimiento != null)
                    {
                    menuEmprendimiento(emprendimiento);
                    }
                    break;
                case 3:
                    String aEliminar = leerCadena("Ingrese el nombre del emprendimiento a eliminar: ");
                    redemprendimiento.eliminarEmprendimiento(aEliminar);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    guardarDatos();
                    break;
                default:
                    break;
            }
            System.out.print("Presiona Enter para continuar...");
            lector.readLine();
        } while (opcion != 4);
        lector.close();
    }
    /**
     * Muestra el menu de opciones para gestionar un emprendimiento.
     * @param emprendimiento Emprendimiento seleccionado.
     * @throws IOException Si ocurre un error con la entrada/salida.
     */
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
            System.out.println("7) Ver proyectos segun estado");
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
                    menuAgregarProyecto(emprendimiento);
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
                    break;
                case 5:
                    String nombreEliminar = leerCadena("Ingrese el nombre del proyecto a eliminar: ");
                    emprendimiento.eliminarProyecto(nombreEliminar);
                    break;
                case 6:
                    emprendimiento.verProyectos();
                    break;
                case 7:
                    String estadoFiltro = leerCadena("Ingrese el estado por el que quiere filtrar los proyectos (En curso \\ Completo \\ Cancelado): ");
                    emprendimiento.verProyectosFiltrados(estadoFiltro);
                    break;
                case 8:
                    emprendimiento.resultados();
                    break;
                case 9:
                    String propietarioNuevo = leerCadena("Ingrese el nombre del nuevo propietario del emprendimiento: ");
                    emprendimiento.setPropietario(propietarioNuevo);
                    System.out.println("Se ha cambiado el propietario del emprendimiento a " + propietarioNuevo);
                    break;
                case 10:
                    String areaNuevo = leerCadena("Ingrese la nueva area de trabajo del emprendimiento: ");
                    emprendimiento.setArea(areaNuevo);
                    System.out.println("Se ha cambiado el area de trabajo del emprendimiento a " + areaNuevo);
                    break;
                case 11:
                    int totalEmpleadosNuevo = leerEntero("Ingrese el nuevo total de empleados del emprendimiento: ");
                    emprendimiento.setTotalEmpleados(totalEmpleadosNuevo);
                    System.out.println("Se ha cambiado el total de empleados del emprendimiento a: " + totalEmpleadosNuevo);
                    break;
                case 12:
                    int capitalNuevo = leerEntero("Ingrese el nuevo capital del emprendimiento: ");
                    emprendimiento.setCapital(capitalNuevo);
                    System.out.println("Se ha cambiado el capital del emprendimiento a: " + capitalNuevo);
                    break;
                case 13:
                    break;
                default:
                    break;
            }
            if (opcion != 13)
            {
                System.out.print("Presiona Enter para continuar...");
                lector.readLine();
            }
        } while (opcion != 12);
    }
    /**
     * Menu para agregar distintos tipos de proyectos a un emprendimiento.
     * @param emprendimiento Emprendimiento al que se le agregara un proyecto.
     * @throws IOException Si ocurre un error con la entrada/salida.
     */
    public void menuAgregarProyecto(Emprendimiento emprendimiento) throws IOException
    {
        System.out.println("Seleccione el tipo de proyecto:");
        System.out.println("1) Proyecto General");
        System.out.println("2) Proyecto Tecnológico");
        System.out.println("3) Proyecto Social\n");
        int tipoProyecto = leerEntero("Ingrese una opción: ");
        int id = leerEntero("Ingrese el identificador del proyecto: ");
        String nombreProyecto = leerCadena("Ingrese el nombre del proyecto: ");
        String encargado = leerCadena("Ingrese el encargado del proyecto: ");
        int personal = leerEntero("Ingrese el personal requerido por el proyecto: ");
        int costo = leerEntero("Ingrese el costo del proyecto: ");
        switch (tipoProyecto)
        {
            case 1:
                emprendimiento.insertarProyecto(id, nombreProyecto, encargado, personal, costo);
                break;
            case 2:
                String tecnologiaUsada = leerCadena("Ingrese la tecnología usada en el proyecto: ");
                emprendimiento.insertarProyectoTecnologico(id, nombreProyecto, encargado, personal, costo, tecnologiaUsada);
                break;
            case 3:
                String comunidadBeneficiada = leerCadena("Ingrese la comunidad beneficiada por el proyecto: ");
                emprendimiento.insertarProyectoSocial(id, nombreProyecto, encargado, personal, costo, comunidadBeneficiada);
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
    /**
     * Muestra el menu de opciones para gestionar un proyecto.
     * @param proyecto Proyecto seleccionado.
     * @throws IOException Si ocurre un error con la entrada/salida.
     */
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
            if (opcion != 7)
            {
                System.out.print("Presiona Enter para continuar...");
                lector.readLine();
            }
        } while (opcion != 7);
    }
    /**
     * Se muestra un mensaje deseado y se lee un numero entero ingresado por el usuario.
     * @param mensaje Mensaje a mostrar.
     * @return Numero entero ingresado por el usuario
     * @throws IOException Si ocurre un error con la entrada/salida.
     */
    public int leerEntero(String mensaje) throws IOException
    {
        while (true)
        {
            System.out.printf(mensaje);
            int valor;
            try
            {
                valor = Integer.parseInt(lector.readLine());
                return valor;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Ingrese un numero entero valido.");
            }
        }
    }
    /**
     * Se muestra un mensaje deseado y se lee una cadena de caracteres ingresada por el usuario.
     * @param mensaje Mensaje a mostrar.
     * @return Cadena de caracteres ingresada por el usuario.
     * @throws IOException Si ocurre un error con la entrada/salida.
     */
    public String leerCadena(String mensaje) throws IOException
    {
        System.out.printf(mensaje);
        String cadena = lector.readLine();

        return cadena;
    }
    /**
     * Guarda los datos actuales de emprendimientos y sus proyectos en un archivo csv.
     * @throws IOException Si ocurre un error con la entrada/salida.
     */
    public void guardarDatos() throws IOException
    {
        System.out.println("Guardando informacion...");
        BufferedWriter escritorEmprendimientos = new BufferedWriter(new FileWriter(new File("datos", "emprendimientos.csv")));
        BufferedWriter escritorProyectos = new BufferedWriter(new FileWriter(new File("datos","proyectos.csv")));
        String clavesEmprendimiento = redemprendimiento.conseguirClaves();
        String[] claves = clavesEmprendimiento.split(",");
        
        for (String clave : claves)
        {
            Emprendimiento emprendimiento = redemprendimiento.obtenerEmprendimiento(clave);
            System.out.println("Emprendimiento: " + emprendimiento.getNombre());
            String infoEmprendimiento = emprendimiento.getNombre() + "," + emprendimiento.getPropietario() + "," +
                                        emprendimiento.getArea() + "," + emprendimiento.getTotalEmpleados() + "," +
                                        emprendimiento.getCapital() + "," + emprendimiento.getCapitalInicial() + "," +
                                        emprendimiento.getMontoApoyo();
            escritorEmprendimientos.write(infoEmprendimiento);
            escritorEmprendimientos.newLine();

            String idProyectos = emprendimiento.conseguirIdProyectos();
            System.out.println("Identificadores de proyecto: " + idProyectos + "\n");
            String[] identificadores = idProyectos.split(",");
            for (String identificador : identificadores)
            {
                Proyecto proyecto = emprendimiento.conseguirProyecto(Integer.parseInt(identificador));
                String infoProyecto = emprendimiento.getNombre() + "," + identificador + "," + 
                                      proyecto.getNombreProyecto() + "," + proyecto.getEncargado() + "," +
                                      String.valueOf(proyecto.getPersonalRequerido()) + "," + String.valueOf(proyecto.getCosto())
                                      + "," + String.valueOf(proyecto.getGanancias()) + "," + proyecto.getEstado();
                escritorProyectos.write(infoProyecto);
                escritorProyectos.newLine();                      
            }
        }
        escritorEmprendimientos.close();
        escritorProyectos.close();
        System.out.println();
    }
    /**
     * Carga los datos de emprendimienots y sus proyectos asociados desde un archivo csv.
     * @param rutaEmprendimiento Ruta del archivo csv de los emprendimientos.
     * @param rutaProyectos Ruta del archivo csv de los proyectos.
     * @throws IOException Si ocurre un error con la entrada/salida.
     */
    public void cargarDatos(String rutaEmprendimiento, String rutaProyectos) throws IOException
    {
        InputStream archivoEmprendimientos = getClass().getClassLoader().getResourceAsStream(rutaEmprendimiento);
        InputStream archivoProyectos = getClass().getClassLoader().getResourceAsStream(rutaProyectos);
        BufferedReader lectorArchivo = new BufferedReader(new InputStreamReader(archivoEmprendimientos));
        
        String linea;
        System.out.println("Cargando emprendimientos...");
        while ((linea = lectorArchivo.readLine()) != null)
        {
            String[] infoEmprendimiento = linea.split(",");

            String nombre = infoEmprendimiento[0];
            String propietario = infoEmprendimiento[1];
            String area = infoEmprendimiento[2];
            int empleados = Integer.parseInt(infoEmprendimiento[3]);
            int capital = Integer.parseInt(infoEmprendimiento[4]);
            int capitalInicial = Integer.parseInt(infoEmprendimiento[5]);
            int montoApoyo = Integer.parseInt(infoEmprendimiento[6]);
            redemprendimiento.registrarEmprendimiento(nombre, propietario, area, empleados, capital, capitalInicial, montoApoyo);
        }
        lectorArchivo.close();
        lectorArchivo = new BufferedReader(new InputStreamReader(archivoProyectos));
        System.out.println("Cargando proyectos...");
        while ((linea = lectorArchivo.readLine()) != null)
        {
            String[] infoProyecto = linea.split(",");
            String nombreEmprendimiento = infoProyecto[0];
            int idProyecto = Integer.parseInt(infoProyecto[1]);
            String nombreProyecto = infoProyecto[2];
            String encargadoProyecto = infoProyecto[3];
            int personalRequerido = Integer.parseInt(infoProyecto[4]);
            int costoEstimado = Integer.parseInt(infoProyecto[5]);
            int ganancias = Integer.parseInt(infoProyecto[6]);
            String estado = infoProyecto[7];

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
}