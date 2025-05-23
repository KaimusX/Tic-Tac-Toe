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

        // Specify which cell
        JPanel boardContainerPanel = new JPanel(new GridLayout(3, 3));
        JPanel[][] boardCells = new JPanel[3][3];

        // Color alternating
        for (int row = 0; row < 3; row++) {
            for  (int col = 0; col < 3; col++) {
                JPanel boardCell = new JPanel(new GridBagLayout()); // GrdiBag ensures centering.
                boolean isWhite = (row + col) % 2 == 0;
                boardCell.setBackground(isWhite ? Color.WHITE : Color.GRAY);
                boardCells[row][col] = boardCell; // Save reference
                boardContainerPanel.add(boardCell);
            }
        }

        frame.add(boardContainerPanel, BorderLayout.CENTER);

        // Control Panel w/ dropdowns and buttons
        JPanel controlPanel = new JPanel();

        String[] indices = {"0", "1", "2"};
        JComboBox<String> rowSelector = new JComboBox<>(indices);
        JComboBox<String> colSelector = new JComboBox<>(indices);

        String[] pieces = {"X", "O"};
        JComboBox<String> pieceSelector = new JComboBox<>(pieces);

        JButton placePieceButton = new JButton("Place Piece");
        JButton clearButton = new JButton("Clear Board");

        // Add components to control panel
        controlPanel.add(new JLabel("Row:"));
        controlPanel.add(rowSelector);
        controlPanel.add(new JLabel("Column:"));
        controlPanel.add(colSelector);
        controlPanel.add(new JLabel("Piece Type:"));
        controlPanel.add(pieceSelector);
        controlPanel.add(placePieceButton);
        controlPanel.add(clearButton);

        frame.add(controlPanel,BorderLayout.SOUTH);

        // Listeners
        placePieceButton.addActionListener(e -> {
            int row = Integer.parseInt((String) rowSelector.getSelectedItem());
            int col = Integer.parseInt((String) colSelector.getSelectedItem());
            String selectedPiece = (String) pieceSelector.getSelectedItem();

            if (selectedPiece.equals("X")) {
                placeImage(boardCells, row, col, "images/x.png");
            } else if (selectedPiece.equals("O")) {
                placeImage(boardCells, row, col, "images/o.png");
            }
        });
        

        clearButton.addActionListener(e -> {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    boardCells[row][col].removeAll();
                    boardCells[row][col].revalidate();
                    boardCells[row][col].repaint();
                }
            }
        });
        

        frame.setVisible(true);
    }    

    // helper
    private static void placeImage(JPanel[][] boardCells, int row, int col, String imagePath) {
        boardCells[row][col].removeAll(); // Clear previous content
        
        // resize image
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel pieceLabel = new JLabel(scaledIcon);
        boardCells[row][col].add(pieceLabel);
        boardCells[row][col].revalidate();
        boardCells[row][col].repaint();
    }
    
}
