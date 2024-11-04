package org.riverless.core.troops.abilities;

import org.riverless.core.GameContext;
import org.riverless.core.actions.Action;
import org.riverless.core.actions.RecruitAction;
import org.riverless.core.map.GameMap;
import org.riverless.core.map.Position;
import org.riverless.core.troops.Troop;

import java.util.ArrayList;
import java.util.List;

public record RecruitAbility() implements Ability {

    @Override
    public AbilityType type() {
        return AbilityType.RECRUIT;
    }

    @Override
    public List<Action> computePossibleActions(Troop troop, GameContext ctx) {
        Position position = ctx.getResource(GameMap.class).troopLayer().troopPosition(troop).orElseThrow();
        List<Action> actions = new ArrayList<>();
        //TODO: Implement the logic to compute the possible recruit actions
        //
        actions.add(new RecruitAction(troop));


        return actions;
    }
}
