package com.nhnacademy.starcraft.factories;


import com.nhnacademy.starcraft.unit.Unit;

public abstract class UnitFactory {

    public Unit newInstance(String name) {
        Unit unit = createUnit(name);
        return unit;
    }

    protected abstract Unit createUnit(String name);

    public abstract String[] getUnitNames();


}
