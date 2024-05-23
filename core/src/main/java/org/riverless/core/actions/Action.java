package org.riverless.core.actions;

import org.riverless.core.map.Direction;
import org.riverless.core.map.Troop;

import java.util.Optional;

public interface Action {
    Troop troop();

    Optional<Action> visit(Visitor visitor);

    interface Visitor {
        Optional<Action> visitRunAction(Action action, int distance, Direction direction);
        Optional<Action> visitTroopMovedAction(Action action);
    }
}
