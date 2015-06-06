package mas.exceptions;

/**
 * This exception is thrown when system is trying to proceed message
 * with time lower than actual simulation time
 * 
 * @author Tomas
 *
 */
public class CausalityException extends Exception {

    public CausalityException(String message, Throwable cause) {
        super(message, cause);
    }

    public CausalityException(String message) {
        super(message);
    }

}
