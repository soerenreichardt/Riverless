package org.riverless.core.troops.units;

public class Unit {


    private final UnitType type;
    private final UnitStats stats = new UnitStats();
    private int cost;

    public Unit(UnitType type) {
        this.type = type;
        this.cost = 5;//TODO: change this
    }


    public UnitType type(){
        return type;
    }

    public UnitStats stats(){
        return stats;
    }

    public int cost(){
        return 0;
    }
}
