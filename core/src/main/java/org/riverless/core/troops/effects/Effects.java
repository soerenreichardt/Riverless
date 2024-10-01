package org.riverless.core.troops.effects;



import java.util.EnumMap;
import java.util.Map;



public class Effects {
    private final Map<EffectType, Effect> effects;

    public Effects() {
        this.effects = new EnumMap<>(EffectType.class);
    }

    public void add(Effect effect) {
        effects.put(effect.type(), effect);
    }

    public void remove(Effect effect) {
        effects.remove(effect.type());
    }
}
