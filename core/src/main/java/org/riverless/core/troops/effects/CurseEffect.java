package org.riverless.core.troops.effects;

import org.riverless.core.GameContext;
import org.riverless.core.troops.Troop;

public class CurseEffect extends DurationEffect{

    private int damage;
    public CurseEffect(int duration, int damage) {
        super(duration);
        this.damage = damage;
    }

    @Override
    public void whenUpdating(Troop troop,int delta, GameContext ctx) {
       //do nothing
    }

    @Override
    public void whenStarting(Troop troop, GameContext ctx) {
       //do nothing
    }

    @Override
    public void whenEnding(Troop troop, GameContext ctx) {
        troop.receiveDamage(damage);
    }
}
