/*
 * Copyright (c) "Neo4j"
 * Neo4j Sweden AB [http://neo4j.com]
 * This file contains proprietary code that is only available via a commercial license from Neo4j.
 * For more information, see https://neo4j.com/contact-us/
 */
package org.riverless.core.map;

import org.riverless.core.actions.Action;
import org.riverless.core.actions.MoveAction;

import java.util.HashSet;
import java.util.Set;

public class Troop {

    private final Set<Action> allowedActions;

    public Troop() {
        this.allowedActions = new HashSet<>();
    }

    public void grandMoveActionFromDirection(Direction direction) {
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
}
