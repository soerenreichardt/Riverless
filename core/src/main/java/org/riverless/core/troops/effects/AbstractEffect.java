package org.riverless.core.troops.effects;

import org.riverless.core.GameContext;
import org.riverless.core.troops.Troop;

public abstract class AbstractEffect implements Effect {

    protected EffectType effectType; // Common effect type
    private long startTime;

    public AbstractEffect(EffectType effectType) {
        this.effectType = effectType;
    }

    public final void apply(Troop troop, GameContext ctx) {
        startTime = System.currentTimeMillis();
        onStart(troop, ctx);
    }

    protected abstract void onStart(Troop troop, GameContext ctx);

    public long getStartTime() {
        return startTime;
    }

    public EffectType getEffectType() {
        return effectType;
    }


}
