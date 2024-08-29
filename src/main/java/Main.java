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

	public void menuModificacionEmprendimiento(Emprendimiento emprendimiento)
	{
		Scanner scanner = new Scanner(System.in);
		int opcion = -1;

		do
		{
			System.out.println("¿Que desea hacer modificar?");
			System.out.println("1) Propietario de la empresa");
			System.out.println("2) Especialidad de la empresa");
			System.out.println("3) Capital monetario de la empresa");
			System.out.println("4) Empleados en la empresa");
			System.out.println("5) Ningun cambio\n");
			System.out.print("Ingrese una opcion: ");
			opcion = scanner.nextInt();

			switch (opcion)
			{
				case 1:
					System.out.print("Ingrese el nombre del nuevo propietario: ");
					scanner.nextLine();
					String nuevoPropietario = scanner.nextLine();
					emprendimiento.setNombrePropietario(nuevoPropietario);
					System.out.print("\nSe ha cambiado el propietario");
					break;
				case 2:
					System.out.print("Ingrese la nueva especialidad de la empresa: ");
					scanner.nextLine();
					String nuevaEspecialidad = scanner.nextLine();
					emprendimiento.setEspecialidad(nuevaEspecialidad);
					System.out.print("\nSe ha cambiado la especialidad de la empresa");
					break;
				case 3:
					System.out.print("Ingrese el nuevo capital de la empresa: ");
					int nuevoCapitalMonetario = scanner.nextInt();
					emprendimiento.setCapitalMonetario(nuevoCapitalMonetario);
					System.out.print("\nSe ha actualizado el capital de la empresa");
					break;
				case 4:
					System.out.print("Ingrese la nueva cantidad de empleados: ");
					int nuevoTotalEmpleados = scanner.nextInt();
					emprendimiento.setTotalEmpleados(nuevoTotalEmpleados);
					System.out.print("\nSe ha actualizado el total de empleados de la empresa");
					break;
				case 5:
					break;
				default:
					System.out.println("Ingrese una opcion valida...");
					break;
			}
		} while (opcion != 5);
	}

	public void menuEmprendimientos(Emprendimiento emprendimiento)
	{
		Scanner scanner = new Scanner(System.in);
		int opcion = -1;

		do
		{
			System.out.println("¿Que desea hacer?");
			System.out.println("1) Ver informacion general de la empresa");
			System.out.println("2) Modificar informacion");
			System.out.println("3) Volver al menu principal\n");
			System.out.print("Ingrese una opcion: ");
			opcion = scanner.nextInt();

			switch (opcion)
			{
				case 1:
					break;
				case 2:
					menuModificacionEmprendimiento(emprendimiento);
					break;
				case 3:
					break;
				default:
					System.out.println("Ingrese una opcion valida...");
					break;
			}
		} while (opcion != 3);
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
						System.out.println("Se ha encontrado un emprendimiento en el registro");
						menuEmprendimientos(emprendimiento);
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
					System.out.println("\nSe ha registrado exitosamente su emprendimiento");
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
			System.out.print("Presiona Enter para continuar...");
			lector.readLine();    
	  	} while (opcion != 5);
		lector.close();
	}
}