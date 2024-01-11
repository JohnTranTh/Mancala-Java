package mancala;

public class AyoRules extends GameRules {

    private static final long serialVersionUID = -8602877491265858928L;

    private final MancalaDataStructure board;
    
    /**
     * Constructor to initialize the game rules.
     */
    public AyoRules() {
        super();
        board = getDataStructure();
    }

    /**
     * Perform a move and return the number of stones added to the player's store.
     *
     * @param startPit  The starting pit for the move.
     * @param playerNum The player making the move.
     * @return The number of stones added to the player's store.
     * @throws InvalidMoveException If the move is invalid.
     */
    @Override
    public int moveStones(final int startPit, final int playerNum) throws InvalidMoveException {

        if (startPit < 1 || startPit > 12) {
            throw new InvalidMoveException();
        }
        
        if (board.getNumStones(startPit) == 0) {
            throw new InvalidMoveException();
        }

        if (startPit >= 1 && startPit <= 6 && playerNum != 1) {
            throw new InvalidMoveException();
        }

        if (startPit >= 7 && startPit <= 12 && playerNum != 2) {
            throw new InvalidMoveException();
        }

        final int oldStoreCount = board.getStoreCount(playerNum);

        distributeStones(startPit);

        if (playerValid(convertedPitPosition(), playerNum) && checkIfCapture()) {
            final int capturedStones = captureStones(convertedPitPosition());
            board.addToStore(playerNum, capturedStones);
        }

        switchCurrentPlayer(playerNum);

        return board.getStoreCount(playerNum) - oldStoreCount;
    }

    @Override
    /* default */ int distributeStones(final int startPit) {

        int stonesToMove = board.removeStones(startPit);
        board.setIterator(startPit, getPlayer(), true);
        Countable currentSpot = null;

        for (int i = 0; i < stonesToMove; i++) {
            currentSpot = board.next();
            currentSpot.addStone();
        }

        while (!checkStore() && currentSpot.getStoneCount() > 1) {
            final int newStart = convertedPitPosition();
            final int newStones = board.removeStones(newStart);
            for (int i = 0; i < newStones; i++) {
                currentSpot = board.next();
                currentSpot.addStone();
            }
            stonesToMove += newStones;
        }

        return stonesToMove;
    }

    @Override
    /* default */ int captureStones(final int stoppingPoint) {

        return board.removeStones(13 - stoppingPoint);

    }

    private void switchCurrentPlayer(final int playerNum) {
        if (playerNum == 1) {
            setPlayer(2);
        } else if (playerNum == 2) {
            setPlayer(1);
        }
    }

    private boolean checkStore() {
        if (getIteratorPos() == 6 || getIteratorPos() == 13) {
            return true;
        }
        return false;
    }

    private int getIteratorPos() {
        return board.getIteratorPos();
    }

    private int convertedPitPosition() {
        int pitPos = getIteratorPos();
        if (pitPos >= 0 && pitPos <= 5) {
            pitPos++;
        }
        return pitPos;
    }

    private boolean playerValid(final int pit, final int playerNum) {
        if (pit >= 1 && pit <= 6 && playerNum == 1) {
            return true;
        } else if (pit >= 7 && pit <= 12 && playerNum == 2) {
            return true;
        }
        return false;
    }

    private boolean checkIfCapture() {
        final int position = convertedPitPosition();
        if (board.getNumStones(position) == 1) {
            return true;
        }
        return false;
    }
}