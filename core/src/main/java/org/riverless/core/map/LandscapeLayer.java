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

    public void setLandscape(Landscape[][] landscapes) {
        this.landscapes = landscapes;
    }


    public String render() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < landscapes[0].length; y++) {
            for (int x = 0; x < landscapes.length; x++) {
                sb.append(landscapes[x][y].symbol);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
