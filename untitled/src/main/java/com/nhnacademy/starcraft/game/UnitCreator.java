package com.nhnacademy.starcraft.game;

import com.nhnacademy.starcraft.factories.ProtosFactory;
import com.nhnacademy.starcraft.factories.TerranFactory;
import com.nhnacademy.starcraft.factories.UnitFactory;
import com.nhnacademy.starcraft.factories.ZergFactory;
import com.nhnacademy.starcraft.unit.Unit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UnitCreator {
    private final static int TERRAN_UNIT_COUNT = 5;
    private final static int ZERG_UNIT_COUNT = 8;

    private final static int PROTOS_UNIT_COUNT = 4;
    private List<Unit> units;
    private String race;

    private Random random;


    public UnitCreator(String race) {
        this.units = new ArrayList<>();
        this.random = new Random();
        this.race = race;
    }

    public List<Unit> getUnits() {
        return this.units;
    }

    public UnitCreator randomFactory() {

        int randNum;
        int unitsLength;
        UnitFactory factory;

        switch (this.race) {
            case "Terran":
                factory = new TerranFactory();
                unitsLength = factory.getUnitNames().length;

                for (int i = 0; i < TERRAN_UNIT_COUNT; i++) {
                    randNum = random.nextInt(unitsLength);
                    addUnits(factory.newInstance(factory.getUnitNames()[randNum]));
                }
                break;
            case "Zerg":
                factory = new ZergFactory();
                unitsLength = factory.getUnitNames().length;

                for (int i = 0; i < ZERG_UNIT_COUNT; i++) {
                    randNum = random.nextInt(unitsLength);
                    addUnits(factory.newInstance(factory.getUnitNames()[randNum]));
                }
                break;

            case "Protos":
                factory = new ProtosFactory();
                unitsLength = factory.getUnitNames().length;

                for (int i = 0; i < PROTOS_UNIT_COUNT; i++) {
                    randNum = random.nextInt(unitsLength);
                    addUnits(factory.newInstance(factory.getUnitNames()[randNum]));
                }
                break;
            default:
                break;
        }
        return this;

    }

    public void addUnits(Unit unit) {
        this.units.add(unit);
    }
}
