package org.riverless.core;

import org.riverless.core.actions.Action;
import org.riverless.core.actions.ActionListener;
import org.riverless.core.events.Event;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class GameInstance extends Thread {

    private static final int TARGET_FPS = 60;
    private static final int TARGET_FRAME_TIME_MILLIS = 1000 / TARGET_FPS;

    private final Queue<Action> actionQueue;
    private final Queue<Event> eventQueue;
    private final GameContext context;

    public GameInstance() {
        this.actionQueue = new ArrayBlockingQueue<>(100);
        this.eventQueue = new ArrayBlockingQueue<>(100);
        this.context = new GameContext(actionQueue, eventQueue);
    }

    public <T extends GameObject> T spawnObject(T gameObject) {
        gameObject.initialize(context);
        if (gameObject instanceof ActionListener actionListener) {
            context.addActionListener(actionListener);
        }
        return gameObject;
    }

    @Override
    public void run() {
        try {
            while (true) {
                var start = System.currentTimeMillis();
                while (!actionQueue.isEmpty()) {
                    Action action = actionQueue.poll();
                    context.processAction(action);
                }
                var elapsed = System.currentTimeMillis() - start;
                Thread.sleep(Math.max(TARGET_FRAME_TIME_MILLIS - elapsed, 0));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
