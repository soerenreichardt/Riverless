package org.riverless.core.troops.battle;

import org.riverless.core.troops.Troop;

public abstract class Battle {
    private final Troop attacker;
    private final Troop defender;


    public Battle(Troop attacker, Troop defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public abstract void execute();

    protected Troop attacker() {
        return attacker;
    }

    protected Troop defender() {
        return defender;
    }
}
