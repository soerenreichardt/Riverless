package org.riverless.core.troops.battle;

import org.riverless.core.troops.Troop;

public class MeleeBattle extends Battle {

    public MeleeBattle(Troop attacker, Troop defender) {
        super(attacker, defender);
    }

    @Override
    public void execute() {
        defender().receiveDamage(attacker().damage());
    }


}
