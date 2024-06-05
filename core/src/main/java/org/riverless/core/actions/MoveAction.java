package org.riverless.core.actions;

import org.riverless.core.events.Event;
import org.riverless.core.map.Direction;
import org.riverless.core.map.Troop;

import java.util.Optional;

public record MoveAction(Troop troop, Direction direction) implements Action {

    @Override
    public Optional<Event> visit(Visitor visitor) {
        return visitor.visitMoveAction(this);
    }
}
