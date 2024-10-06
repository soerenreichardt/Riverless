package org.riverless.core.troops.effects.effects;

import org.riverless.core.GameContext;
import org.riverless.core.troops.Troop;
import org.riverless.core.troops.effects.EffectType;
import org.riverless.core.troops.effects.EffectWithDuration;

public class HealEffect extends EffectWithDuration {

    private final int healAmount;

    public HealEffect(int duration, int healAmount) {
        super(duration);
        this.healAmount = healAmount;
        this.effectType = EffectType.HEAL;
    }

    @Override
    protected void onUpdate(Troop troop, int deltaTime, GameContext ctx) {
        int heal = healAmount * deltaTime / 1000;
        troop.heal(heal);
    }

    @Override
    protected void onStart(Troop troop, GameContext ctx) {
       // do nothing
    }

    @Override
    public void onEnd(Troop troop, GameContext ctx) {
      // do nothing
    }
}
