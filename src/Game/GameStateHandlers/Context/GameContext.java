package Game.GameStateHandlers.Context;

import Game.GameStateHandlers.GameState;
import Game.GameStateHandlers.Concrete_States.*;

// GameContext class
public class GameContext {
    private GameState currentState;

    // default behavior: Start with X turn
    public GameContext(){
        currentState = new XTurnState();
    }

    public void setState(GameState state){
        this.currentState = state;
    }

    public void next(){
        currentState.next(this);
    }

    public boolean isGameOver(){
        return currentState.isGameOver();
    }

    public GameState getCurrentState(){
        return currentState;
    }
}
