package org.riverless.core.actions;

import org.riverless.core.map.Direction;

import java.util.Optional;

public abstract class ActionVisitorAdapter implements Action.Visitor {
    @Override
    public Optional<Action> visitRunAction(Action action, int distance, Direction direction) {
        return Optional.empty();
    }

    @Override
    public Optional<Action> visitTroopMovedAction(Action action) {
        return Optional.empty();
    }
}
