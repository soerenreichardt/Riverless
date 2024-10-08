package org.riverless.core.troops.effects;


import org.riverless.core.GameContext;
import org.riverless.core.troops.Troop;

import java.util.EnumMap;
import java.util.Map;

public class Effects {
    private final Map<EffectType, Effect> effects;

    public Effects() {
        this.effects = new EnumMap<>(EffectType.class);
    }

    public void add(Effect effect) {
        effects.put(effect.getEffectType(), effect);
    }

    public void remove(EffectType type) {
       effects.remove(type);
    }

    public Effect get(EffectType type) {
        return effects.get(type);
    }

    public void update(int deltaTime, Troop troop, GameContext ctx) {
        effects.values().forEach(effect -> {
            if(!effect.update(troop, deltaTime, ctx)){
                effect.onEnd(troop, ctx);
                remove(effect.getEffectType());
            }
        });
    }

    public int size() {
        return effects.size();
    }
}
