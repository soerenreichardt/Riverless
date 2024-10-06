package org.riverless.core.troops.effects.effects;

import org.riverless.core.GameContext;
import org.riverless.core.troops.Troop;
import org.riverless.core.troops.effects.EffectType;
import org.riverless.core.troops.effects.EffectWithDuration;

public class CurseEffect extends EffectWithDuration {

    private int damage;
    public CurseEffect(int duration, int damage) {
        super(duration);
        this.damage = damage;
        this.effectType = EffectType.CURSE;
    }

    @Override
    protected void onStart(Troop troop, GameContext ctx) {
        // do nothing
    }

    @Override
    public void onEnd(Troop troop, GameContext ctx) {
        troop.receiveDamage(damage);
    }

    @Override
    protected void onUpdate(Troop troop, int deltaTime, GameContext ctx) {
        // do nothing
    }
}
