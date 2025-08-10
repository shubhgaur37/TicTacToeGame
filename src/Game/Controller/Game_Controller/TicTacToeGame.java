package Game.Controller.Game_Controller;

import Game.CommonEnums.Symbol;
import Game.Controller.BoardGames;
import Game.GameStateHandlers.GameState;
import Game.GameStateHandlers.Context.GameContext;
import Game.GameStateHandlers.Concrete_States.*;
import Game.PlayerStrategies.PlayerStrategy;
import Game.Utilities.*;

// Initialises the game board and players with their respective strategies
// Sets the current player to Player X by default(can be set to Player O as well)
public class TicTacToeGame implements BoardGames {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private GameContext gameContext;

    public TicTacToeGame(PlayerStrategy xStrategy, PlayerStrategy OStrategy, int rows, int columns)
    {
        board = new Board(rows, columns);
        playerX = new Player(Symbol.X,xStrategy);
        playerO = new Player(Symbol.O,OStrategy);
        currentPlayer = playerX;
        gameContext = new GameContext();
    }

    // Game Loop: Continues until the game state indicates that the game is over
    @Override
    public void play(){
        do{
            board.printBoard();

            Position move = currentPlayer.makeMove(board);
            board.makeMove(move,currentPlayer.getSymbol());

            // Check if the move caused a win
            board.checkGameState(gameContext);

            // Only switch player if game not over
            if (!gameContext.isGameOver()) {
                switchPlayer();
            }
            
        } while(!gameContext.isGameOver());

        board.printBoard(); // Show final board
        announceResult();
    }

    // Alternates the current player after every move
    // Ensures both players take turns
    private void switchPlayer(){
        currentPlayer = (currentPlayer == playerX)? playerO : playerX;
    }

    private void announceResult(){
        GameState state = gameContext.getCurrentState();
        if (state instanceof XWonState)
            System.out.println("Player X Wins!");
        else if (state instanceof OWonState)
            System.out.println("Player O Wins!");
        else
            System.out.println("It's a Draw!");

    }

}
