package com.nhnacademy.starcraft.factories;


import com.nhnacademy.starcraft.unit.Unit;
import com.nhnacademy.starcraft.unit.terran.BattleCruzer;
import com.nhnacademy.starcraft.unit.terran.Goliath;
import com.nhnacademy.starcraft.unit.terran.Marine;
import com.nhnacademy.starcraft.unit.terran.Tank;
import com.nhnacademy.starcraft.unit.terran.Valkyrie;
import com.nhnacademy.starcraft.unit.terran.Wraith;

public class TerranFactory extends UnitFactory {

    String[] units;

    public TerranFactory() {
        units = new String[] {"Marine", "Goliath", "Tank", "Valkyrie", "Wraith", "BattleCruzer"};
    }

    public String[] getUnitNames() {
        return units;
    }

    protected Unit createUnit(String name) {
        Unit unit = null;

        switch (name) {
            case "Marine":
                unit = new Marine();
                break;
            case "Goliath":
                unit = new Goliath();
                break;
            case "Tank":
                unit = new Tank();
                break;
            case "Valkyrie":
                unit = new Valkyrie();
                break;
            case "Wraith":
                unit = new Wraith();
                break;
            case "BattleCruzer":
                unit = new BattleCruzer();
                break;
            default:
                throw new IllegalArgumentException("그런 유닛은 없습니다!");
        }

        return unit;
    }
}
