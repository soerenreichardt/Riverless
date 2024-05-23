package org.riverless.core.actions;

import org.riverless.core.map.Position;
import org.riverless.core.map.Troop;

import java.util.Optional;

public record TroopMovedAction(Troop troop, Position newPosition) implements Action {

    @Override
    public Optional<Action> visit(Visitor visitor) {
        return visitor.visitTroopMovedAction(this);
    }
}
