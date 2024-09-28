package org.riverless.core.troops.effects;

import org.riverless.core.GameContext;
import org.riverless.core.troops.Troop;

public abstract class DurationEffect extends Effect{


    private int currentDuration;

    public DurationEffect(int duration){
        this.currentDuration = duration;
    }

    @Override
    public void update(Troop troop,int delta, GameContext ctx) {
        whenUpdating(troop,delta,ctx);
        currentDuration -= delta;
        if(currentDuration == 0){
            remove(troop,ctx);
        }
    }


    public abstract void whenUpdating(Troop troop,int delta, GameContext ctx);


    public int getCurrentDuration(){
        return currentDuration;
    }

    public void setCurrentDuration(int currentDuration){
        this.currentDuration = currentDuration;
    }

}
