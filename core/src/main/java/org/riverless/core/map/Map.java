/*
 * Copyright (c) "Neo4j"
 * Neo4j Sweden AB [http://neo4j.com]
 * This file contains proprietary code that is only available via a commercial license from Neo4j.
 * For more information, see https://neo4j.com/contact-us/
 */
package org.riverless.core.map;

public class Map {

    private final LandscapeLayer landscapeLayer;
    private final LocationLayer locationLayer;
    private final TroopLayer troopLayer;

    public Map(int width, int height) {
        this.landscapeLayer = new LandscapeLayer(width, height);
        this.locationLayer = new LocationLayer(width, height);
        this.troopLayer = new TroopLayer(width, height);
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
}
