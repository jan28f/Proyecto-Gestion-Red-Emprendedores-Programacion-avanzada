import java.util.*;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main{

public static void main(String [] args) throws IOException
{  
  Main app = new Main();
  app.menuPrincipal();
}

public void menuPrincipal() throws IOException
{
  HashMap<String, Emprendimiento> emprendimientos = new HashMap<String, Emprendimiento>();
  HashMap<String, Proyecto> proyectos = new HashMap<String, Proyecto>();

  BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
  int opcion = -1;
  do
  {
    System.out.println("============================");
    System.out.println("     Menu Principal\n");
    System.out.println("============================");
    System.out.println("1) Buscar emprendimiento");
    System.out.println("2) Buscar proyecto");
    System.out.println("3) Registrar emprendimiento");
    System.out.println("4) Registrar proyecto");
    System.out.println("5) Salir del programa");

    String numero = lector.readLine();
    opcion = Integer.parseInt(numero);
    switch(opcion)
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
        System.out.println("Saliendo del programa...");
        break;
      default:
        System.out.println("Opcion invalida");
        System.out.println("Marque otra opcion");
        break;
      }    
    } while (opcion != 5);
  }  
}