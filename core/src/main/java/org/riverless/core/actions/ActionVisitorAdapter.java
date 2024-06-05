package org.riverless.core.actions;

import org.riverless.core.events.Event;

import java.util.Optional;

public abstract class ActionVisitorAdapter implements Action.Visitor {
    @Override
    public Optional<Event> visitMoveAction(MoveAction moveAction) {
        return Optional.empty();
    }
}
