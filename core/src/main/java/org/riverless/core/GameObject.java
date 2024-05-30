package org.riverless.core;

import org.riverless.core.actions.Action;

public abstract class GameObject {
    private GameContext context;
    private boolean initialized = false;

    void initialize(GameContext context) {
        this.context = context;
        this.initialized = true;
    }

    void performAction(Action action) {
        assert initialized : "GameObject not initialized";
        context.publishAction(action);
    }
}
