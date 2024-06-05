package org.riverless.core.actions;

import org.riverless.core.events.Event;
import org.riverless.core.map.Troop;

import java.util.Optional;

public interface Action {
    Troop troop();

    Optional<Event> visit(Visitor visitor);

    interface Visitor {
        Optional<Event> visitMoveAction(MoveAction action);
    }
}
