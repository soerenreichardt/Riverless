package org.riverless.core.actions;

import org.riverless.core.GameContext;
import org.riverless.core.troops.Troop;

public record RangeAttackAction(Troop attacker, Troop defender) implements Action {

    @Override
    public void execute(GameContext ctx) {

    }
}
