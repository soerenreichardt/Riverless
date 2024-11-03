package org.riverless.core.actions;

import org.riverless.core.GameContext;
import org.riverless.core.troops.Troop;
import org.riverless.core.troops.units.Unit;
import org.riverless.core.troops.units.UnitType;

public record RecuitAction(Troop troop, RecruitActionParam param) implements Action {

    @Override
    public void execute(GameContext ctx) {
        if (troop.allowedActions().contains(this) && param.isValid()) {
           Unit unit = new Unit(param.getType());
            for(int i = 0; i < param.getAmount(); i++) {
                troop.buyUnit(unit);
            }
        }
    }

    public void setParam(UnitType type, int amount) {
        param.setAmount(amount);
        param.setType(type);
    }
}
