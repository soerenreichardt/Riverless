package org.riverless;

import org.riverless.core.map.GameMap;
import org.riverless.core.map.Landscape;
import org.riverless.frontend.GameMapRenderer;

import java.util.concurrent.ArrayBlockingQueue;

public class Riverless {

    public static void main(String[] args) {
        var map = new GameMap(10, 10, new ArrayBlockingQueue<>(100), new ArrayBlockingQueue<>(100));

        Landscape[][] landscapes = new Landscape[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                landscapes[i][j] = Math.random() < 0.3 ? Landscape.LAND : Landscape.WATER;
            }
        }
        map.landscapeLayer().setLandscapes(landscapes);
        System.out.println(new GameMapRenderer(map).render());
    }
}
