package katappa;

/**
 * Exception class to help handle various exceptions caused throughout the programme
 */
public class KatappaException extends Exception {
    /**
     * Constructs the KatappaException instance
     * @param message Error message
     */
    public KatappaException(String message) {
        super(message);
    }
}
