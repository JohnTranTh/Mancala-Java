package mancala;

import java.io.Serializable;

public class UserProfile implements Serializable {

    private static final long serialVersionUID = 4867437317986459118L;

    private String playerName;
    private int kalahPlays;
    private int ayoPlays;
    private int kalahWins;
    private int ayoWins;

    /**
     * Constructor to initialize the User Profile.
     */
    public UserProfile() {
        playerName = "";
        kalahPlays = 0;
        ayoPlays = 0;
        kalahWins = 0;
        ayoWins = 0;
    }

    /* default */ void setName(final String name) {
        playerName = name;
    }

    /* default */ String getName() {
        return playerName;
    }

    /* default */ void addKalahPlays() {
        kalahPlays++;
    }

    /* default */ int getKalahPlays() {
        return kalahPlays;
    }
    
    /* default */ void addAyoPlays() {
        ayoPlays++;
    }

    /* default */ int getAyoPlays() {
        return ayoPlays;
    }

    /* default */ void addKalahWins() {
        kalahWins++;
    }

    /* default */ int getKalahWins() {
        return kalahWins;
    }

    /* default */ void addAyoWins() {
        ayoWins++;
    }

    /* default */ int getAyoWins() {
        return ayoWins;
    }
}