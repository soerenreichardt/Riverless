package org.riverless.core;

public abstract class GameObject {
    private GameContext context;
    private boolean initialized = false;

    void initialize(GameContext context) {
        this.context = context;
        this.initialized = true;
    }

    protected GameContext context() {
        return context;
    }
}
