package mancala;

public class GameNotOverException extends Exception {

    private static final long serialVersionUID = -6386606498972578863L;

    /**
     * Constructor to initialize the exception.
     */
    public GameNotOverException() {
        super("The game is not over");
    }
}