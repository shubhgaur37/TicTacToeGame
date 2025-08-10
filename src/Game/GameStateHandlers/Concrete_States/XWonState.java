package Game.GameStateHandlers.Concrete_States;

import Game.GameStateHandlers.GameState;
import Game.GameStateHandlers.Context.GameContext;

public class XWonState implements GameState{

    @Override 
    public void next(GameContext context) {
        // Game Over, no next state
    };

    @Override
    public boolean isGameOver(){
        return true;
    }
    
}