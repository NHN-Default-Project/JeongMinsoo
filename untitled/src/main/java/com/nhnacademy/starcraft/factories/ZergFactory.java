package com.nhnacademy.starcraft.factories;


import com.nhnacademy.starcraft.unit.Unit;
import com.nhnacademy.starcraft.unit.zerg.Gurdian;
import com.nhnacademy.starcraft.unit.zerg.Hydralisk;
import com.nhnacademy.starcraft.unit.zerg.Mutalisk;
import com.nhnacademy.starcraft.unit.zerg.Queen;
import com.nhnacademy.starcraft.unit.zerg.Ultralisk;
import com.nhnacademy.starcraft.unit.zerg.Zergling;

public class ZergFactory extends UnitFactory {

    String[] units;

    public ZergFactory() {
        units = new String[] {"Gurdian", "Hydralisk", "Mutalisk", "Ultralisk", "Zergling", "Queen"};
    }

    public String[] getUnitNames() {
        return units;
    }

    protected Unit createUnit(String name) {
        Unit unit = null;

        switch (name) {
            case "Gurdian":
                unit = new Gurdian();
                break;
            case "Hydralisk":
                unit = new Hydralisk();
                break;
            case "Mutalisk":
                unit = new Mutalisk();
                break;
            case "Ultralisk":
                unit = new Ultralisk();
                break;
            case "Zergling":
                unit = new Zergling();
                break;
            case "Queen":
                unit = new Queen();
                break;
            default:
                throw new IllegalArgumentException("그런 유닛은 없습니다!");
        }

        return unit;
    }

}
