/*
 * Copyright (c) "Neo4j"
 * Neo4j Sweden AB [http://neo4j.com]
 * This file contains proprietary code that is only available via a commercial license from Neo4j.
 * For more information, see https://neo4j.com/contact-us/
 */
package org.riverless.core.troops;

import org.jetbrains.annotations.TestOnly;
import org.riverless.core.GameContext;
import org.riverless.core.GameObject;
import org.riverless.core.actions.Action;
import org.riverless.core.player.Team;
import org.riverless.core.troops.abilities.Abilities;
import org.riverless.core.troops.abilities.Ability;
import org.riverless.core.troops.effects.Effect;
import org.riverless.core.troops.effects.EffectType;
import org.riverless.core.troops.effects.Effects;
import org.riverless.core.troops.stats.Stats;

import java.util.HashSet;
import java.util.Set;

public class Troop extends GameObject {

    private final Set<Action> allowedActions;
    private final Team team;
    private final Abilities abilities;
    private final Stats stats;

    private final Effects effects;

    @TestOnly
    public Troop(int health) {
        this(new Team("Test"), health);
    }

    public Troop(Team team, int maxHealth) {
        this.stats = new Stats(maxHealth, true);
        this.team = team;
        this.allowedActions = new HashSet<>();
        this.abilities = new Abilities();
        this.effects = new Effects();
    }

    public Set<Action> allowedActions() {
        return this.allowedActions;
    }

    public void grantAction(Action action) {
        allowedActions.add(action);
    }

    public float health() {
        return stats.health();
    }

    public boolean isMoveable() {
        return stats.isMovable();
    }

    public float damage() {
        return stats.damage();
    }

    public void receiveDamage(float damage) {
        stats.setHealth(stats.health()-damage);
    }

    public void heal(float healAmount) {
        stats.setHealth(stats.health()+healAmount);
    }

    public Team team() {
        return team;
    }

    public void updatePossibleActions(GameContext ctx) {
        allowedActions.clear();
        abilities.computePossibleActions(this, ctx).forEach(allowedActions::add);
    }

    public void addAbility(Ability ability) {
        abilities.addAbility(ability);
    }


    //@Override

    public void addEffect(Effect effect) {
        effects.add(effect);
        effect.apply(this, context());
    }
    public void update(int deltaTime) {
        effects.update(deltaTime, this, context());
    }

    public void removeEffect(EffectType type) {
        Effect effect = effects.get(type);
        effect.onEnd(this, context());
        effects.remove(type);
    }

    public Effects effects() {
        return effects;
    }


}
