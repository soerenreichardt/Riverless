package org.riverless.core.actions;

import org.riverless.core.GameContext;
import org.riverless.core.troops.Troop;
import org.riverless.core.troops.battle.RangedBattle;

public record RangeAttackAction(Troop attacker, Troop defender) implements Action {

    @Override
    public void execute(GameContext ctx) {
        if (attacker.allowedActions().contains(this)) {
            RangedBattle rangedBattle = new RangedBattle(attacker, defender);
            rangedBattle.execute();
        }
    }
}
