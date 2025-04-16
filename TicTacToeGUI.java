import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TicTacToeGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // Create the JFrame
        JFrame frame = new JFrame("Tic Tac Toe");
        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the size of the window (width, height)
        frame.setSize(400, 400);
        // Make the frame visible
        frame.setVisible(true);
    }
}
