package Game.PlayerStrategies;

import Game.Utilities.Board;
import Game.Utilities.Position;

public interface PlayerStrategy {
    Position makeMove(Board board);   
    
}