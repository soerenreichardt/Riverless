/*
 * Copyright (c) "Neo4j"
 * Neo4j Sweden AB [http://neo4j.com]
 * This file contains proprietary code that is only available via a commercial license from Neo4j.
 * For more information, see https://neo4j.com/contact-us/
 */
package org.riverless.core.map;

import org.riverless.core.actions.MeleeAttackAction;
import org.riverless.core.actions.MoveAction;

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
        updateAllowedActions(troop, position);
        return true;
    }

    public Optional<Position> troopPosition(Troop troop) {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (troopPositions[row][col] == troop) {
                    return Optional.of(new Position(row, col));
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
                updateAllowedActions(troop, position);
            }
        });
    }

    /**
     * Update the current troop's allowed move actions based on the current position.
     * Also checks all adjacent positions and updates the allowed move actions for the adjacent troops.
     */
    private void updateAllowedActions(Troop troop, Position position) {
        for (Direction adjacentDirection : calculatePossibleAdjacentDirections(position)) {
            var adjacentPosition = Position.adjacent(position, adjacentDirection);
            var adjacentTroop = troopAtPosition(adjacentPosition);
            if (positionIsEmpty(adjacentPosition)) {
                // movement
                troop.grantMoveActionFromDirection(adjacentDirection);

                // attack
                troop.revokeAction(new MeleeAttackAction(troop, adjacentTroop));
            } else { // On the adjacent position there is another troop
                // movement
                adjacentTroop.revokeAction(new MoveAction(adjacentTroop, adjacentDirection.opposite()));

                // attack
                if (troop.team() != adjacentTroop.team()) {
                    troop.grantAction(new MeleeAttackAction(troop, adjacentTroop));
                    adjacentTroop.grantAction(new MeleeAttackAction(adjacentTroop, troop));
                }
            }
        }
    }

    private boolean positionIsEmpty(Position position) {
        return positionIsEmpty(position.x(), position.y());
    }

    private boolean positionIsEmpty(int x, int y) {
        return troopPositions[y][x] == null;
    }

    private Troop troopAtPosition(Position position) {
        return troopPositions[position.y()][position.x()];
    }

        private List<Direction> calculatePossibleAdjacentDirections(Position position) {
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
