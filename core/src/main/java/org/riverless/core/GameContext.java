package org.riverless.core;

import org.riverless.core.actions.Action;
import org.riverless.core.actions.ActionListener;
import org.riverless.core.events.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GameContext {
    private final Queue<Action> actionQueue;
    private final Queue<Event> eventQueue;

    private final List<ActionListener> actionListeners;

    public GameContext(Queue<Action> actionQueue, Queue<Event> eventQueue) {
        this.actionQueue = actionQueue;
        this.eventQueue = eventQueue;
        this.actionListeners = new ArrayList<>();
    }

    public void addActionListener(ActionListener actionListener) {
        actionListeners.add(actionListener);
    }

    public void publishAction(Action action) {
        actionQueue.add(action);
    }

    void processAction(Action action) {
        for (ActionListener actionListener : actionListeners) {
            actionListener.handleAction(action).map(eventQueue::offer);
        }
    }
}
