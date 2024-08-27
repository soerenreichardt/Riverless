package org.riverless.core.actions;

import org.riverless.core.GameContext;
import org.riverless.core.troops.Troop;

public record MeleeAttackAction(Troop attacker, Troop defender) implements Action {

    @Override
    public void execute(GameContext ctx) {
        if (attacker.allowedActions().contains(this)) {
            defender.receiveDamage(attacker.damage());
        }
    }
}
