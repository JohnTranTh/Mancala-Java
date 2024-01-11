package mancala;

public class PitNotFoundException extends Exception {

    private static final long serialVersionUID = -7493299591901498662L;

    /**
     * Constructor to initialize the exception.
     */ 
    public PitNotFoundException() {
        super("That pit does not exist");
    }
}