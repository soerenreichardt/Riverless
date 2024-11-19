package org.riverless.core.troops.abilities;

import org.riverless.core.GameContext;
import org.riverless.core.actions.Action;
import org.riverless.core.actions.MoveAction;
import org.riverless.core.actions.RecruitActionParam;
import org.riverless.core.actions.RecuitAction;
import org.riverless.core.map.Direction;
import org.riverless.core.map.GameMap;
import org.riverless.core.map.Position;
import org.riverless.core.troops.Troop;
import org.riverless.core.troops.units.UnitType;

import java.util.ArrayList;
import java.util.List;

public record RecruitAbility() implements Ability {

    @Override
    public AbilityType type() {
        return AbilityType.RECRUIT;
    }

    @Override
    public List<Action> computePossibleActions(Troop troop, GameContext ctx) {
        Position position = troop.position();
        //TODO: Implement the logic to compute the possible recruit actions
        //
        var recuitAction = new RecuitAction(troop, new RecruitActionParam());
        return List.of(recuitAction);
    }
}
