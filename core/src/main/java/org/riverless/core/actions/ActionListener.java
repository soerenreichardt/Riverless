package org.riverless.core.actions;

import org.riverless.core.events.Event;

import java.util.Optional;

public interface ActionListener {
    Optional<Event> handleAction(Action action);
}
