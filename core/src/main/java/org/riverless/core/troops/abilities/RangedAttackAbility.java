package org.riverless.core.troops.abilities;

import org.riverless.core.GameContext;
import org.riverless.core.actions.Action;
import org.riverless.core.actions.RangeAttackAction;
import org.riverless.core.map.GameMap;
import org.riverless.core.map.Position;
import org.riverless.core.troops.Troop;

import java.util.ArrayList;
import java.util.List;

public record RangedAttackAbility(int range) implements Ability {

    @Override
    public AbilityType type() {
        return AbilityType.RANGED_ATTACK;
    }

    @Override
    public List<Action> computePossibleActions(Troop troop, GameContext ctx) {
        List<Action> actions = new ArrayList<>();
        var troopLayer = ctx.getResource(GameMap.class).troopLayer();
        troopLayer.troopPosition(troop).ifPresent(position -> {
            for(int i=-range; i<=range; i++) {
                for(int j=-range; j<=range; j++) {
                    if(i == 0 && j == 0) {
                        continue;
                    }
                    var adjacentPosition = new Position(position.x() + i, position.y() + j);
                    var adjacentTroop = troopLayer.troopAtPosition(adjacentPosition);
                    if(adjacentTroop != null) {
                        actions.add(new RangeAttackAction(troop, adjacentTroop));
                    }
                }
            }
        });
        return actions;
    }
}
