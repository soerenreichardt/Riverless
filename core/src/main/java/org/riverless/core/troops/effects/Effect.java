package org.riverless.core.troops.effects;

import org.riverless.core.GameContext;
import org.riverless.core.troops.Troop;

public interface Effect {

    void apply(Troop troop, GameContext ctx);

    /**
     * Update the effect
     * @return false if the effect is over, true otherwise
     */
    boolean update(Troop troop, int deltaTime, GameContext ctx);

    void onEnd(Troop troop, GameContext ctx);

    EffectType getEffectType();
}
