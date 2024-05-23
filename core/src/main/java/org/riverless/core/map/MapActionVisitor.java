package org.riverless.core.map;

import org.riverless.core.actions.Action;
import org.riverless.core.actions.ActionVisitorAdapter;
import org.riverless.core.actions.TroopMovedAction;

import java.util.Optional;

class MapActionVisitor extends ActionVisitorAdapter {
    private final GameMap map;

    MapActionVisitor(GameMap map) {
        this.map = map;
    }

    @Override
    public Optional<Action> visitRunAction(Action action, int distance, Direction direction) {
        var troop = action.troop();
        map.troopLayer().moveTroop(troop, direction, distance);
        return Optional.of(new TroopMovedAction(troop, map.troopLayer().troopPosition(troop)));
    }
}
