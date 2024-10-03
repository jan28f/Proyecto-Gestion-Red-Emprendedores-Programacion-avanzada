import java.io.IOException;

/**
 * Clase principal que inicia la aplicacion y su menu principal.
 */
public class Main
{
    /**
     * Metodo que ejecuta la aplicacion.
     * @param args Lista de argumentos de la linea de comandos.
     * @throws IOException Si ocorre un error de entra/salida.
     */
    public static void main(String[] args) throws IOException
    {
        Menu app = new Menu();
        app.menuPrincipal();
    }
}
