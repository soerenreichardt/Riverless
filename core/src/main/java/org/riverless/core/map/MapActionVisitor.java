package org.riverless.core.map;

import org.riverless.core.actions.ActionVisitorAdapter;
import org.riverless.core.actions.MoveAction;
import org.riverless.core.events.Event;

import java.util.Optional;

class MapActionVisitor extends ActionVisitorAdapter {
    private final GameMap map;

    MapActionVisitor(GameMap map) {
        this.map = map;
    }

    @Override
    public Optional<Event> visitRunAction(MoveAction action) {
        throw new UnsupportedOperationException();
    }
}
