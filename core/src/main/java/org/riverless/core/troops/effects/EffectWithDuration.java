package org.riverless.core.troops.effects;

import org.riverless.core.GameContext;
import org.riverless.core.troops.Troop;

public abstract class EffectWithDuration extends AbstractEffect {

    private int remainingDuration;  // Duration in milliseconds

    public EffectWithDuration(int duration) {
        this.remainingDuration = duration;
    }

    @Override
    public final void update(Troop troop, int deltaTime, GameContext ctx) {
        onUpdate(troop, deltaTime, ctx);
        remainingDuration -= deltaTime;
        if (remainingDuration <= 0) {
            remove(troop, ctx);
        }
    }

    protected abstract void onUpdate(Troop troop, int deltaTime, GameContext ctx);

    public int getRemainingDuration() {
        return remainingDuration;
    }

    public void setRemainingDuration(int remainingDuration) {
        this.remainingDuration = remainingDuration;
    }
}
