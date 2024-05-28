/*
 * Copyright (c) "Neo4j"
 * Neo4j Sweden AB [http://neo4j.com]
 * This file contains proprietary code that is only available via a commercial license from Neo4j.
 * For more information, see https://neo4j.com/contact-us/
 */
package org.riverless.core.map;

public class LandscapeLayer {

    private Landscape[][] landscapes;

    public LandscapeLayer(int width, int height) {
        landscapes = new Landscape[width][height];
    }

    public void setLandscapes(Landscape[][] landscapes) {
        this.landscapes = landscapes;
    }

    public Landscape getLandscape(int x, int y) {
        return landscapes[x][y];
    }
}
