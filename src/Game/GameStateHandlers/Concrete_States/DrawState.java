package Game.GameStateHandlers.Concrete_States;

import Game.GameStateHandlers.GameState;
import Game.GameStateHandlers.Context.GameContext;

public class DrawState implements GameState {

    @Override
    public void next(GameContext context) {
        // No next turn in a draw — game is over, so do nothing
    }

    @Override
    public boolean isGameOver() {
        return true; // Draw means game is over
    }
}