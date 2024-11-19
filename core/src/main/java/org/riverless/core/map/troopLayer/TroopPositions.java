package org.riverless.core.map.troopLayer;

import org.riverless.core.map.Position;
import org.riverless.core.troops.Troop;

public class TroopPositions {

    private final Troop[][] troopPositions;

    public TroopPositions(int width, int height) {
        this.troopPositions = new Troop[height][width];
    }

    public void setTroopPosition(Troop troop,Position position) {
        troopPositions[troop.position().y()][troop.position().x()] = null;
        troopPositions[position.y()][position.x()] = troop;
        troop.setPosition(position);
    }

    public boolean positionIsEmpty(Position position) {
        return troopPositions[position.y()][position.x()] == null;
    }

    public Troop troopAt(Position position) {
        return troopPositions[position.y()][position.x()];
    }
}
