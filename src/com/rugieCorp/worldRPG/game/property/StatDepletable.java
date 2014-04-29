package com.rugieCorp.worldRPG.game.property;

/**
 * User: Adam Chlupacek
 * Date: 01/03/14
 * Time: 23:14
 * Package: com.rugieCorp.worldRPG.game.property
 */
public class StatDepletable {

    private String name;
    private int max;
    private int cur;

    public StatDepletable(int max, int cur, String name) {
        this.name = name;
        this.max = max;
        this.cur = cur;
    }

    public void changeCur(int changeBy){
        cur += changeBy;
    }

    public String getName() {
        return name;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getCur() {
        return cur;
    }

    public void setCur(int cur) {
        this.cur = cur;
    }
}
