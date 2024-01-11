package mancala;

import java.io.Serializable;

public class MancalaGame implements Serializable {
    private static final long serialVersionUID = 8111764472913212176L;

    private GameRules currentBoard;
    private Player currentPlayer;
    private Player player1;
    private Player player2;
    private boolean gameOver;

    /**
     * Constructor to initialize the Game.
     */
    public MancalaGame() {
        currentBoard = new KalahRules();
        gameOver = false;
        player1 = new Player();
        player2 = new Player();
        setPlayers(player1, player2);
    }

    /**
     * Switch between Kalah and Ayo rulesets.
     */
    public void switchRules(final int choice) {
        if (choice == 1) {
            currentBoard = new KalahRules();
            setPlayers(player1, player2);
        } else if (choice == 2) {
            currentBoard = new AyoRules();
            setPlayers(player1, player2);
        }
    }

    /**
     * Get the board of the game.
     *
     * @return The board of the game
     */
    public GameRules getBoard() {
        return currentBoard;
    }

    /**
     * Get the current player of the game.
     *
     * @return The current player of the game
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Get the number of stones in a pit.
     *
     * @param pitNum The pit number
     * @return The number of stones in a pit
     */
    public int getNumStones(final int pitNum) {
        return currentBoard.getNumStones(pitNum);
    }

    /**
     * Get the number of stones in a player's store.
     *
     * @param player The player
     * @return The number of stones in the player's store
     */
    public int getStoreCount(final Player player) {
        return player.getStoreCount();
    }

    /**
     * Get the winning player.
     *
     * @return The winning player, null if tie
     */
    public Player getWinner() {

        final int playerOneCount = currentBoard.gameOverClearBoardOne();
        final int playerTwoCount = currentBoard.gameOverClearBoardTwo();

        if (playerOneCount > playerTwoCount) {
            return player1;
        } else if (playerTwoCount > playerOneCount) {
            return player2;
        }

        return null;
    }

    /**
     * Check if the game is over.
     *
     * @return True if the game is over, false otherwise
     */
    public boolean isGameOver() {
        gameOver = currentBoard.isSideEmpty(1);
        if (gameOver) {
            return gameOver;
        }
        gameOver = currentBoard.isSideEmpty(7);
        return gameOver;
    }

    /**
     * Perform a move and return the number of stones left on the player's side of the board.
     *
     * @param startPit  The starting pit for the move.
     * @return The number of stones left on the player's side of the board.
     * @throws InvalidMoveException If the move is invalid.
     */
    public int move(final int startPit) throws InvalidMoveException {

        if (currentBoard.getNumStones(startPit) == 0) {
            throw new InvalidMoveException();
        }

        final int playerNum = currentBoard.getPlayer();

        if (startPit >= 1 && startPit <= 6 && playerNum != 1) {
            throw new InvalidMoveException();
        }

        if (startPit >= 7 && startPit <= 12 && playerNum != 2) {
            throw new InvalidMoveException();
        }

        currentBoard.moveStones(startPit, playerNum);

        return stonesRemain(playerNum);
    }

    private int stonesRemain(final int playerNum) {
        int stonesRemaining = 0;
        if (playerNum == 1) {
            for (int i = 1; i <= 6; i++) {
                stonesRemaining += currentBoard.getNumStones(i);
            }
            return stonesRemaining;
        } else {
            for (int i = 7; i <= 12; i++) {
                stonesRemaining += currentBoard.getNumStones(i);
            }
            return stonesRemaining;
        }
    }

    /**
     * Set the board of the game.
     *
     * @param theBoard The board of the game
     */
    public void setBoard(final GameRules theBoard) {
        currentBoard = theBoard;
    }

    /**
     * Set the current player of the game.
     *
     * @param player The player of the game
     */
    public void setCurrentPlayer(final Player player) {
        currentPlayer = player;
    }

    /**
     * Set two players and set their stores on the board.
     *
     * @param one The first player.
     * @param two The second player.
     */
    public void setPlayers(final Player onePlayer, final Player twoPlayer) {
        setCurrentPlayer(onePlayer);
        currentBoard.registerPlayers(onePlayer, twoPlayer);
    }

    /**
     * Start a new game.
     */
    public void startNewGame() {
        currentBoard.resetBoard();
    }

    /**
     * Get String representation of Game.
     *
     * @return The string of the Game
     */
    @Override 
    public String toString() {
        return currentBoard.toString();
    }
}