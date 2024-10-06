package org.riverless.core.troops.effects;

import org.riverless.core.GameContext;
import org.riverless.core.troops.Troop;

public interface Effect {
    void apply(Troop troop, GameContext ctx);
    void update(Troop troop, int deltaTime, GameContext ctx);
    void onEnd(Troop troop, GameContext ctx);
    EffectType getEffectType();
}
