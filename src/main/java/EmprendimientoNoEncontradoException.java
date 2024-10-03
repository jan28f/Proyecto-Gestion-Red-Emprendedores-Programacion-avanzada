/**
 * Excepcion personalizada, indica que no se encontro un emprendimiento.
 */
public class EmprendimientoNoEncontradoException extends Exception
{
    // Constructor
    /**
     * Crea excepcion sin mensaje.
     */
    public EmprendimientoNoEncontradoException()
    {
        super();
    }
    /**
     * Crea excepcion con mensaje.
     * @param mensaje Mensaje de excepcion.
     */
    public EmprendimientoNoEncontradoException(String mensaje)
    {
        super(mensaje);
    }
}