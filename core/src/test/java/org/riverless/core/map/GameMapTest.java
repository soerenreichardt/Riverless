/*
 * Copyright (c) "Neo4j"
 * Neo4j Sweden AB [http://neo4j.com]
 * This file contains proprietary code that is only available via a commercial license from Neo4j.
 * For more information, see https://neo4j.com/contact-us/
 */
package org.riverless.core.map;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;

class GameMapTest {

    @Test
    void shouldInitializeMap() {
        var map = new GameMap(10, 10, new ArrayBlockingQueue<>(100));

        Landscape[][] landscapes = new Landscape[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                landscapes[i][j] = Math.random() < 0.3 ? Landscape.LAND : Landscape.WATER;
            }
        }
        map.landscapeLayer().setLandscape(landscapes);
        System.out.println(map.landscapeLayer().render());

    }

}