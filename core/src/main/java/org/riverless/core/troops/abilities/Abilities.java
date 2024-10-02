package org.riverless.core.troops.abilities;

import org.riverless.core.GameContext;
import org.riverless.core.actions.Action;
import org.riverless.core.troops.Troop;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

public class Abilities {
    private final Map<AbilityType, Ability> abilities;

    public Abilities() {
        this.abilities = new EnumMap<>(AbilityType.class);
    }

    public void add(Ability ability) {
        abilities.put(ability.type(), ability);
    }

    public <T extends Ability> T get(AbilityType type) {
        return (T) abilities.get(type);
    }

    public Stream<Action> computePossibleActions(Troop troop, GameContext ctx) {
        return abilities.values().stream()
                .flatMap(ability -> ability.computePossibleActions(troop, ctx).stream());
    }
}
