package mancala;

public class NoSuchPlayerException extends Exception {
    private static final long serialVersionUID = -9048534461650095974L;

    /**
     * Constructor to initialize the exception.
     */
    public NoSuchPlayerException() {
        super("That player does not exist");
    }
}