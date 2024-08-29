/*
 * Copyright (c) "Neo4j"
 * Neo4j Sweden AB [http://neo4j.com]
 * This file contains proprietary code that is only available via a commercial license from Neo4j.
 * For more information, see https://neo4j.com/contact-us/
 */
package org.riverless.core.map;

import org.riverless.core.GameContext;
import org.riverless.core.actions.MeleeAttackAction;
import org.riverless.core.actions.MoveAction;
import org.riverless.core.troops.Troop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TroopLayer {

    private final Troop[][] troopPositions;
    private final int width;
    private final int height;

    public TroopLayer(int width, int height) {
        this.width = width;
        this.height = height;
        this.troopPositions = new Troop[height][width];
    }

    public boolean addTroop(Troop troop, Position position) {
        if (!positionIsEmpty(position)) {
            return false;
        }
        troopPositions[position.y()][position.x()] = troop;
        return true;
    }

    public Optional<Position> troopPosition(Troop troop) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (troopPositions[y][x] == troop) {
                    return Optional.of(new Position(x, y));
                }
            }
        }
        return Optional.empty();
    }

    public void moveTroop(Troop troop, Direction direction) {
        troopPosition(troop).ifPresent(position -> {
            if (positionIsEmpty(Position.adjacent(position, direction))) {
                troopPositions[position.y()][position.x()] = null;
                position.move(direction, 1);
                troopPositions[position.y()][position.x()] = troop;
            }
        });
    }

    public void updateTroopActions(GameContext ctx) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                var troop = troopAtPosition(new Position(x, y));
                if (troop != null) {
                    troop.updatePossibleActions(ctx);
                }
            }
        }
    }

    public boolean positionIsEmpty(Position position) {
        return positionIsEmpty(position.x(), position.y());
    }

    private boolean positionIsEmpty(int x, int y) {
        return troopPositions[y][x] == null;
    }

    public Troop troopAtPosition(Position position) {
        return troopPositions[position.y()][position.x()];
    }

    public List<Direction> calculatePossibleAdjacentDirections(Position position) {
        var possibleDirections = new ArrayList<>(List.of(Direction.LEFT, Direction.RIGHT, Direction.UP, Direction.DOWN));

        if (position.x() == 0) {
            possibleDirections.remove(Direction.LEFT);
        }
        if (position.x() == width - 1) {
            possibleDirections.remove(Direction.RIGHT);
        }
        if (position.y() == 0) {
            possibleDirections.remove(Direction.UP);
        }
        if (position.y() == height - 1) {
            possibleDirections.remove(Direction.DOWN);
        }

        return possibleDirections;
    }
}
