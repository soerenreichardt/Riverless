package org.riverless.core.actions;

import org.riverless.core.GameContext;
import org.riverless.core.exception.RiverlessException;

public interface Action {
    void execute(GameContext ctx) throws RiverlessException;
}
