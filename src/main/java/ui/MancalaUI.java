package ui;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;

import mancala.MancalaGame;
import mancala.InvalidMoveException;


public class MancalaUI extends JFrame {

    private JPanel gameContainer;
    private JLabel storeOne;
    private JLabel storeTwo;
    private JMenuBar menuBar;
    private PositionAwareButton[] buttons;
    private MancalaGame game;

    public MancalaUI(String title) {
        super();
        basicSetUp(title);
        setupGameContainer();
        add(gameContainer, BorderLayout.CENTER);
        add(makeButtonPanel(), BorderLayout.EAST);
        makeMenu();
        setJMenuBar(menuBar);
        game = new MancalaGame();
        pack();
    }
    
    protected void basicSetUp(String title){
        this.setTitle(title);
        gameContainer = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

    }

    protected JPanel startupMessage() {
        JPanel temp = new JPanel();
        // Customize the message as desired
        temp.add(new JLabel("Welcome to Mancala!"));
        return temp;
    }

    protected JPanel storeText() {
        JPanel temp = new JPanel();
        // Customize the message as desired
        temp.add(new JLabel("Store"));
        return temp;
    }

    protected JPanel makeButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(makeMancalaButton());
        buttonPanel.add(makeKalahButton());
        buttonPanel.add(makeAyoButton());
        return buttonPanel;
    }

    protected JButton makeKalahButton() {
        JButton button = new JButton("Kalah");
        button.addActionListener(e -> newGame());
        return button;
    }

    protected JButton makeAyoButton() {
        JButton button = new JButton("Ayo");
        button.addActionListener(e -> newGameAyo());
        return button;
    }

    protected void newGame() {
        game.startNewGame(); // Start a new game
        updateView(); // Update the view to reflect the new game state
    }

    protected void newGameAyo() {
        changeRules(2);
        game.startNewGame(); // Start a new game
        updateView(); // Update the view to reflect the new game state
    }

    protected void changeRules(int ruleChange) {
        game.switchRules(ruleChange);
        updateView();
    }

    protected void updateView() {
        for (int i = 1; i <= 12; i++) {
            buttons[i-1].setText(String.format("%d", game.getNumStones(i)));
        }
    }

    protected JButton makeMancalaButton() {
        JButton button = new JButton("Mancala");
        button.addActionListener(e -> kalahDescription());
        return button;
    }

    protected void kalahDescription() {
        String message = "The game begins with one player picking up all of "
        + "the pieces in any one of the holes on their side. " 
        + "Moving counter-clockwise, the player deposits one stone" 
        + "in each hole until the stones run out.";
        JOptionPane.showMessageDialog(null,message);
    }

    protected JFileChooser makeFileChooser() {
        JFileChooser chooser = new JFileChooser();
        return chooser;
    }

    protected JPanel makeMancalaGrid(int wide, int tall) {
        JPanel panel = new JPanel();
        buttons = new PositionAwareButton[12];
        panel.setLayout(new GridLayout(wide, tall));
        for (int i = 12; i >= 7; i--) {
            buttons[i-1] = new PositionAwareButton();
            buttons[i-1].setPosition(i);
            panel.add(buttons[i-1]);
            buttons[i-1].addActionListener(e -> {
                makeMove(e);
                checkGameState();
                updateView();
            });
        }
        for (int i = 1; i <= 6; i++) {
            buttons[i-1] = new PositionAwareButton();
            buttons[i-1].setPosition(i);
            panel.add(buttons[i-1]);
            buttons[i-1].addActionListener(e -> {
                makeMove(e);
                checkGameState();
                updateView();
            });
        }
        return panel;
    }

    protected void makeMove(ActionEvent e) {
        PositionAwareButton clicked = (PositionAwareButton) (e.getSource());
        try {
            game.move(clicked.getPosition());            
        } catch (InvalidMoveException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    protected void checkGameState() {
        int selection = 0;
        JOptionPane gameOver = new JOptionPane();
        String congrats = "Well done! Do you want to play a new game?";
        String button = "Play Again?";
        if (game.isGameOver()) {
            updateView();
            selection = gameOver.showConfirmDialog(null, congrats,button, JOptionPane.YES_NO_OPTION);
            if (selection == JOptionPane.NO_OPTION) {
                System.exit(0);
            } else {
                newGame();
            }
        }
    }

    protected void makeMenu() {
        menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        // Customize the menu item label
        JMenuItem item = new JMenuItem("Save");
        item.addActionListener(e -> saveFile());
        
        menu.add(item);
        menuBar.add(menu);
    }

    protected void saveFile() {
        String filename = JOptionPane.showInputDialog("Please enter a filename");
        JFileChooser chooser = makeFileChooser();

        chooser.showSaveDialog(null);

    }

    protected void setupGameContainer(){
        gameContainer.add(startupMessage());
        gameContainer.add(storeText());
        gameContainer.add(storeText());
        gameContainer.add(makeMancalaGrid(2, 6));
    }

    public static void main(String[] args) {
        MancalaUI example = new MancalaUI("Mancala Games");
        example.setVisible(true);
    }
    
}