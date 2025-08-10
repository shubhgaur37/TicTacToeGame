package Game.GameStateHandlers.Concrete_States;

import Game.GameStateHandlers.GameState;
import Game.GameStateHandlers.Context.GameContext;

public class OTurnState implements GameState{

    @Override 
    public void next(GameContext context) {
        // Switch to XTurnState
        context.setState(new XTurnState());
    };

    @Override
    public boolean isGameOver(){
        return false;
    }
    
}