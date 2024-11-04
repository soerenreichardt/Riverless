package org.riverless.core.actions;

import org.riverless.core.GameContext;
import org.riverless.core.actions.blueprint.BlueprintAction;
import org.riverless.core.actions.blueprint.BlueprintActionParameter;
import org.riverless.core.actions.blueprint.ParameterValidationException;
import org.riverless.core.troops.Troop;
import org.riverless.core.troops.units.Unit;
import org.riverless.core.troops.units.UnitType;

public record RecruitAction(Troop troop) implements BlueprintAction<RecruitAction.RecruitRequest> {

    @Override
    public void execute(GameContext ctx, RecruitRequest request) {
        if (troop.allowedActions().contains(this)) {
            Unit unit = new Unit(request.type());
            for(int i = 0; i < request.amount(); i++) {
                troop.buyUnit(unit);
            }
        }
    }

    @Override
    public RecruitRequest getParameterValues(GameContext ctx) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    public record RecruitRequest(UnitType type, int amount) implements BlueprintActionParameter {
        @Override
        public void validate() throws ParameterValidationException {
            if (amount <= 0) {
                throw new ParameterValidationException("Amount must be greater than 0");
            }
        }
    }
}
