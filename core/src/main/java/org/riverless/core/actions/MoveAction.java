package org.riverless.core.actions;

import org.riverless.core.map.Direction;
import org.riverless.core.map.Troop;

import java.util.Optional;

public record MoveAction(Troop troop, int distance, Direction direction) implements Action {

    @Override
    public Optional<Action> visit(Visitor visitor) {
        return visitor.visitRunAction(this, distance, direction);
    }
}