package mancala;

import java.io.Serializable;

public class Player implements Serializable {

    private static final long serialVersionUID = -1608636201602225798L;

    private String playerName;
    private Store playerStore;
    private UserProfile playerProfile;

    /**
     * Constructor to initialize the Player.
     */
    public Player() {
        playerProfile = new UserProfile();
        playerName = playerProfile.getName();
    }

    /**
     * Constructor to initialize the Player with a name.
     *
     * @param name The name of the player
     */
    public Player(final String name) {
        playerName = name;
        playerProfile = new UserProfile();
        playerProfile.setName(name);
    }

    /**
     * Get the name of the Player.
     *
     * @return The name of the Player
     */
    public String getName() {
        return playerName;
    }

    /**
     * Get the store of the Player.
     *
     * @return The store of the Player
     */
    public Store getStore() {
        return playerStore;
    }

    /**
     * Get the number of stones in the store of the Player.
     *
     * @return The number of stones in the store of the Player
     */
    public int getStoreCount() {
        return playerStore.getStoneCount();
    }

    /**
     * Set the name of the Player.
     *
     * @param name The name of the Player
     */
    public void setName(final String name) {
        playerName = name;
        playerProfile.setName(name);
    }

    /**
     * Set the store of the Player.
     *
     * @param name The store of the Player
     */
    public void setStore(final Store store) {
        playerStore = store;
    }

    /**
     * Set the user profile of the Player.
     *
     * @param profile The user profile of the Player
     */
    public void setUserProfile(UserProfile profile) {
        playerProfile = profile;
        setName(profile.getName());
    }

    /**
     * Get String representation of Player.
     *
     * @return The string of the Player
     */
    @Override 
    public String toString() {
        return String.format("Player %s\n", getName());
    }
}