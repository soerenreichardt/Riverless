/*
 * Copyright (c) "Neo4j"
 * Neo4j Sweden AB [http://neo4j.com]
 * This file contains proprietary code that is only available via a commercial license from Neo4j.
 * For more information, see https://neo4j.com/contact-us/
 */
package org.riverless.core.troops;

import org.jetbrains.annotations.TestOnly;
import org.riverless.core.troops.abilities.Ability;
import org.riverless.core.actions.Action;
import org.riverless.core.actions.MoveAction;
import org.riverless.core.map.Direction;
import org.riverless.core.player.Team;
import org.riverless.core.troops.stats.Stats;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Troop {

    private final Set<Action> allowedActions;
    private final Team team;
    private final List<Ability> abilities;
    private final Stats stats;

    @TestOnly
    public Troop() {
        this(new Team("Test"), 100);
    }

    public Troop(Team team, int maxHealth) {
        this.stats = new Stats(maxHealth);
        this.team = team;
        this.allowedActions = new HashSet<>();
        this.abilities = new ArrayList<>();
    }

    public void grantMoveActionFromDirection(Direction direction) {
        grantAction(new MoveAction(this, direction));
    }

    public Set<Action> allowedActions() {
        return this.allowedActions;
    }

    public void grantAction(Action action) {
        allowedActions.add(action);
    }

    public void revokeAction(Action action) {
        allowedActions.remove(action);
    }

    public int health() {
        return stats.health();
    }

    public boolean isMoveable() {
        return stats.isMoveable();
    }

    public int damage() {
        return stats.damage();
    }

    public void receiveDamage(int damage) {
        stats.setHealth(stats.health()-damage);
    }

    public Team team() {
        return team;
    }

    public List<Ability> abilities() {
        return abilities;
    }
}
