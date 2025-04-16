import javax.swing.*;
import java.awt.*;

public class TicTacToeGUI {
    public static void main(String[] args) {
        // Executes runnable on AWT dispath thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        // Initialize frame
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        JPanel boardContainerPanel = new JPanel(new GridLayout(3, 3));

        // Color alternating
        for (int row = 0; row < 3; row++) {
            for  (int col = 0; col < 3; col++) {
                JPanel boardCell = new JPanel();
                boolean isWhite = (row + col) % 2 == 0;
                boardCell.setBackground(isWhite ? Color.WHITE : Color.GRAY);
                boardContainerPanel.add(boardCell);
            }
        }

        frame.add(boardContainerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }    
}
