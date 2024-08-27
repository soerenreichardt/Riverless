package org.riverless.core.troops.abilities;

import org.riverless.core.GameContext;
import org.riverless.core.actions.Action;
import org.riverless.core.actions.MeleeAttackAction;
import org.riverless.core.map.Direction;
import org.riverless.core.map.GameMap;
import org.riverless.core.map.Position;
import org.riverless.core.troops.Troop;

import java.util.ArrayList;
import java.util.List;

public record MeleeAttackAbility() implements Ability {

    @Override
    public List<Action> computePossibleActions(Troop troop, GameContext ctx) {
        List<Action> actions = new ArrayList<>();
        var troopLayer = ctx.getResource(GameMap.class).troopLayer();
        troopLayer.troopPosition(troop).ifPresent(position -> {
            for (Direction adjacentDirection : troopLayer.calculatePossibleAdjacentDirections(position)) {
                var adjacentPosition = Position.adjacent(position, adjacentDirection);
                var adjacentTroop = troopLayer.troopAtPosition(adjacentPosition);
                if(adjacentTroop != null) {
                    actions.add(new MeleeAttackAction(troop, adjacentTroop));
                }
            }
        });
        return actions;
    }
}
