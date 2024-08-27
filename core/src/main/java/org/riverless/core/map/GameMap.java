/*
 * Copyright (c) "Neo4j"
 * Neo4j Sweden AB [http://neo4j.com]
 * This file contains proprietary code that is only available via a commercial license from Neo4j.
 * For more information, see https://neo4j.com/contact-us/
 */
package org.riverless.core.map;

import org.riverless.core.GameObject;
import org.riverless.core.Resource;

public class GameMap extends GameObject implements Resource {

    private final int width;
    private final int height;

    private final LandscapeLayer landscapeLayer;
    private final LocationLayer locationLayer;
    private final TroopLayer troopLayer;

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.landscapeLayer = new LandscapeLayer(width, height);
        this.locationLayer = new LocationLayer(width, height);
        this.troopLayer = new TroopLayer(width, height);
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public void setLandscapes(Landscape[][] landscapes) {
        this.landscapeLayer.setLandscapes(landscapes);
    }

    public Landscape getLandscape(int x, int y) {
        return landscapeLayer.getLandscape(x, y);
    }

    public TroopLayer troopLayer() {
        return troopLayer;
    }
}
