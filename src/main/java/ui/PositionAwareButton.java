package ui;

import javax.swing.JButton;

/**
 * Represents a GUI button component that knows its position in a grid.
 */
public class PositionAwareButton extends JButton {
    private int position;

    /**
     * Constructs a new PositionAwareButton.
     */
    public PositionAwareButton() {
        super();
    }

    /**
     * Constructs a new PositionAwareButton with the specified text.
     *
     * @param val The text to display on the button.
     */
    public PositionAwareButton(String val) {
        super(val);
    }

    /**
     * Gets the position of the button in a grid.
     *
     * @return The position of the button.
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets the position of the button in a grid.
     *
     * @param val The position to set.
     */
    public void setPosition(int val) {
        position = val;
    }

}
