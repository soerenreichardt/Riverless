package org.riverless.core.troops.effects;

import org.riverless.core.GameContext;
import org.riverless.core.troops.Troop;

public abstract class Effect {

    private long startTime;
    public void apply(Troop troop, GameContext ctx){
        troop.addEffect(this);
        whenStarting(troop,ctx);
        startTime = System.currentTimeMillis();
    }

    public void remove(Troop troop, GameContext ctx){
        whenEnding(troop,ctx);
        troop.removeEffect(this);
    }

    public abstract void whenStarting(Troop troop, GameContext ctx);

    public abstract void whenEnding(Troop troop, GameContext ctx);

    public abstract void update(Troop troop,int delta, GameContext ctx);


    public long getStartTime() {
        return startTime;
    }


}
