/*
 * Copyright (c) "Neo4j"
 * Neo4j Sweden AB [http://neo4j.com]
 * This file contains proprietary code that is only available via a commercial license from Neo4j.
 * For more information, see https://neo4j.com/contact-us/
 */
package org.riverless.core.map;

class LandscapeLayer {

    private Landscape[][] landscapes;

    LandscapeLayer(int width, int height) {
        landscapes = new Landscape[height][width];
    }

    void setLandscapes(Landscape[][] landscapes) {
        this.landscapes = landscapes;
    }

    Landscape getLandscape(int x, int y) {
        return landscapes[x][y];
    }

    Landscape[][] landscapes() {
        return landscapes;
    }
}
