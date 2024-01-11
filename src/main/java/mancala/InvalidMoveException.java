package mancala;

public class InvalidMoveException extends Exception {
    private static final long serialVersionUID = 3724878338534103269L;

    /**
     * Constructor to initialize the exception.
     */
    public InvalidMoveException() {
        super("That is an invalid move");
    }

    public InvalidMoveException(final String message) {
        super(message);
    }
}