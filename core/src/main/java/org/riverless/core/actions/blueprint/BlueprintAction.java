package org.riverless.core.actions.blueprint;

import org.riverless.core.GameContext;
import org.riverless.core.actions.Action;

public interface BlueprintAction<T extends BlueprintActionParameter> extends Action {
    T getParameterValues(GameContext ctx);

    void execute(GameContext ctx, T value);

    @Override
    default void execute(GameContext ctx) throws ParameterValidationException {
        var value = getParameterValues(ctx);
        value.validate();
        execute(ctx, value);
    }
}
