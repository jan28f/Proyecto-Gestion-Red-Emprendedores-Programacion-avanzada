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
      while (opcion != 0)
        {
          
          System.out.println("Menu Principal\n");
          System.out.println("Selecciona una opcion");
          System.out.println("1) Registrar Emprendedor");
          System.out.println("2) Mostrar Informacion de un emprendedor");
          System.out.println("0) Salir del programa");
          String numero = lector.readLine();
          opcion = Integer.parseInt(numero);
          switch(opcion)
            {
                case 1:
                  registrarEmprendedor();
                  break;
                case 2:
                  mostrarInfoEmprendedor();
                  break;
                case 0:
                  System.out.println("Saliendo del programa...");
                  break;
                default:
                  System.out.println("Opcion incorrecta");
                  System.out.println("Marque otra opcion");
                  break;
            }    
        }  
  }  
}
