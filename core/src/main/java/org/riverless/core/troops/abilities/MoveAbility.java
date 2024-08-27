package org.riverless.core.troops.abilities;

import org.riverless.core.GameContext;
import org.riverless.core.actions.Action;
import org.riverless.core.actions.MoveAction;
import org.riverless.core.map.Direction;
import org.riverless.core.map.GameMap;
import org.riverless.core.troops.Troop;

import java.util.ArrayList;
import java.util.List;

public record MoveAbility() implements Ability {

    @Override
    public List<Action> computePossibleActions(Troop troop, GameContext ctx) {
        if(!troop.isMoveable()) {
            return List.of();
        }
        List<Action> actions = new ArrayList<>();
        var troopLayer = ctx.getResource(GameMap.class).troopLayer();
        troopLayer.troopPosition(troop).ifPresent(position -> {
            for (Direction adjacentDirection : troopLayer.calculatePossibleAdjacentDirections(position)) {
               actions.add(new MoveAction(troop, adjacentDirection));
            }
        });
        return actions;
    }
}
