package org.riverless.frontend;

import org.riverless.core.map.GameMap;
import org.riverless.core.map.Landscape;

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
                var renderedLandscape = renderLandscape(landscape.getLandscape(x, y));
                sb.append(renderedLandscape);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private String renderLandscape(Landscape landscape) {
        return switch (landscape) {
            case LAND -> "#";
            case WATER -> "~";
        };
    }
}
