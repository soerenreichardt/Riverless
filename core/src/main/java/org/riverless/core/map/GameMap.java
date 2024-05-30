/*
 * Copyright (c) "Neo4j"
 * Neo4j Sweden AB [http://neo4j.com]
 * This file contains proprietary code that is only available via a commercial license from Neo4j.
 * For more information, see https://neo4j.com/contact-us/
 */
package org.riverless.core.map;

import org.riverless.core.GameObject;
import org.riverless.core.actions.Action;
import org.riverless.core.actions.ActionListener;
import org.riverless.core.events.Event;

import java.util.Map;
import java.util.Optional;

public class GameMap extends GameObject implements ActionListener {

    private final int width;
    private final int height;

    private final LandscapeLayer landscapeLayer;
    private final LocationLayer locationLayer;
    private final TroopLayer troopLayer;

    private final MapActionVisitor actionVisitor;

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.landscapeLayer = new LandscapeLayer(width, height);
        this.locationLayer = new LocationLayer(width, height);
        this.troopLayer = new TroopLayer(Map.of());
        this.actionVisitor = new MapActionVisitor(this);
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
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

    @Override
    public Optional<Event> handleAction(Action action) {
        return action.visit(actionVisitor);
    }
}
