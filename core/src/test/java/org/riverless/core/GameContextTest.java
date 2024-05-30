package org.riverless.core;

import org.junit.jupiter.api.Test;
import org.riverless.core.actions.ActionListener;
import org.riverless.core.actions.MoveAction;
import org.riverless.core.map.Direction;
import org.riverless.core.map.Troop;

import java.util.LinkedList;

import static org.mockito.Mockito.*;

class GameContextTest {

    @Test
    void shouldForwardActionsToSubscribers() {
        var ctx = new GameContext(new LinkedList<>(), new LinkedList<>());
        var actionListener = mock(ActionListener.class);
        ctx.addActionListener(actionListener);

        var troop = mock(Troop.class);
        ctx.processAction(new MoveAction(troop, 2, Direction.RIGHT));
        verify(actionListener, times(1)).handleAction(eq(new MoveAction(troop, 2, Direction.RIGHT)));
    }
}