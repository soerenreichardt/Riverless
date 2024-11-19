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
    public AbilityType type() {
        return AbilityType.MELEE_ATTACK;
    }

    @Override
    public List<Action> computePossibleActions(Troop troop, GameContext ctx) {
        List<Action> actions = new ArrayList<>();
        var troopLayer = ctx.getResource(GameMap.class).troopLayer();
            for (Direction adjacentDirection : troopLayer.calculatePossibleAdjacentDirections(troop.position())) {
                var adjacentPosition = Position.adjacent(troop.position(), adjacentDirection);
                var adjacentTroop = troopLayer.troopAtPosition(adjacentPosition);
                if (adjacentTroop != null) {
                    actions.add(new MeleeAttackAction(troop, adjacentTroop));
                }
            }
        return actions;
    }
}
