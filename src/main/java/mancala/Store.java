package mancala;

import java.io.Serializable;

public class Store implements Serializable, Countable {

    private static final long serialVersionUID = 4814984957239260613L;

    private Player owner;
    private int numStones;

    /**
     * Constructor to initialize the Store.
     */
    public Store() {
        numStones = 0;
    }

    /**
     * Get the owner of the Store.
     *
     * @return The owner of the store
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * Set the owner of the Store.
     *
     * @param player The owner of the store
     */
    public void setOwner(final Player player) {
        owner = player;
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
     * Add a specified number of stones to the pit.
     *
     * @param amount The number of stones to add.
     */
    @Override
    public void addStones(final int amount) {
        numStones += amount;
    }

    /**
     * Add one stone to the object.
     */
    @Override
    public void addStone() {
        numStones++;
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