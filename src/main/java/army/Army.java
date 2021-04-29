package army;


import java.util.*;

public class Army {


    List<MilitaryUnit> army = new ArrayList<>();

    public int getArmySize() {
        return army.size();
    }

    public void addUnit(MilitaryUnit militaryUnit) {
        army.add(militaryUnit);
    }

    public int getArmyDamage() {
        int armyDamage = 0;
        for (MilitaryUnit m: army) {
            armyDamage += m.doDamage();
        }
        return armyDamage;
    }

    public void damageAll(int damage) {
        for (MilitaryUnit m: army) {
            m.sufferDamage(damage);
        }
        Iterator<MilitaryUnit> armyIterator = army.iterator();
        while (armyIterator.hasNext()) {

            if (armyIterator.next().hitPoints < 25) {
                armyIterator.remove();
            }
        }
    }
}
