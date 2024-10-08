package org.riverless.core.troops.effects.effects;

import org.riverless.core.GameContext;
import org.riverless.core.troops.Troop;
import org.riverless.core.troops.effects.EffectType;
import org.riverless.core.troops.effects.EffectWithDuration;

public class HealEffect extends EffectWithDuration {

    private final int healAmount;

    public HealEffect(int duration, int healAmount) {
        super(EffectType.HEAL,duration);
        this.healAmount = healAmount;
    }

    @Override
    protected void onStart(Troop troop, GameContext ctx) {
        // do nothing
    }

    @Override
    protected void onUpdate(Troop troop, int deltaTime, GameContext ctx) {
        int heal = healAmount * deltaTime / 1000;
        troop.heal(heal);
    }

    @Override
    public void onEnd(Troop troop, GameContext ctx) {
      // do nothing
    }
}
