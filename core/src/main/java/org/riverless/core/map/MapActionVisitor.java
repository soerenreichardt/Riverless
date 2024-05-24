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
        var troop = action.troop();
        map.troopLayer().moveTroop(troop, action.direction(), action.distance());
        return Optional.of(Event.TROOP_MOOVED);
    }
}
