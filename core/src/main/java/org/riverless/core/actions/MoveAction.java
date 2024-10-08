package org.riverless.core.actions;

import org.riverless.core.GameContext;
import org.riverless.core.map.Direction;
import org.riverless.core.map.GameMap;
import org.riverless.core.troops.Troop;

public record MoveAction(Troop troop, Direction direction) implements Action {

    @Override
    public void execute(GameContext ctx) {
        ctx
            .getResource(GameMap.class)
            .troopLayer()
            .moveTroop(troop, direction);
    }
}
