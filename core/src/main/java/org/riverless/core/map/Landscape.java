/*
 * Copyright (c) "Neo4j"
 * Neo4j Sweden AB [http://neo4j.com]
 * This file contains proprietary code that is only available via a commercial license from Neo4j.
 * For more information, see https://neo4j.com/contact-us/
 */
package org.riverless.core.map;

public enum Landscape {
    LAND("L"),
    WATER("W");

    private final String symbol;

    Landscape(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }
}
