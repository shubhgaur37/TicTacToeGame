package Game.GameStateHandlers;

import Game.GameStateHandlers.Context.GameContext;

// GameState Interface
public interface GameState {
    void next(GameContext context);
    boolean isGameOver();
}


