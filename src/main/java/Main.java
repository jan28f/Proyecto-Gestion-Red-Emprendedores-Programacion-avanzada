import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
	public static void main(String [] args) throws IOException
	{  
		Main app = new Main();
		app.menuPrincipal();
	}
	
	public void menuPrincipal() throws IOException
	{
		HashMap<String, Emprendimiento> emprendimientos = new HashMap<String, Emprendimiento>();
		HashMap<String, Proyecto> proyectos = new HashMap<String, Proyecto>();
		String aBuscar;

		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		int opcion = -1;
		do
		{
			System.out.println("============================");
			System.out.println("       Menu Principal");
			System.out.println("============================");
			System.out.println("1) Buscar emprendimiento");
			System.out.println("2) Buscar proyecto");
			System.out.println("3) Registrar emprendimiento");
			System.out.println("4) Registrar proyecto");
			System.out.println("5) Salir del programa\n");
			System.out.print("Ingrese una opcion: ");
	
			String numero = lector.readLine();
			opcion = Integer.parseInt(numero);
			switch(opcion)
			{
				case 1:
					System.out.println("============================");
					System.out.println("    Buscar emprendimiento");
					System.out.println("============================");
					System.out.print("Ingrese el nombre del emprendimiento a buscar: ");
					aBuscar = lector.readLine();
		    		
					Emprendimiento emprendimiento = emprendimientos.get(aBuscar);
					if (emprendimiento != null)
					{
						String nombreEmprendimiento = emprendimiento.getNombreEmprendimiento();
						System.out.println(nombreEmprendimiento);
					}
					else
						System.out.println("No se encontro " + aBuscar + " en el registro de emprendimientos");

					break;
				case 2:
					System.out.println("============================");
					System.out.println("      Buscar proyecto");
					System.out.println("============================");
					System.out.print("Ingrese el nombre del proyecto a buscar: ");
					aBuscar = lector.readLine();

					Proyecto proyecto = proyectos.get(aBuscar);
					if (proyecto != null)
					{
						String nombreProyecto = proyecto.getNombreProyecto();
						System.out.println(nombreProyecto);
					}
					else
						System.out.println("No se encontro " + aBuscar + " en el registro de proyectos");
					break;
				case 3:
					System.out.println("============================");
					System.out.println("  Registrar emprendimiento");
					System.out.println("============================");
					System.out.println("Ingrese la informacion solicitada a continuacion para registrar el emprendimiento");

					System.out.print("Nombre del emprendimiento: ");
					String nombreEmprendimiento = lector.readLine();
					System.out.print("Nombre del propietario del emprendimiento: ");
					String nombreDueno = lector.readLine();
					System.out.print("Especialidad de la empresa: ");
					String especialidadEmpresa = lector.readLine();
					System.out.print("Capital monetario de la empresa: ");
					int capitalMonetario = Integer.parseInt(lector.readLine());
					System.out.print("Total de empleados: ");
					int totalEmpleados = Integer.parseInt(lector.readLine());
					Emprendimiento nuevoEmprendimiento = new Emprendimiento(nombreEmprendimiento, nombreDueno, especialidadEmpresa, capitalMonetario, totalEmpleados);
					
					emprendimientos.put(nombreEmprendimiento, nuevoEmprendimiento);
					System.out.print("Se ha registrado exitosamente su emprendimiento");
					break;
				case 4:
					break;
				case 5:
					System.out.println("Saliendo del programa...");
					break;
				default:
					System.out.println("Opcion invalida");
					System.out.println("Marque otra opcion");
					break;
		  	}
			System.out.print("\nPresiona Enter para continuar...");
			lector.readLine();    
	  	} while (opcion != 5);
	  	lector.close();
	}
}