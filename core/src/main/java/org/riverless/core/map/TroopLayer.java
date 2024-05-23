/*
 * Copyright (c) "Neo4j"
 * Neo4j Sweden AB [http://neo4j.com]
 * This file contains proprietary code that is only available via a commercial license from Neo4j.
 * For more information, see https://neo4j.com/contact-us/
 */
package org.riverless.core.map;

import java.util.Map;

public class TroopLayer {

    private final Map<Troop, Position> troopPositions;

    public TroopLayer(Map<Troop, Position> troopPositions) {
        this.troopPositions = troopPositions;
    }

    public Position troopPosition(Troop troop) {
        return troopPositions.get(troop);
    }

    public boolean moveTroop(Troop troop, Direction direction, int distance) {
        if (troopPositions.containsKey(troop)) {
            var position = troopPositions.get(troop);
            position.move(direction, distance);
            return true;
        }
        return false;
    }
}
