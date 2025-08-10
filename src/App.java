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



