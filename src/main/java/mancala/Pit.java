package mancala;

import java.io.Serializable;

public class Pit implements Serializable, Countable {

    private static final long serialVersionUID = 8394711489664049489L;

    private int numStones;

    /**
     * Constructor to initialize the Pit.
     */
    public Pit() {
        numStones = 0;
    }

    /**
     * Add one stone to the object.
     */
    @Override
    public void addStone() {
        numStones++;
    }

    /**
     * Add a specified number of stones to the pit.
     *
     * @param amount The number of stones to add.
     */
    @Override
    public void addStones(final int amount) {
        numStones += amount;
    }

    /**
     * Get the count of stones in the pit.
     *
     * @return The count of stones.
     */
    @Override
    public int getStoneCount() {
        return numStones;
    }
    
    /**
     * Remove stones from the object.
     *
     * @return The number of stones removed.
     */
    @Override
    public int removeStones() {
        final int stoneCount = this.getStoneCount();

        numStones = 0;
        return stoneCount;
    }

}