package org.riverless.core.actions;

import org.riverless.core.troops.units.UnitType;

public class RecruitActionParam implements ActionParam {

    private UnitType type;
    private int amount = 0;

    public RecruitActionParam() {
    }

    @Override
    public boolean isValid() {
        return type != null && amount > 0;
    }

    public void setType(UnitType type) {
        this.type = type;
    }

    public UnitType getType() {
        return type;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
