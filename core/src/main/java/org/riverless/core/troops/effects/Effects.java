package org.riverless.core.troops.effects;


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
}
