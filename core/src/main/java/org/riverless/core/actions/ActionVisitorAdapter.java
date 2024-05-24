package org.riverless.core.actions;

import java.util.Optional;

public abstract class ActionVisitorAdapter implements Action.Visitor {
    @Override
    public Optional<Action> visitRunAction(MoveAction moveAction) {
        return Optional.empty();
    }

    @Override
    public Optional<Action> visitTroopMovedAction(TroopMovedAction troopMovedAction) {
        return Optional.empty();
    }
}
