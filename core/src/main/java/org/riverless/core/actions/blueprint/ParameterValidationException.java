package org.riverless.core.actions.blueprint;

import org.riverless.core.exception.RiverlessException;

public class ParameterValidationException extends RiverlessException {
    public ParameterValidationException(String message) {
        super(message);
    }
}
