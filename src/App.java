// The main method serves as the entry point for the Tic-Tac-Toe game
// application. It initializes the player strategies and starts the game.

import java.util.Scanner;

import Game.Controller.Game_Controller.TicTacToeGame;
import Game.PlayerStrategies.PlayerStrategy;
import Game.PlayerStrategies.Concrete_Player_Strategy.HumanPlayerStrategy;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        PlayerStrategy playerXStrategy = new HumanPlayerStrategy(scanner,"Player X");
        PlayerStrategy playerOStrategy = new HumanPlayerStrategy(scanner,"Player O");
        TicTacToeGame game = new TicTacToeGame(playerXStrategy, playerOStrategy, 3, 3);
        game.play();
    }
}


/*
Key Strengths of this approach:
1. Simplicity: The design is kept minimal and straightforward, avoiding unnecessary complexity,
2. Clarity: Its easy to understand, making it accessible for developers to implement and maintain.
3. Efficiency: The implementation is direct and logical, ensuring smooth gameplay.
4. Separation of Concerns: Each component has a clear responsibility, enhancing modularity and ease of updates.
5. Extensibility: Support for different board sizes.
   - More Customization Options
   - Scalability for varied gameplay(can add AI player strategy in the future)
   - Enhanced Flexibility
 */
