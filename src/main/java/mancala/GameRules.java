package mancala;

import java.io.Serializable;

/**
 * Abstract class representing the rules of a Mancala game.
 * KalahRules and AyoRules will subclass this class.
 */
public abstract class GameRules implements Serializable {
    private static final long serialVersionUID = 1858605936242157489L;
    private MancalaDataStructure gameBoard;
    private int currentPlayer = 1; // Player number (1 or 2)

    /**
     * Constructor to initialize the game board.
     */
    public GameRules() {
        gameBoard = new MancalaDataStructure();
    }

    /**
     * Get the number of stones in a pit.
     *
     * @param pitNum The number of the pit.
     * @return The number of stones in the pit.
     */
    public int getNumStones(final int pitNum) {
        return gameBoard.getNumStones(pitNum);
    }

    /**
     * Get the game data structure.
     *
     * @return The MancalaDataStructure.
     */
    /* default */ MancalaDataStructure getDataStructure() {
        return gameBoard;
    }

    /**
     * Check if a side (player's pits) is empty.
     *
     * @param pitNum The number of a pit in the side.
     * @return True if the side is empty, false otherwise.
     */
    /* default */ boolean isSideEmpty(final int pitNum) {
        // This method can be implemented in the abstract class.
        if (pitNum >= 1 && pitNum <= 6) {
            return checkEmptyPlayerOne();
        } else {
            return checkEmptyPlayerTwo();
        }
    }

    /* default */ int gameOverClearBoardOne() {
        int playerOneCount = 0;

        for (int i = 1; i <= 6; i++) {
            playerOneCount += getNumStones(i);
        }
        return gameBoard.addToStore(1, playerOneCount);
    }

    /* default */ int gameOverClearBoardTwo() {
        int playerTwoCount = 0;   

        for (int i = 7; i <= 12; i++) {
            playerTwoCount += getNumStones(i);
        }
        return gameBoard.addToStore(2, playerTwoCount);   
    }

    private boolean checkEmptyPlayerOne() {
        for (int i = 1; i <= 6; i++) {
            if (getNumStones(i) > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean checkEmptyPlayerTwo() {
        for (int i = 7; i <= 12; i++) {
            if (getNumStones(i) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Set the current player.
     *
     * @param playerNum The player number (1 or 2).
     */
    public void setPlayer(final int playerNum) {
        currentPlayer = playerNum;
    }

    /* default */ int getPlayer() {
        return currentPlayer;
    }

    /**
     * Perform a move and return the number of stones added to the player's store.
     *
     * @param startPit  The starting pit for the move.
     * @param playerNum The player making the move.
     * @return The number of stones added to the player's store.
     * @throws InvalidMoveException If the move is invalid.
     */
    public abstract int moveStones(int startPit, int playerNum) throws InvalidMoveException;

    /**
     * Distribute stones from a pit and return the number distributed.
     *
     * @param startPit The starting pit for distribution.
     * @return The number of stones distributed.
     */
    /* default */ abstract int distributeStones(int startPit);

    /**
     * Capture stones from the opponent's pit and return the number captured.
     *
     * @param stoppingPoint The stopping point for capturing stones.
     * @return The number of stones captured.
     */
    /* default */ abstract int captureStones(int stoppingPoint);

    /**
     * Register two players and set their stores on the board.
     *
     * @param one The first player.
     * @param two The second player.
     */
    public void registerPlayers(final Player one, final Player two) {
        // this method can be implemented in the abstract class.


        /* make a new store in this method, set the owner
         then use the setStore(store,playerNum) method of the data structure*/

        final Store playerOneStore = new Store();
        one.setStore(playerOneStore);
        playerOneStore.setOwner(one);
        gameBoard.setStore(playerOneStore, 1);

        final Store playerTwoStore = new Store();
        two.setStore(playerTwoStore);
        playerTwoStore.setOwner(two);
        gameBoard.setStore(playerTwoStore, 2);
    }

    /**
     * Reset the game board by setting up pits and emptying stores.
     */
    public void resetBoard() {
        gameBoard.setUpPits();
        gameBoard.emptyStores();
    }

    /**
     * Get String representation of Game Rules.
     *
     * @return The string of the Game Rules
     */
    @Override
    public String toString() {
        // Implement toString() method logic here.
        final StringBuilder textBoard = new StringBuilder();
        for (int i = 12; i >= 7; i--) {
            textBoard.append(String.format("Pit %d: %d stones \t", i, getNumStones(i)));
        }
        textBoard.append("\n");
        for (int i = 1; i <= 6; i++) {
            textBoard.append(String.format("Pit %d: %d stones \t", i, getNumStones(i)));
        }
        textBoard.append("\n");
        return textBoard.toString();
    }
}
