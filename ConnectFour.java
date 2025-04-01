
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConnectFour extends JFrame {
    private final String symbol1 = "X";
    private final String symbol2 = "O";
    private String displaySymbol = symbol2;
    private Cell[][] cells;
    private int rows = 6;
    private int columns = 7;
    private final int winningNum = 4;
    private boolean isWinner = false;

    public ConnectFour() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JPanel cellPanel = new JPanel();
        cellPanel.setLayout(new GridLayout(6,7,5,5));
        setTitle("Connect 4");

        cells = new Cell[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                cells[rows - i - 1][j] = new Cell(" ");
                cells[rows - i - 1][j].setName(String.format("Button%c%d", (char)('A'+ j), rows - i));
                cellPanel.add(cells[rows - i - 1][j]);
                cells[rows - i - 1][j].addActionListener(new CellListener());

            }
        }
        add(cellPanel, BorderLayout.CENTER);

        JButton resetButton = new JButton("Reset");
        resetButton.setName("ButtonReset");
        resetButton.addActionListener(e -> clearCells());
        resetButton.setBackground(Color.ORANGE);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(resetButton);
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    class CellListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Cell buttonClicked = (Cell) e.getSource();
            char currentColumn = buttonClicked.getName().charAt(6);
            Cell currentCell = getFreeCellOnColumn(currentColumn);
            if(currentCell != null && !isWinner) {
                currentCell.setText(alternateXO());
                checkWinner();
            }
        }
    }

    public void checkWinner() {
        checkHorizontally();
        checkVertically();
        checkSlashDiagonal();
        checkBackslashDiagonal();
    }

    public void checkHorizontally() {
        for(int i = 0; i < rows; i++) {
            ArrayList<Cell> cellList = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            for(int j = 0; j < columns; j++) {
                builder.append(cells[i][j].getText());
                cellList.add(cells[i][j]);
            }
            String textLine = builder.toString();
            changeWinningCellsColor(textLine, cellList);
        }
    }

    public void checkVertically() {
        for(int j = 0; j < columns; j++) {
            ArrayList<Cell> cellList = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < rows; i++) {
                builder.append(cells[i][j].getText());
                cellList.add(cells[i][j]);
            }
            String textLine = builder.toString();
            changeWinningCellsColor(textLine, cellList);
        }
    }

    public void checkSlashDiagonal() {
        for(int k = winningNum - 1; k < rows + columns - 1 - (winningNum - 1); k++) {
            ArrayList<Cell> cellList = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < rows; i++) {
                int j = k - i;
                if(j >= 0 && j < columns) {
                    builder.append(cells[i][j].getText());
                    cellList.add(cells[i][j]);
                }
            }
            String textLine = builder.toString();
            changeWinningCellsColor(textLine,cellList);
        }
    }

    public void checkBackslashDiagonal() {
        for(int k = winningNum - 1; k < rows + columns - 1 - (winningNum -1); k++) {
            ArrayList<Cell> cellList = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < rows; i++) {
                int j = columns - 1 - (k - i);
                if(j >= 0 && j < columns) {
                    builder.append(cells[i][j].getText());
                    cellList.add(cells[i][j]);
                }
            }
            String textLine = builder.toString();
            changeWinningCellsColor(textLine,cellList);
        }
    }

    public void changeWinningCellsColor(String textLine, ArrayList<Cell> cellList) {
        for(int index = 0; index < textLine.length() - 3; index++) {
            if(textLine.substring(index, index + 4).equals(symbol1.repeat(4)) || textLine.substring(index, index + 4).equals(symbol2.repeat(4))) {
                cellList.get(index).setBackground(Color.GREEN);
                cellList.get(index + 1).setBackground(Color.GREEN);
                cellList.get(index + 2).setBackground(Color.GREEN);
                cellList.get(index + 3).setBackground(Color.GREEN);
                isWinner = true;
                return;
            }
        }
    }

    public void clearCells() {
        for(Cell[] cellsRow : cells) {
            for(Cell cell : cellsRow) {
                cell.setText(" ");
                cell.setBackground(Color.BLUE);
            }
        }
        displaySymbol = symbol2; // start new game with "X" first
        isWinner = false;
    }

    public Cell getFreeCellOnColumn(char column) {
        int columnInt = column - 'A';
        for(int i = 0; i < 6; i++) {
            if(cells[i][columnInt].getText().equals(" ")) {
                return cells[i][columnInt];
            }
        }
        return null;
    }

    public String alternateXO() {
        if(displaySymbol.equals(symbol2)) {
            displaySymbol = symbol1;
        } else {
            displaySymbol = symbol2;
        }
        return displaySymbol;
    }
}