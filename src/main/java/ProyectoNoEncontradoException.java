/**
 * Excepcion personalizada, indica que no se encontro un proyecto.
 */
public class ProyectoNoEncontradoException extends Exception
{
    // Constructor
    /**
     * Crea excepcion sin mensaje.
     */
    public ProyectoNoEncontradoException()
    {
        super();
    }
    /**
     * Crea excepcion con mensaje
     * @param mensaje Mensaje de excepcion.
     */
    public ProyectoNoEncontradoException(String mensaje)
    {
        super(mensaje);
    }
}