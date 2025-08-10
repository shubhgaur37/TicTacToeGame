package Game.PlayerStrategies.Concrete_Player_Strategy;

import java.util.Scanner;

import Game.PlayerStrategies.PlayerStrategy;
import Game.Utilities.Board;
import Game.Utilities.Position;

public class HumanPlayerStrategy implements PlayerStrategy {
    private Scanner scanner; // to input positions
    private String playerName;

    public HumanPlayerStrategy(Scanner scanner, String playerName){
        this.scanner = scanner;
        this.playerName = playerName;
    }

    @Override
    public Position makeMove(Board board){
        while(true){
            System.out.printf("%s, Enter your move from (row[0-2],column[0-2]) in the same line separated by a space:",playerName);
            
            try{
                // Prompts the human player to enter their move
                int row = scanner.nextInt();
                int column = scanner.nextInt();

                Position move = new Position(row,column);

                // Validates the player input(invalid positions entered will throw an exception)
                // If the move is valid return the position
                if (board.isValidMove(move))
                    return move;
                
                // If the move is invalid, then try again
                System.out.println("Invalid Move!! Try Again");
                
            } catch(Exception e){
                System.out.println("Invalid Input!! Please enter row and column as numbers.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
    }
}
