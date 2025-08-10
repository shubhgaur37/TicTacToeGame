package Game.GameStateHandlers.Concrete_States;

import Game.GameStateHandlers.GameState;
import Game.GameStateHandlers.Context.GameContext;

public class XTurnState implements GameState{

    @Override 
    public void next(GameContext context) {
        // Switch to OTurnState
        context.setState(new OTurnState());
    };

    @Override
    public boolean isGameOver(){
        return false;
    }
    
}
