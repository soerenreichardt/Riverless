package org.riverless.core.troops.battle;

import org.riverless.core.troops.Troop;

public class RangedBattle extends MeleeBattle {


    public RangedBattle(Troop attacker, Troop defender) {
        super(attacker, defender);
    }

    @Override
    public void execute() {
        defender().receiveDamage(attacker().damage());
    }
}
