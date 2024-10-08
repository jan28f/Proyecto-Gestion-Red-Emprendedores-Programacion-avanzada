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
        cargarDatos("emprendimientosPrueba.csv", "proyectosPrueba.csv");
        System.out.println("Cargando datos...");
        cargarDatos("emprendimientos.csv", "proyectos.csv");
        int opcion = -1;
        do
        {
            System.out.println("==============================");
            System.out.println("       Menu Principal");
            System.out.println("==============================");
            System.out.println("1) Registrar emprendimiento");
            System.out.println("2) Buscar emprendimiento");
            System.out.println("3) Eliminar emprendimiento");
            System.out.println("4) Generar reporte y salir del programa\n");

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
                    try
                    {
                        Emprendimiento emprendimiento = redemprendimiento.obtenerEmprendimiento(aBuscar);
                        menuEmprendimiento(emprendimiento);
                    }
                    catch (EmprendimientoNoEncontradoException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    String aEliminar = leerCadena("Ingrese el nombre del emprendimiento a eliminar: ");
                    redemprendimiento.eliminarEmprendimiento(aEliminar);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    generarReporte();
                    guardarDatos();
                    break;
                default:
                    System.out.println("Ingrese una opcion valida.");
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
            System.out.println("8) Ver resultados de emprendimiento");
            System.out.println("9) Cambiar propietario del emprendimiento");
            System.out.println("10) Cambiar area del emprendimiento");
            System.out.println("11) Cambiar total de empleados del emprendimiento");
            System.out.println("12) Cambiar capital del emprendimiento");
            System.out.println("13) Volver menu principal\n");

            opcion = leerEntero("Ingrese una opcion: ");
            switch (opcion)
            {
                case 1:
                    menuAgregarProyecto(emprendimiento);
                    break;
                case 2:
                    int idBuscar = leerEntero("Ingrese el identificador del proyecto a buscar: ");
                    try
                    {
                        Proyecto proyecto = emprendimiento.conseguirProyecto(idBuscar);
                        menuProyecto(proyecto);
                    }
                    catch (ProyectoNoEncontradoException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    String nombreBuscar = leerCadena("Ingrese el nombre del proyecto a buscar: ");
                    try
                    {
                        Proyecto proyecto = emprendimiento.conseguirProyecto(nombreBuscar);
                        menuProyecto(proyecto);
                    }
                    catch (ProyectoNoEncontradoException e)
                    {
                        System.out.println(e.getMessage());
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
                    System.out.println("Ingrese una opcion valida.");   
                    break;
            }
            if (opcion != 13)
            {
                System.out.print("Presiona Enter para continuar...");
                lector.readLine();
            }
        } while (opcion != 13);
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
                    proyecto.setEstadoActual(leerCadena("Ingrese el nuevo estado del proyecto (En curso / Completo / Cancelado): "));
                    System.out.println("\nSe ha cambiado el estado del proyecto a: " + proyecto.getEstado());
                    break;
                
                case 7:
                    System.out.println("Volviendo al menu anterior...");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida.");
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
        File archivoEmprendimientos = new File("datos/emprendimientos.csv");
        if (!archivoEmprendimientos.exists())
        {
            archivoEmprendimientos = new File("src/main/java/datos/emprendimientos.csv");
        }
        File archivoProyectos = new File("datos/proyectos.csv");
        if (!archivoProyectos.exists())
        {
            archivoProyectos = new File("src/main/java/datos/proyectos.csv");
        }
        BufferedWriter escritorEmprendimientos = new BufferedWriter(new FileWriter(archivoEmprendimientos));
        BufferedWriter escritorProyectos = new BufferedWriter(new FileWriter(archivoProyectos));
        String clavesEmprendimiento = redemprendimiento.conseguirClaves();
        String[] claves = clavesEmprendimiento.split(",");
        
        for (String clave : claves)
        {
            try
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
                if (!idProyectos.equals(""))
                {
                    System.out.println("Identificadores de proyecto: " + idProyectos + "\n");
                    String[] identificadores = idProyectos.split(",");
                    for (String identificador : identificadores)
                    {
                        try
                        {
                            Proyecto proyecto = emprendimiento.conseguirProyecto(Integer.parseInt(identificador));
                            String tipoProyecto = "General";
                            String infoAdicional = "";

                            if (proyecto instanceof ProyectoSocial)
                            {
                                tipoProyecto = "Social";
                                infoAdicional = ((ProyectoSocial)proyecto).getComunidadBeneficiada();
                            }
                            else if (proyecto instanceof ProyectoTecnologico)
                            {
                                tipoProyecto = "Tecnologico";
                                infoAdicional = ((ProyectoTecnologico)proyecto).getTecnologiaUsada();
                            }

                            String infoProyecto = emprendimiento.getNombre() + "," + identificador + "," + 
                                                proyecto.getNombreProyecto() + "," + proyecto.getEncargado() + "," +
                                                String.valueOf(proyecto.getPersonalRequerido()) + "," + String.valueOf(proyecto.getCosto())
                                                + "," + String.valueOf(proyecto.getGanancias()) + "," + proyecto.getEstado() + "," +
                                                tipoProyecto + "," + infoAdicional;
                            escritorProyectos.write(infoProyecto);
                            escritorProyectos.newLine();
                        }
                        catch (ProyectoNoEncontradoException e)
                        {
                            System.out.println("No se pudo guardar el proyecto con identificador " + identificador + ": " + e.getMessage());
                        }
                    }
                }
            }
            catch (EmprendimientoNoEncontradoException e)
            {
                System.out.println("No se pudo guardar el emprendimiento " + clave + " y sus proyectos relacionados.");
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
    public void cargarDatos(String nombreArchivoEmprendimientos, String nombreArchivoProyectos) throws IOException
    {
        String ruta = "datos/";
        File archivoEmprendimientos = new File(ruta, nombreArchivoEmprendimientos);
        if (!archivoEmprendimientos.exists())
        {
            ruta = "src/main/java/datos/";
            archivoEmprendimientos = new File(ruta, nombreArchivoEmprendimientos);
        }
        File archivoProyectos = new File(ruta, nombreArchivoProyectos);
        BufferedReader lectorArchivo = new BufferedReader(new FileReader(archivoEmprendimientos));
        
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
        lectorArchivo = new BufferedReader(new FileReader(archivoProyectos));
        System.out.println("Cargando proyectos...");
        while ((linea = lectorArchivo.readLine()) != null)
        {
            String[] infoProyecto = linea.split(",", -1);
            String nombreEmprendimiento = infoProyecto[0];
            int idProyecto = Integer.parseInt(infoProyecto[1]);
            String nombreProyecto = infoProyecto[2];
            String encargadoProyecto = infoProyecto[3];
            int personalRequerido = Integer.parseInt(infoProyecto[4]);
            int costoEstimado = Integer.parseInt(infoProyecto[5]);
            int ganancias = Integer.parseInt(infoProyecto[6]);
            String estado = infoProyecto[7];
            String tipoProyecto = infoProyecto[8];
            String infoAdicional = infoProyecto[9];

            try
            {
                Emprendimiento emprendimiento = redemprendimiento.obtenerEmprendimiento(nombreEmprendimiento);
                if (tipoProyecto.equals("Social"))
                {
                    emprendimiento.insertarProyectoSocial(idProyecto, nombreProyecto, encargadoProyecto, personalRequerido, costoEstimado, ganancias, estado, infoAdicional);
                }
                else if (tipoProyecto.equals("Tecnologico"))
                {
                    emprendimiento.insertarProyectoTecnologico(idProyecto, nombreProyecto, encargadoProyecto, personalRequerido, costoEstimado, ganancias, estado, infoAdicional);
                }
                else
                {
                    emprendimiento.insertarProyecto(idProyecto, nombreProyecto, encargadoProyecto, personalRequerido, costoEstimado, ganancias, estado);
                }
                System.out.println("Se ha agregado el proyecto " + nombreProyecto + " al emprendimiento " + nombreEmprendimiento);
            }
            catch (EmprendimientoNoEncontradoException e)
            {
                 System.out.println("Emprendimiento no encontrado: " + nombreEmprendimiento);
            }
        }
        lectorArchivo.close();
    }
    /**
     * Genera un reporte en un archivo txt, con los emprendimientos y sus proyectos y se almacena en datos.
     * @throws IOException
     */
    public void generarReporte() throws IOException
    {
        File archivo = new File("src/main/java/datos/emprendimientos.csv");
        String ruta = "src/main/java/datos";
        if (!archivo.exists())
        {
            ruta = "datos";
        }
        BufferedWriter escritor = new BufferedWriter(new FileWriter(new File(ruta, "reporte.txt")));
        String clavesEmprendimiento = redemprendimiento.conseguirClaves();
        String[] claves = clavesEmprendimiento.split(",");

        escritor.write("----------------------------------------------------");
        escritor.newLine();
        escritor.write("                        Reporte");
        escritor.newLine();
        escritor.write("----------------------------------------------------");
        escritor.newLine();
        for (String clave : claves)
        {
            try
            {
                Emprendimiento emprendimiento = redemprendimiento.obtenerEmprendimiento(clave);
                escritor.write("Emprendimiento: " + emprendimiento.getNombre());
                escritor.newLine();
                escritor.write("Propietario: " + emprendimiento.getPropietario());
                escritor.newLine();
                escritor.write("Área: " + emprendimiento.getArea());
                escritor.newLine();
                escritor.write("Total de empleados: " + emprendimiento.getTotalEmpleados());
                escritor.newLine();
                escritor.write("Capital: " + emprendimiento.getCapital());
                escritor.newLine();
                escritor.write("Monto de apoyo: " + emprendimiento.getMontoApoyo());
                escritor.newLine();
                escritor.write("Proyectos:");
                escritor.newLine();

                String StringIds = emprendimiento.conseguirIdProyectos();
                if (!StringIds.equals(""))
                {
                    String[] idProyectos = StringIds.split(",");
                    for (String id : idProyectos)
                    {
                        try
                        {
                            Proyecto proyecto = emprendimiento.conseguirProyecto(Integer.parseInt(id));
                            escritor.write("\tProyecto ID: " + proyecto.getIdentificador());
                            escritor.newLine();
                            escritor.write("\tNombre: " + proyecto.getNombreProyecto());
                            escritor.newLine();
                            escritor.write("\tEncargado: " + proyecto.getEncargado());
                            escritor.newLine();
                            escritor.write("\tEstado: " + proyecto.getEstado());
                            escritor.newLine();
                            escritor.write("\tGanancias: " + proyecto.getGanancias());
                            escritor.newLine();
                            if (proyecto instanceof ProyectoSocial)
                            {
                                escritor.write("\tTipo de proyecto: Social");
                                escritor.newLine();
                                escritor.write("\tComunidad beneficiada: " + ((ProyectoSocial)proyecto).getComunidadBeneficiada());
                                escritor.newLine();
                            }
                            else if (proyecto instanceof ProyectoTecnologico)
                            {
                                escritor.write("\tTipo de proyecto: Tecnologico");
                                escritor.newLine();
                                escritor.write("\tTecnologia usada: " + ((ProyectoTecnologico)proyecto).getTecnologiaUsada());
                                escritor.newLine();
                            }
                            else
                            {
                                escritor.write("\tTipo de proyecto: General");
                                escritor.newLine();
                            }
                            escritor.newLine();
                        }
                        catch (ProyectoNoEncontradoException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                escritor.write("----------------------------------------------------");
                escritor.newLine();
            }
            catch (EmprendimientoNoEncontradoException e)
            {
                System.out.println(e.getMessage());
            }
        }
        escritor.close();
        System.out.println("Reporte generado en 'reporte.txt'");
    }
}