package org.riverless.core;

import java.util.HashMap;
import java.util.Map;

public class GameContext {

    private final Map<Class<? extends GameObject>, GameObject> resources;

    public GameContext() {
        this.resources = new HashMap<>();
    }

    public <T extends GameObject> T spawnObject(T gameObject) {
        gameObject.initialize(this);
        if (gameObject instanceof Resource) {
            registerResource(gameObject);
        }
        return gameObject;
    }

    public void registerResource(GameObject resource) {
        resources.put(resource.getClass(), resource);
    }

    public <T extends GameObject & Resource> T getResource(Class<T> resourceClass) {
        return resourceClass.cast(resources.get(resourceClass));
    }
}
