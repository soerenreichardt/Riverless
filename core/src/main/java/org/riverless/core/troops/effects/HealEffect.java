package org.riverless.core.troops.effects;

import org.riverless.core.GameContext;
import org.riverless.core.troops.Troop;

public class HealEffect extends DurationEffect{

private int healAmount;
    public HealEffect(int duration, int healAmount) {
        super(duration);
        this.healAmount = healAmount;
    }

    @Override
    public void whenUpdating(Troop troop,int delta, GameContext ctx) {
        troop.heal(healAmount);
    }

    @Override
    public void whenStarting(Troop troop, GameContext ctx) {
        //do nothing
    }

    @Override
    public void whenEnding(Troop troop, GameContext ctx) {
        //do nothing
    }
}
