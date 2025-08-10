package Game.Utilities;

import Game.CommonEnums.Symbol;
import Game.GameStateHandlers.Concrete_States.DrawState;
import Game.GameStateHandlers.Concrete_States.OWonState;
import Game.GameStateHandlers.Concrete_States.XWonState;
import Game.GameStateHandlers.Context.GameContext;

// BOARD REPRESENTATION
public class Board {
    private final int rows;
    private final int columns;
    private Symbol[][] grid;

    public Board(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        grid = new Symbol[rows][columns];


        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++){
                grid[i][j] = Symbol.EMPTY;
            }
    }

    // Function used in strategies to check if a move is valid
    public boolean isValidMove(Position pos){
        return pos.row >= 0 && pos.row < rows && pos.col>=0 && pos.col< columns && 
        grid[pos.row][pos.col] == Symbol.EMPTY;
    }

    // Allows Player to make their moves
    public void makeMove(Position pos, Symbol symbol){
        grid[pos.row][pos.col] = symbol;
    }

    // Determines the current state of the game by checking rows, columns, diagonals for winning condition
    public void checkGameState(GameContext context) {

        // --- Check rows ---
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] != Symbol.EMPTY && isWinningLine(grid[i])) {
                if (grid[i][0] == Symbol.X) {
                    context.setState(new XWonState());
                } else {
                    context.setState(new OWonState());
                }
                return;
            }
        }

        // --- Check columns ---
        for (int i = 0; i < columns; i++) {
            Symbol[] column = new Symbol[rows];
            for (int j = 0; j < rows; j++) {
                column[j] = grid[j][i];
            }
            if (column[0] != Symbol.EMPTY && isWinningLine(column)) {
                if (column[0] == Symbol.X) {
                    context.setState(new XWonState());
                } else {
                    context.setState(new OWonState());
                }
                return;
            }
        }

        // --- Check both diagonals in a single loop ---
        Symbol[] diagonal1 = new Symbol[Math.min(rows, columns)];
        Symbol[] diagonal2 = new Symbol[Math.min(rows, columns)];
        for (int i = 0; i < diagonal1.length; i++) {
            diagonal1[i] = grid[i][i]; // top-left to bottom-right
            diagonal2[i] = grid[i][columns - 1 - i]; // top-right to bottom-left
        }

        if (diagonal1[0] != Symbol.EMPTY && isWinningLine(diagonal1)) {
            if (diagonal1[0] == Symbol.X) {
                context.setState(new XWonState());
            } else {
                context.setState(new OWonState());
            }
            return;
        }

        if (diagonal2[0] != Symbol.EMPTY && isWinningLine(diagonal2)) {
            if (diagonal2[0] == Symbol.X) {
                context.setState(new XWonState());
            } else {
                context.setState(new OWonState());
            }
            return;
        }

        // --- Check for draw ---
        boolean boardFull = true;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (grid[r][c] == Symbol.EMPTY) {
                    boardFull = false;
                    break;
                }
            }
            if (!boardFull) break;
        }

        if (boardFull) {
            context.setState(new DrawState()); // Game over with a draw
            return;
        }

        // --- No win and no draw → next turn ---
        context.next();
    }

    // function checking if any particular lane is fully filled with same symbols
    private boolean isWinningLine(Symbol[] line) {
        Symbol first = line[0];
        // if any symbol differs then return false, that means cannot win through the line(row,col,diagonal)
        for (Symbol s : line) {
            if (s != first) {
                return false;
            }
        }
        return true;
    }

    // Fxn to print current state of the game
    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Symbol symbol = grid[i][j];
                switch (symbol) {
                    case X:
                        System.out.print(" X ");
                        break;
                    case O:
                        System.out.print(" O ");
                        break;
                    case EMPTY:
                    default:
                        System.out.print(" . ");
                }

                if (j < columns - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < rows - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }


}
