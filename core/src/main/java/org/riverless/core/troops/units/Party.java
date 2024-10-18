package org.riverless.core.troops.units;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Party {

    private final Map<UnitType, ArrayList<Unit>> units = new HashMap<>();

    public Party() {

    }

    public void addUnit(Unit unit) {
        units.computeIfAbsent(unit.type(), k -> new ArrayList<>()).add(unit);
    }

    public ArrayList<Unit> getUnits(UnitType type) {
        return units.get(type);
    }

    public void removeUnit(Unit unit) {
        units.get(unit.type()).remove(unit);
    }

    public int size() {
     return units.values().stream().mapToInt(ArrayList::size).sum();
    }

    public Unit get(UnitType type, int index) {
        return units.get(type).get(index);
    }
}
