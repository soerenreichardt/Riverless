package org.riverless.frontend;

import org.riverless.core.map.GameMap;

public class GameMapRenderer {

    private final GameMap map;

    public GameMapRenderer(GameMap map) {
        this.map = map;
    }

    public String render() {
        var landscape = map.landscapeLayer();
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < map.height(); y++) {
            for (int x = 0; x < map.width(); x++) {
                sb.append(landscape.getLandscape(x, y).symbol());
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
