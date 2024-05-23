/*
 * Copyright (c) "Neo4j"
 * Neo4j Sweden AB [http://neo4j.com]
 * This file contains proprietary code that is only available via a commercial license from Neo4j.
 * For more information, see https://neo4j.com/contact-us/
 */
package org.riverless.core.map;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @Test
    void shouldInitializeMap() {
        var map = new Map(10, 10);


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