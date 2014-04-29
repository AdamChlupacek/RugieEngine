package com.rugieCorp.worldRPG.game.property;

import com.rugieCorp.engine.gameobject.component.GameComponent;

/**
 * User: Adam Chlupacek
 * Date: 01/03/14
 * Time: 23:00
 * Package: com.rugieCorp.worldRPG.game.property
 */
public class Stats extends GameComponent{

    private StatDepletable health;
    private StatDepletable mana;
    private StatDepletable stamina;
    private int level;

    public Stats(int health, int mana, int stamina, int level) {
        super("Stats");
        this.health = new StatDepletable(health,health - 25,"health");
        this.mana = new StatDepletable(mana,mana,"mana");
        this.stamina = new StatDepletable(stamina,stamina,"stamina");
        this.level = level;
    }


    public StatDepletable getDepletableStat(String name){
        if (health.getName().equals(name))
            return health;
        if (mana.getName().equals(name))
            return mana;
        if (stamina.getName().equals(name))
            return stamina;

        return new StatDepletable(1,1,"COULD NOT MATCH");
    }

    public int getLevel() {
        return level;
    }
}
