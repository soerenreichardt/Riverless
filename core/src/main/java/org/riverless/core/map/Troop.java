/*
 * Copyright (c) "Neo4j"
 * Neo4j Sweden AB [http://neo4j.com]
 * This file contains proprietary code that is only available via a commercial license from Neo4j.
 * For more information, see https://neo4j.com/contact-us/
 */
package org.riverless.core.map;

import org.riverless.core.actions.Action;

import java.util.HashSet;
import java.util.Set;

public class Troop {

    private final Set<Action> allowedActions;
    private Position pos;

    public Troop() {
        this.allowedActions = new HashSet<>();
    }
}
