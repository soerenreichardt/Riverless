/*
 * Copyright (c) "Neo4j"
 * Neo4j Sweden AB [http://neo4j.com]
 * This file contains proprietary code that is only available via a commercial license from Neo4j.
 * For more information, see https://neo4j.com/contact-us/
 */
package org.riverless.core.map;

import org.jetbrains.annotations.TestOnly;
import org.riverless.core.actions.Action;
import org.riverless.core.actions.MoveAction;
import org.riverless.core.player.Team;

import java.util.HashSet;
import java.util.Set;

public class Troop {

    private final Set<Action> allowedActions;
    private final Team team;
    private final int maxHealth;
    private int health;
    private int damage;

    @TestOnly
    public Troop() {
        this(new Team("Test"), 100);
    }

    public Troop(Team team, int maxHealth) {
        this.maxHealth = maxHealth;
        this.team = team;
        this.allowedActions = new HashSet<>();
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
        return health;
    }

    public int damage() {
        return damage;
    }

    public void receiveDamage(int damage) {
        health -= damage;
    }

    public Team team() {
        return team;
    }
}
