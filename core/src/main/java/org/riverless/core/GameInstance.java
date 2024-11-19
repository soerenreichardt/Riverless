package org.riverless.core;

import org.riverless.core.actions.Action;
import org.riverless.core.map.GameMap;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class GameInstance extends Thread {

    private static final int TARGET_FPS = 60;
    private static final int TARGET_FRAME_TIME_MILLIS = 1000 / TARGET_FPS;

    private final Queue<Action> actionQueue;
    private final GameContext context;

    public GameInstance() {
        this.actionQueue = new ArrayBlockingQueue<>(100);
        this.context = new GameContext();
    }

    public <T extends GameObject> T spawnObject(T gameObject) {
        return context.spawnObject(gameObject);
    }

    @Override
    public void run() {
        try {
            context.spawnObject(new GameMap(10, 10));
            var map = context.getResource(GameMap.class);
            while (true) {
                var start = System.currentTimeMillis();
                while (!actionQueue.isEmpty()) {
                    Action action = actionQueue.poll();
                    action.execute(context);
                }
                map.troopLayer().updateTroopActions(context);
                var elapsed = System.currentTimeMillis() - start;
                Thread.sleep(Math.max(TARGET_FRAME_TIME_MILLIS - elapsed, 0));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
