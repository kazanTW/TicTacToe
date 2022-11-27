// Gaming window object
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener {
    private final JLabel statusLine;      // Status line to record turn
    private int playerNow;
    private final String[] sign = {"O", "X"};
    private int gameStatus;
    private final JButton[] buttons;

    public Window() {
        // Construct with title
        super("Tic Tac Toe");

        // Set window size and location
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(617, 657);
        this.setLocation((int)((dimension.getWidth() - this.getHeight()) / 2) , (int)((dimension.getHeight() - this.getHeight()) / 2));

        // Set other attributes
        this.setBackground(Color.BLACK);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Adding board and buttons
        JPanel board = new JPanel();
        board.setLayout(new GridLayout(3, 3));
        this.buttons = new JButton[9];
        Font buttonFont = new Font(null, Font.BOLD, 300 * 5 / 16);
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].addActionListener(this);
            buttons[i].setActionCommand("" + i);
            buttons[i].setFont(buttonFont);
            board.add(buttons[i]);
        }
        add(board, BorderLayout.CENTER);

        // Add status line
        this.gameStatus = 0;
        this.playerNow = 0;
        this.statusLine = new JLabel("It's " + sign[playerNow] + "'s turn.");
        add(this.statusLine, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent event) {
        if (gameStatus > 0) {       // There's a result, start a new game
            gameStatus = 0;
            playerNow = 0;
            statusLine.setText("It's " + sign[playerNow] + "'s turn.");
            getContentPane().setBackground(null);
            for (int i = 0; i < 9; i++) {
                buttons[i].setText("");
            }
            return;
        }

        int index = Integer.parseInt(event.getActionCommand());
        if (!(buttons[index].getText().equals(""))) return;
        buttons[index].setText(sign[playerNow]);

        check();
        if (gameStatus == 1) {
            JOptionPane.showMessageDialog(new JFrame(), sign[playerNow] + " wins.");
            statusLine.setText("Press any button to restart.");
            getContentPane().setBackground(Color.MAGENTA);
        } else if (gameStatus == 2) {
            JOptionPane.showMessageDialog(new JFrame(), "Draw.");
            statusLine.setText("Press any button to restart.");
            getContentPane().setBackground(Color.MAGENTA);
        } else {
            playerNow = 1 - playerNow;
            statusLine.setText("It's " + sign[playerNow] + "'s turn.");
        }
    }

    public void check() {
        int[][] checkSet = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        for (int[] ints : checkSet) {
            if (!(buttons[ints[0]].getText().equals("")) &&
                    buttons[ints[0]].getText().equals(buttons[ints[1]].getText()) &&
                    buttons[ints[0]].getText().equals(buttons[ints[2]].getText())) {
                gameStatus = 1;
                return;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equals("")) return;
        }
        gameStatus = 2;
    }
}
