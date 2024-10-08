package org.riverless.core.troops.effects;

import org.riverless.core.GameContext;
import org.riverless.core.troops.Troop;

public abstract class EffectWithDuration extends AbstractEffect {

    private int remainingDuration;

    public EffectWithDuration(EffectType type,int duration) {
        super(type);
        this.remainingDuration = duration;
    }

    @Override
    public final boolean update(Troop troop, int deltaTime, GameContext ctx) {
        onUpdate(troop, deltaTime, ctx);
        remainingDuration -= deltaTime;
        return remainingDuration > 0;
    }

    protected abstract void onUpdate(Troop troop, int deltaTime, GameContext ctx);

    public int getRemainingDuration() {
        return remainingDuration;
    }

    public void setRemainingDuration(int remainingDuration) {
        this.remainingDuration = remainingDuration;
    }
}
