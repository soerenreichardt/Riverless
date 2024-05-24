/*
 * Copyright (c) "Neo4j"
 * Neo4j Sweden AB [http://neo4j.com]
 * This file contains proprietary code that is only available via a commercial license from Neo4j.
 * For more information, see https://neo4j.com/contact-us/
 */
package org.riverless.core.map;

import org.riverless.core.actions.Action;

import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class GameMap {

    private final BlockingQueue<Action> actionQueue;

    private final LandscapeLayer landscapeLayer;
    private final LocationLayer locationLayer;
    private final TroopLayer troopLayer;

    private final MapActionVisitor actionVisitor;

    public GameMap(int width, int height, BlockingQueue<Action> actionQueue) {
        this.actionQueue = actionQueue;
        this.landscapeLayer = new LandscapeLayer(width, height);
        this.locationLayer = new LocationLayer(width, height);
        this.troopLayer = new TroopLayer(Map.of());
        this.actionVisitor = new MapActionVisitor(this);
    }

    public LandscapeLayer landscapeLayer() {
        return landscapeLayer;
    }

    public LocationLayer locationLayer() {
        return locationLayer;
    }

    public TroopLayer troopLayer() {
        return troopLayer;
    }

    public void handleActions() {
        while (!actionQueue.isEmpty()) {
            Action action = actionQueue.poll();
            action.visit(actionVisitor).map(actionQueue::offer);
        }
    }
}
